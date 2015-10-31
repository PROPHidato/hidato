package domini;

/**
 * Created with IntelliJ IDEA.
 * User: jordi.guiu.pujols
 * Date: 29/10/15
 * Time: 17:48
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;


public class Board {
    int size;
    //int prova;
    ArrayList<ArrayList<Cell>> board;
    int max_annotations = 9; //màxim nombre de marques que poden tenir les cel·es del taulell

    public Board(int size) { // Fer la creadora
        board = new ArrayList<ArrayList<Cell>>(size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getvalueCell(int column, int row) {
        return Cell.getValue(column,row);
    }

    public int getvalue() {
        return Cell.getValue();
    }

    public void setCellValue(int value) {
        Cell.setValue(value);
    }
}

