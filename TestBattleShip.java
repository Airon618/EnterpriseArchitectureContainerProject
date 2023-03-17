import java.util.Scanner;
import java.util.ArrayList;

public class TestBattleShip {
   public static void main(String [] args) {
      ArrayList<String> guessList = new ArrayList<String>();
      BattleShipBoard CB = new BattleShipBoard();
      BattleShipBoard PB = new BattleShipBoard();
      Scanner in = new Scanner(System.in);
      CB.placeShips();
      //System.out.println(CB); //Uncomment to see where the ships are
      System.out.println(PB);
      System.out.println("Welcome to BattleShip! \nYou have 50 tries to sink all ships.");
      int tries = 50;
      while (tries >= 0) {
         System.out.print("Enter a coordinate as a capital letter and a number without a space: ");
         String guess = in.nextLine();      
         guessList.add(guess);
         String firstLetter = guess.substring(0,1);
         int num = Integer.parseInt(guess.substring(1,guess.length())); //converts string to int
         int value = 0;
         if (firstLetter.equals("A")){
         value = 0;
        }
        else if (firstLetter.equals("B")){
         value = 1;
        }
        else if (firstLetter.equals("C")){
         value = 2;
        }
        else if (firstLetter.equals("D")){
         value = 3;
        }
        else if (firstLetter.equals("E")){
         value = 4;
        }
        else if (firstLetter.equals("F")){
         value = 5;
        }
        else if (firstLetter.equals("G")){
         value = 6;
        }
        else if (firstLetter.equals("H")){
         value = 7;
        }
        else if (firstLetter.equals("I")){
         value = 8;
        }
        else if (firstLetter.equals("J")){
         value = 9;
        }
        PB.checkHit(value, (num-1), CB); // value as the letter, num-1 to match index, cb as the object to reference      
        PB.printBoard();
        System.out.print("Your guesses ");
        for(int i = 0; i < guessList.size(); i++) {
            System.out.print(guessList.get(i) + " ");
            }
        System.out.println();
       
        tries--;
        int WinLose = PB.checkHit(value,(num-1), CB);
        if (WinLose == 5) {
        System.out.println("Congratulations, you won Battleship!");
        break;
          }
        if (tries == 0 && WinLose != 5) {
          System.out.println("Sorry you missed too many times, you lose :(");
          break;
        }
      } 
    }
  }
