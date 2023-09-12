
/**
 * Write a description of class Run here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Run
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Run
     */
    public Run()
    {
        // initialise instance variables
        x = 0;
    }

   public static void main(String [] args){
       KnightsTour x = new KnightsTour();
       x.possibleMoves(3,4);
       x.chooseLocation();
   }
}
