package domini;

/**
 * Created with IntelliJ IDEA.
 * User: jordi.guiu.pujols
 * Date: 29/10/15
 * Time: 17:51
 * To change this template use File | Settings | File Templates.
 */


public class Game {
    int GameId;
    int difficult;    // 1 = fàcil, 2 = mitjà, 3 = difícil

    public Game(int GameId, int difficult) {
        this.GameId = GameId;
        this.difficult = difficult;
    }

    public int getGameId() {
        return GameId;
    }

    public void setGameId(int gameId) {
        this.GameId = GameId;
    }

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }
}
