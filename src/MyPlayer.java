import java.awt.*;
import java.sql.SQLOutput;
import java.util.Arrays;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;

    public Board[] losingBoards = new Board[10];
    public Board[] winningBoards = new Board[20];


    public MyPlayer() {
        columns = new int[10];


        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
        print3x3boards();
        //fill columns array with 0's

        Board b = new Board(1,0,0, 0,0);
        losingBoards[0] = b;


    }

    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");




        gameBoard = pBoard;

        int column = 0;
        int row = 0;

        row = 1;
        column = 1;

        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */
        //6,5,4,3,2,1,0
        //cant have 4,6,1 has to be in descending order
        //Starts off with 10,10,10,10,10,10,10,10,10,10

        // add code to fill in the column array
        //so that it represents the gameBoard in number form
        // print your columns array to show it's working

        System.out.println("MY PLAYER CLICKED");

        for (int c = 0; c < columns.length; c++) {
            int count = 0;
            for (int r = 0; r < gameBoard.length; r++) {
                if (gameBoard[r][c].isAlive == true) {
                    count++;
                }
            }

            columns[c] = count;

        }
        System.out.println(Arrays.toString(columns));

        Point myMove;
        myMove = new Point (row, column);

        if (columns[0] == 3 && columns[1] == 3 && columns[2] ==0){
            myMove = new Point(2,1);
        }

        return myMove;
    }

    public void print3x3boards() {
        // using 1 or more for loops, print all possible 3x3 or smaller board states
        //figure out how to cancel out the impossble boards
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                for (int k = 0; k <= 3; k++) {
                    //homework
                    if (i >= j && j>=k) {
                        //System.out.println(i + " " + j + " " + k);
                        System.out.println("   ");
                        oneMove(i, j, k);
                    }
                }
            }
        }
    }

    public void oneMove(int i, int j, int k){
        System.out.println("Possible moves from:"+ i + "," + j + "," + k );

        boolean isWinningBoard = false;

//        int newK = k-1;
//        int newJ = j-1;
//        int newI = i-1;
        //OOX
        //OOX
        //OOO

        for (int newK = k-1; newK >= 0; newK--){
            System.out.println("New Board (Right):" + i + "," + j + "," + newK + " Move to get to the Board:(" + (newK) + "," + 2 + ")");
            // if i j newK == cols array of a losing board then flip boolean to true
//            System.out.println("Move to get to the Board:(" + (newK) + "," + 2 + ")");

//losingBoards = array, losingBoards[0] = Board[0], losingBoard[0].cols = int [], losingBoard[0].cols[0] = int
        }

        for (int newJ = j-1; newJ >=0; newJ--){
            if(newJ >= k){

                System.out.println("1 New Board (Middle):" + i + "," + newJ + "," + k + " Move to get to the board: (" + (newJ) + "," + 1 + ")");


            } else {
                System.out.println("2 New Board (Middle):" + i + "," + newJ + "," + newJ + " Move to get to the Board:(" + (newJ) + "," + 1 + ")");

            }
        }
        for (int newI = i-1; newI >=1; newI--){
            if (newI>=j && newI>=k){
                System.out.println("1 New Board (Left):" + newI + "," + j + "," + k + " Move to get to the Board:(" + (newI) + "," + 0 +")");


            } else if (newI<j && newI>=k) {
                System.out.println("2 New Board (Left):" + newI + "," + newI + "," + k + " Move to get to the Board:(" + (newI) + "," + 0 +")");

            } else {
                System.out.println("3 New Board (Left):" + newI + "," + newI + "," + newI + " Move to get to the Board:(" + (newI) + "," + 0 + ")");

            }


        }


//         if (newI<newK && newJ<newK && newI<newJ){
//             System.out.println("Impossible board");
//         }
        // add board (i,j,k, row, column) to either
        // the "Winners" array or the "losers" array
        // based on isWinningBoard boolean

    }

}






//    if (columns[0] == 3 && columns[1] == 3 && columns[2] ==0){
//myMove = new Point(2,1);
//        }













