package domini;
import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * Date: 29/10/15
 * Time: 17:48
 * To change this template use File | Settings | File Templates.
 */


public class Board {
    public static int size;
    private static int max_annotations = 9; //màxim nombre de marques que poden tenir les celes del taulell
    public ArrayList<ArrayList<CellHidato>> board = new ArrayList<ArrayList<CellHidato>>(size);

    public Board(int size) {
        setSize(size);
        for (int i=0;i < size;++i) {
            board.add(new ArrayList<CellHidato>(size));
            for (int j = 0; j < size; ++j) {
                board.get(i).add(new CellHidato(i,j));

            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getValueCell(int row, int column) {
        return board.get(row).get(column).getValue();
    }

    /*public int getValue() {
        return this.getValue();
    }*/

    public void setValueCell(int value, int row, int column) {
        board.get(row).get(column).setValue(value);
        if (getValueCell(row,column) != 0) switchWrittenCell(row,column);
    }

    public static int consult_max_annotations(){
        return max_annotations;
    }

    public boolean getVisibleCell(int row, int column) {return (board.get(row).get(column).getVisible());}

    public void switchVisibleCell (int row, int column) {board.get(row).get(column).switchVisible();}

    public boolean getWrittenCell(int row, int column) {return (board.get(row).get(column).getWritten());}

    public void switchWrittenCell (int row, int column) {board.get(row).get(column).switchWritten();}

}


