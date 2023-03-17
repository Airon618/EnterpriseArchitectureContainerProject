public class BattleShipBoard extends Board {
   private int [][] board1; //computer board
   private String [][] board2;//Player board
   int carrierHits = 0;
   int battleshipHits = 0;
   int cruiserHits = 0;
   int submarineHits = 0;
   int destroyerHits = 0;
   int counter= 0;
   
   public BattleShipBoard() {
      super();
      board1 = new int[10][10];
      board2 = new String[10][10];
      for (int row = 0; row < board2.length; row++) {
         for (int col = 0; col < board2[0].length; col++) {
         board2[row][col] = "*";
         }
      }
   }
   public void vert(int x) {
      int [] ships1 = Ships.createShips();
      int r = (int)(Math.random() * 9);
      int c = (int)(Math.random() * 9) + 1;
         for (int i = 0; i < ships1[x] && (ships1[x] + r+i < board1.length) ; i++) {
            board1[r+i][c] = ships1[x];
         }
      }
   
   public void hori(int x) {
      int[] ships1 = Ships.createShips();
      int r = (int)(Math.random() * 9) + 1;
      int c = (int)(Math.random() * 4) + 1;
         for (int i = 0; i < ships1[x]; i++) {
            board1[r][c+i] = ships1[x];
         }
      }
   
       
     
   public void placeShips() {
      int [] ships1 = Ships.createShips();
      // clears board
         for(int i = 0; i < board1.length; i++){
            for(int j = 0; j < board1[i].length; j++){
               board1[i][j] = 0;
            }
         }
         //places ships
         for (int x = 0; x < ships1.length; x++) {
            int p = ((int)(Math.random() * 2))+ 1;
             if (p == 1) {
               hori(x);
             } else {
               vert(x);
             }
         }
         // counts open water
         int count = 0;
         for(int[] row: board1){
            for(int i: row){
               if(i == 0){
                count++;
               }
            }
         }
         //ensure that all ships are place
         if (count != 83) {
            placeShips();
         }
     }
   
      //displays board
   public String toString() {
      String place = "";
     
      // numbers on the top
      place += " ";
      for (int col = 0; col < board1[0].length; col++) {
         place += " " + (col+1);
      }
      place += "\n";
     
      //letters on the side
      for (int i = 0; i < board1.length; i++) {
         place += (char)(i+65) + " ";
         
         // if there is ship at location, it prints the number of the ship
         for (int x = 0; x < board1[0].length; x++) {
            if (board1[i][x] > 0) {
               place += board1[i][x] + " ";
           } else {
         place += "* ";
            }
         }
         place += "\n";
      }
     
      return place;        
   }
   
   public void printBoard() {    
      for (int col = 0; col < board1[0].length; col++) {
         System.out.print(" " + (col+1));
      }
      System.out.println();

      for (int i = 0; i < board1.length; i++) {
         System.out.print((char)(i+65) + " ");
         for (int x = 0; x < board1[0].length; x++) {
               System.out.print(board2[i][x] + " ");    
         }
        System.out.println();
        }
   }
   public int[][] getBoard() {
      return board1;
 
   }
   public int checkHit(int r, int c, BattleShipBoard cb) {
      int [][] b = cb.getBoard();
        if (b[r][c] == 5) {
         System.out.println("You hit a ship");
         board2[r][c] = "H";
         carrierHits++;
         if (carrierHits == 10) { //if carrierHits reaches 10 then we know carrier is sunk
            System.out.println("You sunk a Cruiser");
            counter++;  // if ship is sunk, add to counter to know that the game ends after 5 ships are sunk
      }
    }
      if (b[r][c] == 4) {
         board2[r][c] = "H";
         System.out.println("You hit a ship");
         battleshipHits++;
         if (battleshipHits == 8) {
            System.out.println("You sunk a Battleship");
            counter++;
         }
      }
      if (b[r][c] == 3) {
         board2[r][c] = "H";
         System.out.println("You hit a ship");
         cruiserHits++;
         if (cruiserHits == 6) {
            System.out.println("You sunk a ship");
            counter++;  
            }
         if (cruiserHits == 12)  {
            System.out.println("You sunk a ship");
            counter++;
         }
      }
      if (b[r][c] == 2) {
         board2[r][c] = "H";
         System.out.println("You hit a ship");
         destroyerHits++;
         if (destroyerHits == 4) {
            System.out.println("You sunk the Destroyer ");
            counter++;
         }
      }
      if (b[r][c] == 0) {
         board2[r][c] = "M";
         System.out.println("You missed");
         }
         return counter;
     }
}