package cards_game;

import cards_game.Model.PlayingCard;

import cards_game.Model.Rank;
import cards_game.Model.Suit;

public class App {
    public static void main(String[] args) {

        System.out.println("970M");

        // - --------------------------------
        // - Test des classes
        // - --------------------------------
        // Rank
        Rank r = Rank.THREE;
        // Suit
        Suit s = Suit.HEARTS;
        // PlayingCard 1
        PlayingCard pc1 = new PlayingCard(r, s);
        System.out.println("Playing card : " + pc1.getRank() + "|" + pc1.getSuit());
        // PlayingCard 2
        PlayingCard pc2 = new PlayingCard(Rank.JACK, Suit.DIAMONDS);
        System.out.println("Playing card : " + pc2.getRank() + "|" + pc2.getSuit());

    }
}
