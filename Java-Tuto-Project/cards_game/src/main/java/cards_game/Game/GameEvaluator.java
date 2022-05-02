package cards_game.Game;

import java.util.List;

import cards_game.Model.Player;

public interface GameEvaluator {

    public Player evaluateWinner(List<Player> players);
}
