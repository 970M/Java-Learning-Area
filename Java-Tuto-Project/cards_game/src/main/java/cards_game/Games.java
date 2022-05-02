package cards_game;

import cards_game.Controller.GameController;
import cards_game.Model.Deck;
import cards_game.View.*;
import cards_game.Game.*;

public class Games {

    public static void main(String args[]) {

        GameSwingView gsv = new GameSwingView();
        gsv.createAndShowGUI();
        GameController gc = new GameController(new Deck(), gsv, new HighCardGameEvaluator());
        // ----
        // GameController gc = new GameController(new Deck(), new CommandLineView(), new
        // HighCardGameEvaluator());
        // GameController gc = new GameController(new Deck(), new View(), new
        // LowCardGameEvaluator());
        gc.run();
    }
}