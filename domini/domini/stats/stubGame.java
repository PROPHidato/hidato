package domini.stats;

import domini.Playable;

public class stubGame implements Playable {
    int _gameID;
    int _difficulty;
    // aqui faltar�a un board al que asociar el game, pero no el necesito per Stats.

    public stubGame(int gameID, int difficulty) {
        _gameID = gameID;
        _difficulty = difficulty;
    }

    public int getId() {
        return _gameID;
    }

    public int getDifficulty() {
        return _difficulty;
    }
}