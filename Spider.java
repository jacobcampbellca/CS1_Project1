import greenfoot.*;      // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random; // Imports Random() method from Java API

/**
 * A Spider simply moves up and down in the world.
 * 
 * After being placed into the world, the spider should
 * not move for a random amount of time between 25 and
 * 375 calls to it's act method. 
 * 
 * When this spider comes back to top of the world, add a 
 * new spider
 * 
 * @author Jacob Campbell
 * @version 1.0 3/2/2018
 */
public class Spider extends Actor
{
    private int timeToWait; // Time before new spider begins moving
    
    /**
     * Constructor for objects of class Spider.
     * 
     * By default, spiders are rotated 90 degrees to move up and down along
     * the Y-axis; New spiders must wait a random amount of time, between 25 and
     * 375 calls, before beginning to move.
     */
    public Spider() {
        turn(90); // Rotates spider 90 degrees clockwise
        
        // Generates random integer between 25 and 375] that is stored in variable timeToWait
        //   Spider waits this amount of calls before beginning to move
        Random random = new Random();                     
        timeToWait = random.nextInt((375 - 25) + 1) + 25;
    }
   
    /**
     * Causes spiders to wait a random amount of time, between 25 and 375 calls, 
     * before moving them one pixel per call along the Y-axis; Also adds a new spider
     * once an existing spider has reached the top of the world.
     */
    public void act() 
    {
        // Decreases time new spider must wait before moving.
        //   Spider begins moving when variable timeToWait reaches 0
        //   @return terminates the method until timeToWait is 0
        this.timeToWait = timeToWait;
        if(timeToWait > 0) {
            timeToWait = timeToWait - 1;
            return;
        }
        
        move(1); // Moves spider one pixel per call along the Y-axis
        
        // Spawns new spider when existing spider reaches bottom of scoreboard
        Spider spider = new Spider();
        if(getY() == 43) {
            getWorld().addObject(spider, Greenfoot.getRandomNumber(800), 43);
        }
        
        // Rotates spiders 180 degrees at bottom and top of world
        if(getY() == 43 || getY() == 580) {
            turn(180);     
        }
    }
}
