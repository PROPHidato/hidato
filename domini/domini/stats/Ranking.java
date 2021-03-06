package domini.stats;

import dades.Table;
import domini.Player;

import java.util.ArrayList;

public class Ranking {

    private Table<Player> _players;
    private ArrayList<Integer> _values;
    private boolean _asc;
    private ArrayList<Integer> _order;

    /**
     * El poso a protected perqu� nom�s l'hauria d'instanciar Stats, que ser� al mateix package.
     * pre: players.size() == values.size()
     */
    protected Ranking(Table<Player> players, ArrayList<Integer> values, boolean asc)
    {
        _players = players;
        _values = values;
        _asc = asc;
        this.sort();
    }

    /**
     * size = numero de players que tenen value.
     * En RankingGlobal size = players.size() pero en Records(game) no.
     * Pot ser que un player no hagi jugat al game i llavors no apareix al ranking.
     */
    public int getSize() { return _order.size(); }

    /**
     * 1 <= @param position <= size.
     */
    public Player getPlayer(int position) {
        return _players.get(_order.get(position));
    }

    /**
     * 1 <= @param position <= size.
     */
    public int getValue(int position) {
        return _values.get(_order.get(position));
    }

    private void sort()
    {
        _order = new ArrayList<>();
        for (int i = 0; i < _values.size(); ++i)
            if (_values.get(i) != -1) insert(i);
    }

    private void insert(int ipos)
    {
        int j = _order.size();
        while (j > 0 && post(_order.get(j-1),ipos)) --j;    // Como java no sea lazy esto peta.
        _order.add(j,ipos);
    }

    /**
     * Retorna si j ha d'anar despr�s de i al ranking.
     * Si els values coincideixen, el jugador m�s recent va primer.
     * Suposant que els jugadors creats m�s recentment se situen al final de _players.
     * Teniu en compte que, sent aix� un algorisme d'inserci�, j < i.
     */
    private boolean post(int jpos, int ipos)
    {
        if (_asc) return _values.get(jpos) >= _values.get(ipos);
        else return _values.get(jpos) <= _values.get(ipos);
    }
}