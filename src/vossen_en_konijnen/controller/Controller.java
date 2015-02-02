package vossen_en_konijnen.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.sound.sampled.*;
import javax.swing.*;

import sun.applet.Main;
import vossen_en_konijnen.model.*;
import vossen_en_konijnen.model.actor.*;
import vossen_en_konijnen.view.*;

public class Controller extends JFrame
{
    // Constants representing configuration information for the simulation.
    // The default width for the grid.
    private static final int DEFAULT_WIDTH = 120;
    // The default depth of the grid.
    private static final int DEFAULT_DEPTH = 80;
    // The probability that a lynx will be created in any given grid position.
    private static double lynxCreationProbability = 0.01;
    // The probability that a fox will be created in any given grid position.
    private static double foxCreationProbability = 0.02;
    // The probability that a rabbit will be created in any given grid position.
    private static double rabbitCreationProbability = 0.08;
    // The probability that a hunter will be created in any given grid position.
    private static double hunterCreationProbability = 0.005;
    // The probability that a rock will be created in any given grid position.
    private static double rockCreationProbability = 0.05;
    // The probability that grass will be created in any given grid position.
    private static double grassCreationProbability = 0.14;
    
    private static int simulationSpeed = 100;
    
    private static final String VERSION = "Version 1.0";
    
    private ArrayList<AbstractView> views;
    
    // A map for storing colors for participants in the simulation
    private Map<Class, Color> colors;
    // A statistics object computing and storing simulation information
    private FieldStats stats;

    // List of animals in the field.
    private List<Actor> actors;
    // The current state of the field.
    private Field field;
    // The current step of the simulation.
    private int step;
    
    private volatile boolean simulatorRun;
    
    private volatile boolean hunderdstepRun;
    
    private volatile boolean started;
    
    private static boolean mute = false;
    
    // Colors used for empty locations.
    private static final Color EMPTY_COLOR = Color.white;

    // Color used for objects that have no defined color.
    private static final Color UNKNOWN_COLOR = Color.gray;

    private final String STEP_PREFIX = "Step: ";
    private final String POPULATION_PREFIX = "Population: ";
    private JButton oneStep, hundredStep, reset, disease, start, stop;
    private JLabel stepLabel, population;
    
    private JMenuBar menubar;
    private JMenu helpMenu;
    private JMenuItem aboutItem;
    private JMenu fileMenu;
    private JMenuItem settingsItem;
    
    SimulatorThread thread = new SimulatorThread();
    
    public Controller()
    {
        this(DEFAULT_DEPTH, DEFAULT_WIDTH);
    }
    
    /**
     * Create a simulation field with the given size.
     * @param depth Depth of the field. Must be greater than zero.
     * @param width Width of the field. Must be greater than zero.
     */
    public Controller(int depth, int width)
    {
        if(width <= 0 || depth <= 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
        }
        
        actors = new ArrayList<Actor>();
        field = new Field(depth, width);
        views = new ArrayList<AbstractView>();
        stats = new FieldStats();
        colors = new LinkedHashMap<Class, Color>();

        Color brown = new Color(169, 39, 19);
        
        setColor(Rabbit.class, Color.yellow);
        setColor(Fox.class, Color.blue);
        setColor(Lynx.class, Color.red);
        setColor(Hunter.class, Color.black);
        setColor(Rock.class, brown);
        setColor(Grass.class, Color.green);
        makeFrame(depth, width);
        
        // Setup a valid starting point.
        reset();
    }
    
    /**
     * Setter for rabbit creation probability
     * @param probability
     */
    public static void setRabbitCreationProbability(double probability)
    {
    	rabbitCreationProbability = probability;
    }
    
    /**
     * Setter for fox creation probability
     * @param probability
     */
    public static void setFoxCreationProbability(double probability)
    {
    	foxCreationProbability = probability;
    }
    
    /**
     * Setter for creation probability
     * @param probability
     */
    public static void setLynxCreationProbability(double probability)
    {
    	lynxCreationProbability = probability;
    }
    
    /**
     * Setter for grass creation probability
     * @param probability
     */
    public static void setGrassCreationProbability(double probability)
    {
    	grassCreationProbability = probability;
    }
    
    /**
     * Setter for hunter creation probability
     * @param probability
     */
    public static void setHunterCreationProbability(double probability)
    {
    	hunterCreationProbability = probability;
    }
    
    /**
     * Setter for rock creation probability
     * @param probability
     */
    public static void setRockCreationProbability(double probability)
    {
    	rockCreationProbability = probability;
    }
    
    /**
     * setter for using mute sounds
     * @param useMute
     */
    public static void setMute(boolean useMute)
    {
    	mute = useMute;
    }
    
