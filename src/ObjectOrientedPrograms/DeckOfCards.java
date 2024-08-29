package ObjectOrientedPrograms;
import java.util.Random;
public class DeckOfCards {
    public static void main(String[] args) {
        // Define suits and ranks
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        // Initialize deck
        String[] deck = new String[suits.length * ranks.length];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }

        // Shuffle deck
        Random random = new Random();
        for (int i = 0; i < deck.length; i++) {
            int j = random.nextInt(deck.length);
            String temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }

        // Distribute cards to players
        String[][] players = new String[4][9];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 9; j++) {
                players[i][j] = deck[i * 9 + j];
            }
        }

        // Print cards received by each player
        for (int i = 0; i < 4; i++) {
            System.out.println("Player " + (i + 1) + " received:");
            for (String card : players[i]) {
                System.out.println(card);
            }
            System.out.println();
        }
    }
}
