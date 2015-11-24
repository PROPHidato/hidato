package domini.stats;

import domini.Playable;

import java.io.Serializable;

public class stubGame implements Playable, Serializable {
    int _gameID;
    int _difficulty;
    // aqui faltaría un board al que asociar el game, pero no el necesito per Stats.

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