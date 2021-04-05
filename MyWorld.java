import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The World for CSC14400 Project#1 (Spring 2018)
 * 
 * @author Stephen Blythe
 * @version 1/2018
 */
public class MyWorld extends World
{
    private Scoreboard scoreboard; // Creates variable of type Scoreboard
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     * Creates a world that has an area of 800x600 pixels, then adds a
     * scoreboard, and an initial person and spider to the world.
     */
    public MyWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        
        // Adds scoreboard to world
        scoreboard = new Scoreboard();
        this.addObject(scoreboard, 400, 0);
        
        // Adds person to bottom center of world
        Person person = new Person();
        this.addObject(person, 400, 580);
        
        //Adds spider to top of world at random X-coordinate
        Spider spider = new Spider();
        this.addObject(spider, Greenfoot.getRandomNumber(getWidth()), 43);
        
    }
    
    /**
     * Allows MyWorld and Person classes to access methods
     * within Scoreboard class when referenced with MyWorld 
     * 
     *   @return variable scoreboard of type Scoreboard
     */
    public Scoreboard getScoreboard() {
        return scoreboard;
    }
    
    /**
     * returns the number of spiders found in the World.
     * 
     * @return number of spiders found. 
     */
    public int getSpiderCount()
    {
        // get list of all spiders and return count found
        //   inside of that list.
        return getObjects(Spider.class).size();
    }
    
    /** 
     * removes all Spider objects from the world. 
     */
    public void removeAllSpiders()
    {
        // get list of all spiders and remove each
        //   spider inside of that list
        removeObjects(getObjects(Spider.class));
    }
 
    /** 
     * removes all Trap objects from the world. 
     */
    public void removeAllTraps()
    {
        // get list of all spiders and remove each
        //   spider inside of that list
        removeObjects(getObjects(Trap.class));
    }
    
    /**
     * Generates new game when player presses "n" key.
     */
    public void act()
    {
        Scoreboard count = this.getScoreboard(); // Reference to Scoreboard class
        
        // Player can press "n" to start a new game once the previous game has ended
        if(Greenfoot.isKeyDown("n") && count.getHealth() <= 0) {
            this.removeAllSpiders(); // Removes all remaming spiders from the world
            this.removeAllTraps();   // Removes all remaining traps from the world
            
            count.setHealth(100);                     // Sets health to 100 on scoreboard
            count.setTrapsLeft(3);                    // Sets traps left to 3 on scoreboard
            count.setScore(0);                        // Sets score to 0
            count.setHighScore(count.getHighScore()); // Shows highest score achieved
            this.showText("", 400, 300);              // Removes "GAME OVER" from screen
            
            // Adds a person to new game
            Person person = new Person();
            this.addObject(person, 400, 580);
            
            // Adds spider to new game
            Spider spider = new Spider();
            this.addObject(spider, Greenfoot.getRandomNumber(getWidth()), 43);
        }
    }
}
