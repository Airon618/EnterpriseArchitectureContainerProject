import java.util.ArrayList;

public class Board {
   private int [][] board;
   //default board
   public Board() {
      board = new int [10][10];
   }
   public Board(int row, int col) {
      board = new int [row][col];
   }  
   
   public int getValue(int r, int c) {
      return board[r][c];
   }
   public void setValue(int r, int c, int value) {
      this.board[r][c] = value;
   }
   
   public int[][] getBoard(){
      return board;
   }

   }
  