package domini.stats;

import dades.Table;
import domini.Playable;
import domini.Player;

import java.util.ArrayList;

public abstract class Stats {

    protected Table<Player> _players;
    protected Table<? extends Playable> _games;
    protected Table<stubMatch> _matches;
    /** He posat els camps a protected per si voleu calcular més stats a la vostra subclasse.
     * Com a mínim _matches ho hauria de ser, per a poder calcular l'score d'un player.
     * L'unica alternativa es que Stats tingui getMatches() { return _matches; }
     * Pero suposo que sent Stats abstract, no està tan mal que els camps siguin protected.
     * La taula games casi no es fa servir, però només es un punter.
     */

    public Stats(Table<Player> players, Table<? extends Playable> games, Table<stubMatch> matches)
    {
        this._players = players;
        this._games = games;
        this._matches = matches;
    }

    /////// PLAYER STATS ////////////////////////////////////////////////////////////////////
    public abstract int score(Player player);

    public int countMatches(Player player)
    {
        int count = 0;
        for (stubMatch m: _matches)
            if (m.getPlayer() == player) ++count;
        return count;
    }

    public int countSolvedGames(Player player)
    {
        ArrayList<Integer> countedGames = new ArrayList<>();
        for (stubMatch m : _matches)
            if (m.getPlayer() == player && m.getResult() != -1)
                insert_no_repeat(countedGames, m.getGame().getId());
        return countedGames.size();
    }

    public int countSolvedGamesDiff(int difficulty, Player player)
    {
        ArrayList<Integer> countedGames = new ArrayList<>();
        for (stubMatch m : _matches)
            if (m.getPlayer() == player && m.getResult() != -1 && getDiff(m) == difficulty)
                insert_no_repeat(countedGames, m.getGame().getId());
        return countedGames.size();
    }

    public int rank(Player player)
    {
        int rank = _players.size();
        int score = score(player);
        int i;
        for (i = 0; _players.get(i) != player; ++i)
            if (score >= score(_players.get(i))) --rank;
        for (; i < _players.size(); ++i)
            if (score > score(_players.get(i))) --rank;
        return rank;
    }

    public int bestTime(Player player, Playable game)
    {
        int time = -1;
        for (stubMatch m : _matches)
            if (m.getPlayer() == player && m.getGame() == game) {
                if (time > m.computeTime()) time = m.computeTime();
                else if (time == -1) time = m.computeTime();
            }
        return time;
    }

    /////// GAME STATS //////////////////////////////////////////////////////////////////////
    public Ranking recordsGame(Playable game)
    {
        ArrayList<Integer> bestTimes = new ArrayList<>();
        for (Player p : _players) bestTimes.add(bestTime(p,game));
        return new Ranking(_players,bestTimes,true);
    }

    public int countTimesPlayed(Playable game)
    {
        int count = 0;
        for (stubMatch match : _matches)
            if (match.getGame() == game) ++count;
        return count;
    }

    public int countTimesSolved(Playable game)
    {
        int count = 0;
        for (stubMatch match : _matches)
            if (match.getGame() == game&& match.getResult() != -1) ++count;
        return count;
    }

    /////// GLOBAL STATS ///////////////////////////////////////////////////////////////////
    public Ranking rankingGlobal()
    {
        ArrayList<Integer> scores = new ArrayList<>();
        for (Player p: _players) scores.add(score(p));
        return new Ranking(_players,scores,false);
    }

    public int countPlayers() { return _players.size(); }
    public int countGames() { return _games.size(); }
    public int countMatches() { return _matches.size(); }

    /////// INTERNAL METHODS ////////////////////////////////////////////////////////////////
    protected void insert_no_repeat(ArrayList<Integer> array, int new_one)
    {
        if (array.size() == 0) array.add(0,new_one);
        else {
            int left = 0;
            int right = array.size() - 1;
            while (left <= right) {
                int i = (left + right) / 2;
                if (array.get(i) < new_one) left = i + 1;
                else if (array.get(i) > new_one) right = i - 1;
                else return;
            }
            array.add(left, new_one);
        }
    }

    protected int getDiff(stubMatch match)
    {
        return match.getGame().getDifficulty();
    }
}