    /**
     * Set the speed for the simulation flow
     * @param speed
     */
    public static void setSimulationSpeed(int speed)
    {
    	simulationSpeed = speed;
    }
    
    /**
     * Getter for rabbit creation probability.
     * @return rabbitCreationProbability
     */
    public static double getRabbitCreationProbability()
    {
    	return rabbitCreationProbability;
    }
    
    /**
     * Getter for fox creation probability.
     * @return foxCreationProbability
     */
    public static double getFoxCreationProbability()
    {
    	return foxCreationProbability;
    }
    
    /**
     * Getter for lynx creation probability.
     * @return lynxCreationProbability
     */
    public static double getLynxCreationProbability()
    {
    	return lynxCreationProbability;
    }
    
    /**
     * Getter for grass creation probability.
     * @return grassCreationProbability
     */
    public static double getGrassCreationProbability()
    {
    	return grassCreationProbability;
    }
    
    /**
     * Getter for hunter creation probability.
     * @return hunterCreationProbability
     */
    public static double getHunterCreationProbability()
    {
    	return hunterCreationProbability;
    }
    
    /**
     * Getter for rock creation probability.
     * @return rockCreationProbability
     */
    public static double getRockCreationProbability()
    {
    	return rockCreationProbability;
    }
    
    /**
     * Getter for the simulation speed.
     * @return simulationSpeed
     */
    public static int getSimulationSpeed()
    {
    	return simulationSpeed;
    }
    
    /**
     * @return The color to be used for a given class of animal.
     */
    public Color getColor(Class animalClass)
    {
        Color col = colors.get(animalClass);
        if(col == null) {
            // no color defined for this class
            return UNKNOWN_COLOR;
        }
        else {
            return col;
        }
    }
    
    /**
     * Run the simulation from its current state for a single step.
     * Iterate over the whole field updating the state of each
     * fox and rabbit.
     */
    public synchronized void simulateOneStep()
    {
        step++;
        
        // Provide space for newborn animals.
        List<Actor> newActors = new ArrayList<Actor>();        
        // Let all animals act.
        for(Iterator<Actor> it = actors.iterator(); it.hasNext(); ) {
            Actor actor = it.next();
            actor.act(newActors);
            if(! actor.isActive()) {
                it.remove();
            }
        }
                 
        // Add the newly born foxes and rabbits to the main lists.
        actors.addAll(newActors);

        showStatus(step, field);
    }
    
    /**
     * Simulate one hundred steps.
     */
    public synchronized void hunderdSteps()
    {
        HunderdStepsThread thread2 = new HunderdStepsThread();
        thread2.start();
        hunderdstepRun = true;
    }
    
    /**
     * Set boolean started if simulation is not yet started.
     * Thread will start.
     */
    public void start()
    {        
        if(!started){
            started = true;
            thread.start();
        }
    }
    
    /**
     * Stop the simulation so thread will stop or resume.
     */
    public void stop()
    {
        thread.stopResume();
    }
        
    /**
     * Reset the simulation to a starting position.
     */
    public void reset()
    {
        hunderdstepRun = false;
        started = false;
        step = 0;
        actors.clear();
        Randomizer.reset();
        stats.clearHistory();
        populate();
        
        // Show the starting state in the view.
        showStatus(step, field);
    }
    
    public void showAbout()
    {
		JOptionPane.showMessageDialog(this,
		"Fox and Rabbit Simulation\n" + VERSION,
		"About Fox and Rabbit Simulation",
		JOptionPane.INFORMATION_MESSAGE
		);
    }
    
    
    
    /**
     * If sounds are muted return true.
     * @return boolean true if muted, false if sounds are being used.
     */
    public static boolean isMuted()
    {
    	return mute;
    }
    
    /**
     * Randomly populate the field with foxes and rabbits.
     */
    private void populate()
    {
        Random rand = Randomizer.getRandom();
        field.clear();
        for(int row = 0; row < field.getDepth(); row++) {
            for(int col = 0; col < field.getWidth(); col++) {
            	boolean gender = rand.nextBoolean();
                if(rand.nextDouble() <= foxCreationProbability) {
                    Location location = new Location(row, col);
                    Fox fox = new Fox(true, field, location, gender);
                    actors.add(fox);
                }
                else if(rand.nextDouble() <= rabbitCreationProbability) {
                    Location location = new Location(row, col);
                    Rabbit rabbit = new Rabbit(true, field, location, gender);
                    actors.add(rabbit);
                }
                else if(rand.nextDouble() <= lynxCreationProbability) {
                    Location location = new Location(row, col);
                    Lynx lynx = new Lynx(true, field, location, gender);
                    actors.add(lynx);
                }
                else if(rand.nextDouble() <= hunterCreationProbability) {
                    Location location = new Location(row, col);
                    Hunter hunter = new Hunter(field, location);
                    actors.add(hunter);
                }
                else if(rand.nextDouble() <= rockCreationProbability) {
                    Location location = new Location(row, col);
                    Rock rock = new Rock(field, location);
                    actors.add(rock);
                }
                else if(rand.nextDouble() <= grassCreationProbability) {
                    Location location = new Location(row, col);
                    Grass grass = new Grass(true, field, location);
                    actors.add(grass);
                }
                // else leave the location empty.
            }
        }
    }
    
