package cards_game.View;

import cards_game.Controller.GameController;

public interface GameViewable {

    public void setController(GameController gc);

    public void promptForPlayerName();

    public void promptForFlip();

    public void promptForNewGame();

    public void showWinner(String playerName);

    public void showPlayerName(int playerIndex, String playerName);

    public void showFaceDownCardForPlayer(int i, String playerName);

    public void showCardForPlayer(int i, String playerName, String rank, String suit);
}