package cards_game.Model;

public class PlayingCard {
    private Rank rank;
    private Suit suit;
    private boolean faceUp;

    public PlayingCard(Rank rank, Suit suit) {
        super(); // ?? hérite de rien ??
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public boolean flip() {
        faceUp = !faceUp;
        return faceUp;
    }

}
