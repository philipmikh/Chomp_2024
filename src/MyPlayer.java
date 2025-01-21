import java.awt.*;
import java.util.Arrays;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    public Board[] losingBoards = new Board[10];
    public Board[] winningBoards = new Board[20];

    public int losingBoardCount = 0;
    public int winningBoardCount = 0;

    public MyPlayer() {
        columns = new int[3];
        //losingBoards (1, 0, 0, 0, 0)
//        first losing board
        print3x3boards();
    }

    public Point move(Chip[][] pBoard) {
        //System.out.println("MyPlayer Move");
        gameBoard = pBoard;

        int row = 0;
        int column = 0;

        for (int c = 0; c < columns.length; c++) {
            int count = 0;
            for (int r = 0; r < gameBoard.length; r++) {
                if (gameBoard[r][c].isAlive) {
                    count++;
                }
            }
            columns[c] = count;
        }

        // Compare current board with known winning boards/moves
        for (int i = 0; i < winningBoardCount; i++) {
            if (Arrays.equals(columns, winningBoards[i].cols)) {
                row = winningBoards[i].winRow;
                column = winningBoards[i].winCol;
                //System.out.println("Winning Move: (" + row + ", " + column + ")");

            }
        }

        Point myMove = new Point(row, column);
        return myMove;
    }

    public void print3x3boards() {
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                for (int k = 0; k <= 3; k++) {
                    if (i >= j && j >= k) {
                        oneMove(i, j, k);
                    }
                }
            }
        }
    }

    public void oneMove(int i, int j, int k) {
        //System.out.println("Main Board: " + i + "," + j + "," + k);
        boolean isWinningBoard = false;
        int winningMoveRow = -1;
        int winningMoveCol = -1;

        //right
        for (int newK = k - 1; newK >= 0; newK--) {
            // System.out.println("New Board (Right): " + i + "," + j + "," + newK + " Move to get to the Board:(" + newK + ", 2)");

            if (isLosingBoard(i, j, newK)) {
                isWinningBoard = true;
                winningMoveRow = newK;
                winningMoveCol = 2;
            }
        }
        //midle
        for (int newJ = j - 1; newJ >= 0; newJ--) {

            if (newJ >= k && isLosingBoard(i, newJ, k)) {
                //System.out.println("1New Board (Middle): " + i + "," + newJ + "," + k + " Move to get to the Board:(" + newJ + ", 1)");
                isWinningBoard = true;
                winningMoveRow = newJ;
                winningMoveCol = 1;
            } else if (newJ < k && isLosingBoard(i, newJ, newJ)) {
                //System.out.println("2New Board (Middle): " + i + "," + newJ + "," + k + " Move to get to the Board:(" + newJ + ", 1)");
                isWinningBoard = true;
                winningMoveRow = newJ;
                winningMoveCol = 1;
            }
        }
        //left
        for (int newI = i - 1; newI >= 1; newI--) {

            if (newI >= j && newI >= k && isLosingBoard(newI, j, k)) {
                // System.out.println("1New Board (Left): " + newI + "," + j + "," + k + " Move to get to the Board:(" + newI + ", 0)");
                isWinningBoard = true;
                winningMoveRow = newI;
                winningMoveCol = 0;

            } else if (newI < j && newI >= k) {
                // System.out.println("2New Board (Left): " + newI + "," + j + "," + k + " Move to get to the Board:(" + newI + ", 0)");
                if (isLosingBoard(newI, newI, k)) {
                    isWinningBoard = true;
                    winningMoveRow = newI;
                    winningMoveCol = 0;
                    break;
                }
            } else {
                if (newI < j && newI < k && isLosingBoard(newI, newI, newI)) {
                    // System.out.println("3New Board (Left): " + newI + "," + j + "," + k + " Move to get to the Board:(" + newI + ", 0)");
                    isWinningBoard = true;
                    winningMoveRow = newI;
                    winningMoveCol = 0;
                }
            }
        }

        //final descion on winning or losing board
        if (isWinningBoard) {
            storeBoard(new Board(i, j, k, winningMoveRow, winningMoveCol), true);
        } else {
            storeBoard(new Board(i, j, k, 0, 0), false);
        }
    }
    //check if ijk already losing board
    public boolean isLosingBoard(int i, int j, int k) {
        for (int x = 0; x < losingBoardCount; x++) {
            if (losingBoards[x].cols[0] == i && losingBoards[x].cols[1] == j && losingBoards[x].cols[2] == k) {
                return true;
            }
        }
        return false;
    }
    //storing board
    public void storeBoard(Board board, boolean isWinningBoard) {
        if (isWinningBoard) {
            winningBoards[winningBoardCount++] = board;
            //System.out.println("Winning board: " + Arrays.toString(board.cols));
        } else {
            losingBoards[losingBoardCount++] = board;
            //System.out.println("Losing board: " + Arrays.toString(board.cols));
        }
    }
}