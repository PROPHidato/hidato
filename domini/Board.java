package domini;
import java.util.ArrayList;


/**
 * Created with IntelliJ IDEA.
 * Date: 29/10/15
 * Time: 17:48
 * To change this template use File | Settings | File Templates.
 */


public class Board {
    int size;
    ArrayList<ArrayList<domini.Cell>> board;
    int max_annotations = 9; //màxim nombre de marques que poden tenir les cel·es del taulell

    public Board(int size) { // Fer la creadora
        board = new ArrayList<ArrayList<domini.Cell>>(size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getvalueCell(int column, int row) {
        return domini.Cell.getValue(column, row);
    }

    public int getvalue() {
        return domini.Cell.getValue();
    }

    public void setCellValue(int value) {
        domini.Cell.setValue(value);
    }

    public int consult_max_annotations(){
        return max_annotations;
    }
}

