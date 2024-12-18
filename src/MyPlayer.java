import java.awt.*;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;

    public MyPlayer() {
        columns = new int[10];

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
        //fill columns array with 0's

        for (int i = 0; i < columns.length; i++) {
            columns[i] = 0;
//
//        }
//
//        for (int a = 0; a < gameBoard[0].length; a++) {
//            for (int b = 0; b < gameBoard.length; b++) {
//                 {
//                    columns[a]++;
//                }
//            }
//        }
        }
        for (int r = 0; r < columns.length; r++) {
            for (int c = 0; c < columns.length; c++) {
                if (columns.isAlive) {
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



        Point myMove = new Point(row, column);
        return myMove;
    }

}
