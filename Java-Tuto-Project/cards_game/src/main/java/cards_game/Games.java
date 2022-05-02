package cards_game;

import cards_game.Controller.GameController;
import cards_game.Model.Deck;
import cards_game.View.View;
import cards_game.Game.*;

public class Games {

    public static void main(String args[]) {

        GameController gc = new GameController(new Deck(), new View(), new HighCardGameEvaluator());
        // GameController gc = new GameController(new Deck(), new View(), new
        // LowCardGameEvaluator());
        gc.run();
    }
}