    /**
     * Make the GUI for the simulation.
     * @param height
     * @param width
     */
    public void makeFrame(int height, int width)
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setTitle("Fox and Rabbit Simulation");
        stepLabel = new JLabel(STEP_PREFIX, JLabel.CENTER);
        population = new JLabel(POPULATION_PREFIX, JLabel.CENTER);
        
        setLocation(100, 50);
        
        AbstractView fieldView = new FieldView(this, stats, height, width);
        AbstractView pieView = new PieView(this, stats, height, width);
        AbstractView lineView = new LineView(this, stats, height, width);
        AbstractView barView = new BarView(this, stats, height, width);
        
        views.add(fieldView);
        views.add(pieView);
        views.add(lineView);
        views.add(barView);
        
        Container buttonView = new JPanel();
        buttonView.setLayout(new GridLayout(0,1,0,20));
        Container buttonViewSub = new JPanel();
        buttonViewSub.setLayout(new GridLayout(8, 1));
        Container legendaView = new JPanel();
        legendaView.setLayout(new GridLayout(0,1));
        
        start = new JButton("Start");
        start.addActionListener((new SimulationActionListeners()));
        buttonViewSub.add(start, 0);
        stop = new JButton("Stop/Resume");
        stop.addActionListener((new SimulationActionListeners()));
        buttonViewSub.add(stop, 1);
        buttonViewSub.add(new JLabel(""), 2);
        oneStep = new JButton("1 step");
        oneStep.addActionListener((new SimulationActionListeners()));
        buttonViewSub.add(oneStep, 3);
        hundredStep = new JButton("100 steps");
        hundredStep.addActionListener((new SimulationActionListeners()));
        buttonViewSub.add(hundredStep, 4);
        buttonViewSub.add(new JLabel(""), 5);
        disease = new JButton("Disease");
        disease.addActionListener((new SimulationActionListeners()));
        buttonViewSub.add(disease, 6);
        reset = new JButton("Reset");
        reset.addActionListener((new SimulationActionListeners()));
        buttonViewSub.add(reset, 7);
        
    	JLabel a = new JLabel("Legenda: ", SwingConstants.CENTER);
    	legendaView.add(a);
        
        for(Class actor: colors.keySet()) {
        	Color c = colors.get(actor);
        	JLabel l = new JLabel(actor.getSimpleName(), SwingConstants.CENTER);
        	l.setForeground(c);
        	l.setOpaque(true);
        	l.setBackground(Color.GRAY);
        	legendaView.add(l);
        }

        buttonView.add(buttonViewSub);
        buttonView.add(legendaView);
        
        menubar = new JMenuBar();
        setJMenuBar(menubar);
        fileMenu = new JMenu("File");
        menubar.add(fileMenu);
        settingsItem = new JMenuItem("Settings");
        settingsItem.addActionListener((new SimulationActionListeners()));
        fileMenu.add(settingsItem);
        helpMenu = new JMenu("Help");
        menubar.add(helpMenu);
        aboutItem = new JMenuItem("About");
        aboutItem.addActionListener((new SimulationActionListeners()));
        helpMenu.add(aboutItem);

        JTabbedPane viewContainer = new JTabbedPane();
        viewContainer.addTab("Field Chart", null, fieldView);
        viewContainer.addTab("Pie Chart", null, pieView);
        viewContainer.addTab("Line Chart", null, lineView);
        viewContainer.addTab("Bar Chart", null, barView);
        
        Container contents = getContentPane();
        contents.add(stepLabel, BorderLayout.NORTH);
        contents.add(viewContainer, BorderLayout.CENTER);
        contents.add(population, BorderLayout.SOUTH);
        contents.add(buttonView, BorderLayout.WEST);
        
