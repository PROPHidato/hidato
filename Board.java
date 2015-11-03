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
   // private static ArrayList<ArrayList<Cell>> board;
    static int max_annotations = 9; //màxim nombre de marques que poden tenir les cel·es del taulell
    ArrayList<ArrayList<Cell>> board;

    public Board(int size) { // Fer la creadora
        setSize(size);
        //definim larraylist amb la mida i nombre de files i columnes
        ArrayList<ArrayList<Cell>> board = new ArrayList<ArrayList<Cell>>(size);
        for (int i=0;i < board.size();++i) {
            board.add(new ArrayList<Cell>(size));
            for (int j = 0; j < board.size(); ++j) {
                board.get(i).add(new Cell(i,j));//board[i][j] = new Cell(i,j);
            }
        }
    }




    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getValueCell(int column, int row) {  //getValue de Cell no es passen 2 valors,
        Cell c = board.get(column).get(row);        //i no s'haurien de passar.
        return c.getValue();
    }

    public int  getValue() {
        return Cell.getValue();
    }

    public void setValueCell(int value, int column, int row) {
        Cell c = board.get(column).get(row);        //i no s'haurien de passar.
        c.setValue(value);
        //board[column][row].setValue(value);
    }

    public static int consult_max_annotations(){
        return max_annotations;
    }
}


