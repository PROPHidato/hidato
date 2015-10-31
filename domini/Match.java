package domini;

/**
 * Created with IntelliJ IDEA.
 * User: jordi.guiu.pujols
 * Date: 29/10/15
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */

public class Match extends domini.Game {
    int PlayerId;
    int GameId;
    int time;
    int hints; //número de pistes que porta el player.
    int result; //resultat de puntuació final del Match.

    //private Player Payer;     //No sabem si es fa així.

    public Match(int GameId, /*int PlayerId, */int difficult) {
        this.GameId = GameId;
        //this.PlayerId = PlayerId;
        time = 0;
        hints = 0;
        result = -1;  //no hi ha resultat encara
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getHints() {
        return hints;
    }

    public void setHints(int hints) {
        this.hints = hints;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
