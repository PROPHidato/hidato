package domini.stats;

import dades.Table;
import domini.Player;

public class HidatoStats extends Stats {

    public HidatoStats(Table<Player> players, Table<stubGame> games, Table<stubMatch> matches) {
        super(players,games,matches);
    }

    @Override
    public int score(Player player) {
        int score = 0;
        for (stubMatch m : _matches)
            if (player == m.getPlayer())
                if (m.getResult() != -1)
                    score += getDiff(m);
        return score;
    }
}