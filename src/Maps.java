/**
 * Created by s581467 on 12/8/2017.
 */
public class Maps {
    public static int[][] getPortal1(){

        int[][] board = new int[40][30];
        for(int i =0;i<board.length;i++)
        {
            for(int j = 0;j<board[0].length;j++)
            {
                if(i == 0) {
                    board[i][j] = 2;
                }
                if(i==39)
                {
                    board[i][j] =2;
                }

            }
        }

        for(int i = 0;i<board.length;i++)
        {
            board[i][0]=2;
            board[i][29]=2;
        }

        board[1 + (int) (Math.random()*37)][1 + (int) (Math.random()*27)]= 10;
        board[1 + (int) (Math.random()*37)][1 + (int) (Math.random()*27)]= 10;

        return board;
    }

    public static int[][] getRegular(){

        int[][] board = new int[40][30];
        for(int i =0;i<board.length;i++)
        {
            for(int j = 0;j<board[0].length;j++)
            {
                if(i == 0) {
                    board[i][j] = 2;
                }
                if(i==39)
                {
                    board[i][j] =2;
                }

            }
        }

        for(int i = 0;i<board.length;i++)
        {
            board[i][0]=2;
            board[i][29]=2;
        }

        return board;
    }
}
