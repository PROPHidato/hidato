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
    //ArrayList<ArrayList<Cell>> board;
    Cell[][] board;
    static int max_annotations = 9; //màxim nombre de marques que poden tenir les cel·es del taulell

    public Board(int size) { // Fer la creadora
        this.setSize(size);
        board = new Cell[size][size];
        //board = new ArrayList<ArrayList<Cell>>(size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getValueCell(int column, int row) {  //getValue de Cell no es passen 2 valors,
        return board[column][row].getValue();
    }

    public int  getValue() {
        return Cell.getValue();
    }

    public void setValueCell(int value, int column, int row) {
        /*Cell c = board[column][row];
        //Cell c = board.get(column).get(row);
        c.setValue(value);*/
        board[column][row].setValue(value);
    }

    public static int consult_max_annotations(){
        return max_annotations;
    }
}


