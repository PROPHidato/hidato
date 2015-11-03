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
    ArrayList<ArrayList<Cell>> board = new ArrayList<ArrayList<Cell>>(size);

    public Board(int size) { // Fer la creadora
        setSize(size);
        //definim larraylist amb la mida i nombre de files i columnes
        System.out.printf("entra 1 ");
        for (int i=0;i < size;++i) {
            System.out.printf("entra 2 ");
            board.add(new ArrayList<Cell>(size));
            System.out.printf("entra 3 ");
            for (int j = 0; j < board.size(); ++j) {
                System.out.printf("entra 4 ");
                board.get(i).add(new Cell(i,j));//board[i][j] = new Cell(i,j);
                System.out.println(board.get(i).get(j).getValue());
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
        return (board.get(column).get(row).getValue());        //i no s'haurien de passar
    }

    public int getValue() {
        return Cell.getValue();
    }

    public void setValueCell(int value, int column, int row) {
       // Cell c = board.get(row).get(column);        //i no s'haurien de passar.
        //c.setValue(value);
        (board.get(row).get(column)).setValue(value);
        //myArrayList2D.get(row).set(col, value);
        //board[column][row].setValue(value);
    }

    public static int consult_max_annotations(){
        return max_annotations;
    }
}


