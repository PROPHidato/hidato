package domini.stats;

import domini.Player;

import java.io.Serializable;

public class stubMatch implements Serializable {
    Player player;
    stubGame game;

    int time;   // seconds?
    int hints;
    int result;

    public stubMatch(Player player, stubGame game)
    {
        this.player = player;
        this.game = game;

        time = 0;
        hints = 0;
        result = -1;
    }

    public Player getPlayer(){ return player; }
    public stubGame getGame(){ return game; }

    public int getResult() { return result; }

    public void setTime(int seconds)
    {
        result = 1;
        time = seconds;
    }

    public int computeTime()
    {
        if (result == -1) return -1;
        else return time + hints*10;
    }
}