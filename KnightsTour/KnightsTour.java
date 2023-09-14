import java.util.*;
/**
 * Write a description of class KnightsTour here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class KnightsTour
{
    // instance variables - replace the example below with your own
    private int[][] board;
    private HashMap<Integer,int[]> moves;
    Scanner myObj = new Scanner(System.in);
    Scanner myObj2 = new Scanner(System.in);
    private int num = 1;
    private int row = (int) (Math.random()*8);
    private int col = (int) (Math.random()*8);
    private int i;
    /**
     * Constructor for objects of class KnightsTour
     */
    public KnightsTour()
    {
        board = new int[8][8];
        moves = new HashMap<Integer,int[]>();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void possibleMoves(int r, int c){
        int[] val;
        i = 0;
        if(r+1 < 8 && c+2 < 8 && board[r+1][c+2] == 0){
            val =new int[]{r+1,c+2};
            moves.put(i,val);
            i++;
        }
        if(r+2 < board.length && c+1 < board[0].length && board[r+2][c+1] ==0){
            val =new int[]{r+2,c+1};
            moves.put(i,val);
            i++;
        }
        if(r-1 >= 0 && c+2 < board[0].length && board[r-1][c+2] == 0){
            val =new int[]{r-1,c+2};
            moves.put(i,val);
            i++;
        }
        if(r-2 >= 0 && c+1 < board[0].length && board[r-2][c+1] == 0){
            val =new int[]{r-2,c+1};
            moves.put(i,val);
            i++;
        }
        if(r-2 >= 0 && c-1 >= 0 && board[r-2][c-1] == 0){
            val =new int[]{r-2,c-1};
            moves.put(i,val);
            i++;
        }
        if(r-1 >= 0 && c-2 >= 0 && board[r-1][c-2] == 0){
            val =new int[]{r-1,c-2};
            moves.put(i,val);
            i++;
        }
        if(r+1 < board.length && c-2 >= 0 && board[r+1][c-2] == 0){
            val =new int[]{r+1,c-2};
            moves.put(i,val);
            i++;
        }
        if(r+2 < board.length && c-1 >= 0 && board[r+1][c-1] == 0){
            val =new int[]{r+2,c-1};
            moves.put(i,val);
            i++;
        }
    }
    public void run(){
        possibleMoves(row,col);
        chooseLocation();
        while(i != 0){
            i=0;
            possibleMoves(row,col);
            chooseLocation();
        }
    }
    public void chooseLocation(){
        board[row][col] = num;
        num++;
        getBoard();
        getHashmap();
        System.out.print("Choose a Location: ");
        int playerChoice = myObj.nextInt();
        
        int[] tempArr = moves.get(playerChoice);
        if(moves.isEmpty()){
            System.out.println("You lose, try again...");
            System.exit(0);
        }
        moves = new HashMap<Integer,int[]>();
        row = tempArr[0];
        col = tempArr[1];
        System.out.print('\u000C');
    }
    public void getHashmap(){
        for(int i = 0; i < moves.size(); i++){
            System.out.println(i + ": " + moves.get(i)[0] + "," + moves.get(i)[1]);
        }
    }
    public void getBoard(){
        System.out.println("|----------------------|");
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print("|"+board[i][j]+"|");
            }       
            System.out.println();
            System.out.println("|----------------------|");
        }
    }
}