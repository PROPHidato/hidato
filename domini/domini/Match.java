package domini;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: jordi.guiu.pujols
 * Date: 29/10/15
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */

public class Match implements Serializable {
    private Game Joc;
    private Player Jugador;     //No sabem si es fa així.
    int time;
    int hints; //número de pistes que porta el player.
    int result; //resultat de puntuació final del Match.

    public Match(int difficult) {
        //hem d'agafar el idi del player q esta iniciat a la base de dades i el id del Game
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

    public String getPlayerName() {
        return Jugador.getName();
    }

    public int getGameId() {
        return Joc.getGameId();
    }
}
