package domini;

import domini.Match;

import java.io.IOException;

/**
 * Class used only in the Ken-Ken program to store the program data dynamically and statically
 */
public class KKDB extends DB {

    /** Contains all the players */
    private Table<Player> _players;

    /** Contains all the matches in progress and finished */
    private Table<Match> _matches;

    /** Class constructor, by default loads all the data */
    public KKDB()
    {
        _players = new Table<>();
        _matches = new Table<>();
    }

    /** Returns the Players Administration class */
    public PlayersAdmin getPlayersAdmin()
    {
        return new PlayersAdmin(_players);
    }

    /** Saves all data on disc */
    public void save()
    {
        _players.save(getOutputStream("players"));
        _matches.save(getOutputStream("matches"));
    }

    /** Load all data from disc */
    public void load()
    {
        try {
            _players.load(getInputStream("players"));
        } catch (IOException e) {
            System.err.println("Table not found");
        }
        try {
            _matches.load(getInputStream("matches"));
        } catch (IOException e) {
            System.err.println("Table not found");
        }
    }

    /**
     * To get all Matches
     * @return Returns all stored matches
     */
    public Table<Match> getMatches() { return _matches; }

    /**
     * To replace the matches
     * @param m Matches to replace the current data
     */
    public void setMatches(Table<Match> m) { this._matches = m; }
}