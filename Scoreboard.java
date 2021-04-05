import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Scoreboard for CSC14400 Project #1 (Spring 2018)
 * 
 * Although you may modify this code, doing such is HIGHLY
 * inadvisable. 
 * 
 * @author Stephen Blythe 
 * @version 1/2018
 */
public class Scoreboard extends Actor
{
    private int score;     // current game score
    private int lifeLeft;  // life amount player has left
    private int highScore; // current high score
    private int trapsLeft; // number of traps player still has
    
    /**
     * Constructor for objects of class Scoreboard.
     * 
     * By default, the scoreboard has a score and highScore of 0,
     * a life left of 100, and a traps left of 3.  
     * 
     */
    public Scoreboard()
    {
        score=0;        // starting score is 0 
        highScore=0;    // before a game is played, high is 0
        lifeLeft=100;   // player starts with 100 life
        trapsLeft=3;    // payer starts with 3 traps
    }
    
    /**
     * after a Scoreboard is added to world, this method is
     * automatically called. In this case, it builds
     * this Scoreboard's image to match the width of 
     * the world this Scoreboard object was placed into.
     */
    protected void addedToWorld(World w)
    { 
        // build an image for the scoreboard - it should be as wide
        //   as the world in which it resides
        GreenfootImage img = new GreenfootImage(w.getWidth(), 40);

        // use the image just build to represent this object
        setImage(img);
        
        // redraw the image.
        redraw();
    }
    
    /**
     * redraws the scoreboard image to represent any updated
     * statistics. 
     * 
     * NOTE: Since this method is private, you may not call
     *    it from outside of this class. It will also not
     *    appear in the javadoc documentation for the public
     *    intreface. 
     *    
     *    If you find yourself needing to call this method
     *    directly, you should probably rethink what you 
     *    are doing. 
     */
    private void redraw()
    {
        // get the current image
        GreenfootImage img = getImage();
        
        // the scoreboards backgroud should be LIGHT_GRAY
        img.setColor(Color.LIGHT_GRAY);
        img.fill();
        
        // draw all text in BLACK
        img.setColor(Color.BLACK);
        
        // build an appropriately sized font and use it. 
        Font myFont=new Font(18);
        img.setFont(myFont);
        
        // draw stats strings into image
        img.drawString("Health:"+lifeLeft, 20, 35);
        img.drawString("Traps Left:"+trapsLeft, 150,35);
        img.drawString("Score:"+score, 400, 35);
        img.drawString("High Score:"+highScore, 575, 35);
    }
    
    /**
     * returns the height of the scoreboard. 
     * 
     *   @return this scoreboard's height (in pixels)
     */
    public int getHeight()
    {
        // return this object's image's height
        return getImage().getHeight();
    }
    
    /**
     * returns the width of the scoreboard. 
     * 
     *   @return this scoreboard's width (in pixels)
     */
    public int getWidth()
    {
        // return this object's image's width
        return getImage().getWidth();
    }
    
    /**
     * returns the health value from the scoreboard
     * 
     *   @return health value displayed in scorebaord
     */    
    public int getHealth()
    {
        return lifeLeft;
    }
    
    /**
     * returns the number of traps left from the scoreboard
     * 
     *   @return trap count value displayed in scorebaord
     */ 
    public int getTrapsLeft()
    {
        return trapsLeft;
    }
    
    /**
     * returns the player score from the scoreboard
     * 
     *   @return score value displayed in scorebaord
     */
    public int getScore()
    {
        return score;
    }
    
    /**
     * returns the high score from the scoreboard
     * 
     *   @return high score value displayed in scorebaord
     */    
    public int getHighScore()
    {
        return highScore;
    }

    /**
     * adds one to the score value in the scoreboard
     */
    public void incScore()
    {
        score++;  // add one to score
        redraw(); // update image to include new score
    }
        
    /**
     * decrements one from the health value in the scoreboard
     */
    public void decHealth()
    {
        lifeLeft--; // decrease health
        redraw();   // update image to include new health value
    }
    
    /**
     * decrements one from the traps value in the scoreboard
     */
    public void decTrapsLeft()
    {
        trapsLeft--;  // one less trap left now
        redraw();     // update image to include new trap count
    }
    
    /**
     * updates the scoreboard's health value as specified
     * 
     * @param newHealth - the new health value to display
     */
    public void setHealth(int newHealth)
    {
        lifeLeft = newHealth; // update health
        redraw();             // update image
    }
    
    
    /**
     * updates the scoreboard's trap count value as specified
     * 
     * @param newTraps - the new trap count value to display
     */
    public void setTrapsLeft(int newTraps)
    {
        trapsLeft = newTraps; // update trap count
        redraw();             // update image
    }
    
    /**
     * updates the scoreboard's score value as specified
     * 
     * @param newScore - the new score value to display
     */
    public void setScore(int newScore)
    {
        score = newScore;    // update score value
        redraw();            // update image
    }
    
    /**
     * updates the scoreboard's high score value as specified
     * 
     * @param newHighScore - the new high score value to display
     */
    public void setHighScore(int newHighScore)
    {
        highScore = newHighScore; // update high score value
        redraw();                 // update image
    }
}
