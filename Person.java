import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Person class. A person can:
 * 
 *  1) move left or right based on user keypresses
 *  2) lay a trap to kill spiders
 *  3) have their own health reduced by touching a spider
 *  4) Have their own score increased by not touching a spider
 * 
 * @author Jacob Campbell
 * @version 1.0 3/2/2018
 */
public class Person extends Actor
{
    private int trapsLeft;    // number of traps available to place
    private int timeToWait;   // time until next trap can be placed
    private int personHealth; // remaining health until game over
    private int score;        // current game score
    private int highScore;    // current high score
    
    /**
     * Constructor for objects of class Person.
     * 
     * By default, the person starts with 3 traps, is able to immediately 
     * place a trap, begins with 100 health, begins with a score of zero, 
     * and has not yet achieved a high score.
     */
     public Person() {
        trapsLeft = 3;      // Player begins with 3 traps
        timeToWait = 0;     // Player can immediately place trap
        personHealth = 100; // Player begins with 100 health
        score = 0;          // Starting score is 0
        highScore = 0;      // Before game is played, high score is 0
    }
    
    /**
     * Allows player to move left or right using arrow keys, and place traps
     * using the spacebar; Also decreases health when touched by spider, increases
     * score when not touching spider, showest highest score achieved, and ends
     * game when health reaches 0.
     */
    public void act() 
    {      
        MyWorld scoreboard = (MyWorld)getWorld();      // Reference to MyWorld class
        Scoreboard count = scoreboard.getScoreboard(); // Reference to getScoreboard() method
        
        // Person moves right one pixel per call while right arrow is held down
        if (Greenfoot.isKeyDown("right")) { 
            move(1);
        }
        
        // Person moves left one pixel per call while left arrow is held down
        if(Greenfoot.isKeyDown("left")) {
            move(-1);
        }
        
        // Person places trap at current (x, y) location when spacebar is pressed. 
        //   Player can place one trap 1000 calls after last trap has been placed.
        //   Player can place a maximum of three traps per game
        this.timeToWait = timeToWait;
        if(Greenfoot.isKeyDown("space") && timeToWait <= 0 && trapsLeft > 0) {
            Trap trap = new Trap();
            getWorld().addObject(trap, getX(), getY());
            timeToWait = 1000;
            trapsLeft = count.getTrapsLeft() - 1;
            count.decTrapsLeft();
        }
        timeToWait = timeToWait - 1;
        
        // Person loses one health per call while touching any spider
        if(this.isTouching(Spider.class) && personHealth > 0) {
            personHealth = count.getHealth() - 1;
            count.decHealth();
        }
        
        // Game ends and person is removed from the screen when health reaches 0.
        //   "GAME OVER" is displayed in center of world when game ends
        if(personHealth <= 0) {
            getWorld().removeObject(this);
            scoreboard.showText("GAME OVER", 400, 300);
        }
        
        // Score increases 1 point per call while player is not touching any spider
        if(personHealth > 0 && !(this.isTouching(Spider.class))) {
            score = count.getScore() + 1;
            count.incScore();
        }
        
        // Shows highest score achieved
        if(score > count.getHighScore()) {
            highScore = count.getHighScore() + 1;
            count.setHighScore(highScore);
        }
    } 
}
