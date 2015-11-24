package domini;
import java.io.Serializable;
import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * Date: 29/10/15
 * Time: 17:48
 * To change this template use File | Settings | File Templates.
 */


public class Board implements Serializable {
    public int size;
    public ArrayList<ArrayList<CellHidato>> board;

    public Board(int size) {
        this.size = size;
        board = new ArrayList<ArrayList<CellHidato>>(size);
    }

    public int getSize() {
        return size;
    }

    public int getValueCell(int row, int column) {
        return board.get(row-1).get(column-1).getValue();
    }

    public void setCell(int value, int row, int column) {
        board.get(row-1).get(column-1).setValue(value);
    }
}





