import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Trap class should remove the first five spiders that
 * touch it, and then remove itself from the World.
 * 
 * @author Jake Campbell
 * @version 1.0 3/2/2018
 */
public class Trap extends Actor
{
   private int spidersToKill; // Number of spiders each trap can kill
    
    /**
     * Constructor for objects of class Trap.
     * 
     * By default, each trap can kill a maximum of 5 spiders
     */
    public Trap() {
           spidersToKill = 5; // Number of spider each trap can kill
    }
 
    /**
     * Determines if spider has touched a trap, removing the spider from the world
     * when it has done so; Also causes trap to be removed when it has killed a total
     * of 5 spiders.
     */
    public void act() 
    {  
        // Determines if spider has touched a trap.
        //   Spider removed from world if touched by trap (unless last spider remaining).
        //   Once spider is removed, trap can kill one less spider
        Actor spider = getOneIntersectingObject(Spider.class);
        MyWorld spiderCount = (MyWorld)getWorld();
        if(this.isTouching(Spider.class) && spiderCount.getSpiderCount() > 1)  {
            getWorld().removeObject(spider);
            spidersToKill = spidersToKill - 1;
        }

        // Trap is removed from world when it has killed 5 spiders
        if(spidersToKill <= 0) {
            getWorld().removeObject(this);
        }
    }
}
