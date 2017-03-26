import java.io.*;
import java.util.Scanner;

public class Blackjack {

  public static void playGame() {

    Cards deckCards = new Cards();

    String[] playerCards = new String[10];
    String[] dealerCards = new String[10];

    playerCards[0] = deckCards.getCard(deckCards.faces);
    System.out.println("Your first card is " + playerCards[0]);

    String choice = "";
    int cardIndex = 1;
    while (!choice.equals("stay")){
      playerCards[cardIndex] = deckCards.getCard(deckCards.faces);
      System.out.println("Your next card is " + playerCards[cardIndex]);
      if (getTotal(playerCards) > 21){
        System.out.println("You busted!");
        break;
      }
      System.out.println("Do you want to stay or hit?");
      choice = getUserInput();
      cardIndex += 1;
    }
  }

// take array and return total points
  public static int getTotal(String[] cards) {
    int total = 0;
    for (String card : cards) {
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

  public static String getUserInput() {
    Scanner input = new Scanner(System.in);
    String choice = input.next();
    while (!choice.equals("stay") && !choice.equals("hit")) {
      System.out.println("Sorry that is not an option. Enter stay or hit.");
      choice = input.next();
    }
    return(choice);
  }

  public static void main(String args[]) {
    playGame();

  }
}
