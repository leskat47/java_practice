import java.io.*;

public class Blackjack {

  public static void playGame() {

    Cards playerCards = new Cards();

    String[] dealtCards = new String[10];
    dealtCards[0] = playerCards.getCard(playerCards.faces);
    dealtCards[1] = playerCards.getCard(playerCards.faces);

    System.out.println("Your first card is " + dealtCards[0]);
    System.out.println("Your second card is " + dealtCards[1]);
    if(getTotal(dealtCards) > 21){
      System.out.println("You busted!");
    };

  }
// take array and return total points
  public static int getTotal(String[] cards) {
    int total = 0;
    for(String card : cards) {
      if (card != null) {
        try {
          total += Integer.parseInt(card);
        } catch(NumberFormatException e) {
          if(card == "J") {
            total += 11;
          } else if (card == "Q") {
            total += 12;
          } else {
            total += 13;
          }
        }
      }
    }
    return total;
  }

  public static void main(String args[]) {
    playGame();

  }
}
