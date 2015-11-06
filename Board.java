package domini;
import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * Date: 29/10/15
 * Time: 17:48
 * To change this template use File | Settings | File Templates.
 */


public class Board {
    static int size;
    static int max_annotations = 9; //màxim nombre de marques que poden tenir les celes del taulell
    ArrayList<ArrayList<Cell>> board = new ArrayList<ArrayList<Cell>>(size);

    public Board(int size) {
        setSize(size);
        for (int i=0;i < size;++i) {
            board.add(new ArrayList<Cell>(size));
            for (int j = 0; j < size; ++j) {
                board.get(i).add(new Cell(i,j));
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
    }

    public static int consult_max_annotations(){
        return max_annotations;
    }

    public boolean getVisibleCell(int row, int column) {return (board.get(row).get(column).getVisible());}

    public void setVisibleCell (int row, int column) {board.get(row).get(column).switchVisible();}

    public boolean getWrittenCell(int row, int column) {return (board.get(row).get(column).getWritten());}

    public void setWrittenCell (int row, int column) {board.get(row).get(column).switchWritten();}

    public boolean getValidaCell(int row, int column) {return (board.get(row).get(column).getValida());}

    public void setValidaCell (int row, int column) {board.get(row).get(column).switchValida();}
}


