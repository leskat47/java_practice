import java.io.*;
import java.util.Random;

public class Cards {

  public String [] faces = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

  public static String getCard(String[] faces) {
    Random rand = new Random();
    int index = rand.nextInt(faces.length);
    return(faces[index]);
  }

  public static void main(String args[]) {
    Cards cards = new Cards();
    System.out.println(getCard(cards.faces));

  }

}