        pack();
        setVisible(true);
    }

    
    
    /**
     * Start a disease so rabbits will get ill.
     */
    public void startDisease()
    {
        for(Iterator<Actor> it = actors.iterator(); it.hasNext(); ) {
            Actor actor = it.next();
            if(actor instanceof Rabbit) {
            	((Rabbit) actor).setZiekte(Randomizer.getRandomZiekte());
            }
        }
    }
    
    /**
     * Show the current status of the field.
     * @param step Which iteration step it is.
     * @param field The field whose status is to be displayed.
     */
    public void showStatus(int step, Field field)
    {
        if(!isVisible()) {
            setVisible(true);
        }
            
        stepLabel.setText(STEP_PREFIX + step);
        stats.reset();
        
        Iterator it = views.iterator();
        
        while(it.hasNext()) {
        	AbstractView view = (AbstractView) it.next();
        	view.preparePaint();
        }

        it = views.iterator();
        
        while(it.hasNext()) {
        	AbstractView view = (AbstractView) it.next();
	        if(view instanceof FieldView) {
	        	FieldView fieldView = (FieldView) view;
		        for(int row = 0; row < field.getDepth(); row++) {
		            for(int col = 0; col < field.getWidth(); col++) {
		                Object animal = field.getObjectAt(row, col);
		                if(animal != null) {
		                    stats.incrementCount(animal.getClass());
		                    Color c;
		                    if(animal instanceof Rabbit) {
		                    	Rabbit r = (Rabbit) animal;
		                    	if(r.getZiekte()){
		                    		c = new Color(255,95,1);
		                    	}
		                    	else { c = getColor(animal.getClass()); }
		                    }
		                    else { c =getColor(animal.getClass()); }
		                    fieldView.drawMark(col, row, c);
		                }
		                else {
		                    fieldView.drawMark(col, row, EMPTY_COLOR);
		                }
		            }
		        }
		        stats.countFinished();
		        stats.addHistory();
	        }
	        else {
	        	view.paintChart();
	        }
        }

        population.setText(POPULATION_PREFIX + stats.getPopulationDetails(field));
        
        it = views.iterator();
        
        while(it.hasNext()) {
        	AbstractView view = (AbstractView) it.next();
        	view.repaint();
        }
    }

    /**
     * Determine whether the simulation should continue to run.
     * @return true If there is more than one species alive.
     */
    public boolean isViable(Field field)
    {
        return stats.isViable(field);
    }
    
    
    
    /**
     * If sounds not muted, play a sound effect
     * @param url
     */
    public static synchronized void playSound(final String url)
    {
    	if (!mute) {
	        new Thread(new Runnable() 
	        {
	            public void run()
	            {
	                try {
	                    Clip clip = AudioSystem.getClip();
	                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
	                    Main.class.getResourceAsStream("../../sounds/" + url));
	                    clip.open(inputStream);
	                    clip.start();
	                }
	                catch (Exception e) {
	                    System.err.println(e.getMessage());
	                }
	            }
			}).start();
    	}
    }
    
    /**
     * Define a color to be used for a given class of animal.
     * @param animalClass The animal's Class object.
     * @param color The color to be used for the given class.
     */
    public void setColor(Class animalClass, Color color)
    {
        colors.put(animalClass, color);
    }
    
    /**
     * Inner class for action listeners
     */
    class SimulationActionListeners implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
	String s = e.getActionCommand();
			
	if(s.equals("1 step")) {simulateOneStep(); }
	if(s.equals("100 steps")) {hunderdSteps(); }
        if(s.equals("Reset")) {reset(); playSound("rewind.wav"); }
        if(s.equals("Disease")) {startDisease(); playSound("disease.wav"); }
        if(s.equals("About")) { showAbout(); }
        if(s.equals("Settings")) { new SliderController(); }
        if(s.equals("Start")) {start(); }
        if(s.equals("Stop/Resume")) {stop(); }
		}
    }
    
    /**
     * Inner class for one step thread
     */
    class SimulatorThread extends Thread {
        SimulatorThread() {
            super("onestepthread");
        }

        public void run() {
            Thread thisThread = Thread.currentThread();
            while (thread == thisThread) {
            try {
                Thread.sleep(simulationSpeed);

                synchronized(this) {
                    while (simulatorRun)
                        wait();
                        if(started) {
                            simulateOneStep();
                        }
                }
            } catch (InterruptedException e){}
            }
        }
        
        public synchronized void stopResume() {
            simulatorRun = !simulatorRun;

            if (!simulatorRun)
            notify();
        }
    }
    
    /**
     * Inner class for hundred steps thread
     */
    class HunderdStepsThread extends Thread {
        HunderdStepsThread() {
            super("hunderdstepsthread");
        }

        @Override
        public synchronized void run() {
            
            for (int i = 0; i<100; i++) {
                if(hunderdstepRun) {
                    simulateOneStep();
                }
                try {
                    sleep(simulationSpeed);
                }
                catch (InterruptedException e){}
            }
        }
    }
}
