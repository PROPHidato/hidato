package domini.domini;


/**
 * Created with IntelliJ IDEA.
 * Date: 29/10/15
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */


public class Cell {
    int value;
    int column; //numero de columna
    int row; //numero de fila
    boolean[] annotations = new boolean[Board.consult_max_annotations()]; //marques
    boolean visible; //per veure si la casella és visible
    boolean written; //per veure si el valor ja venia donat en el joc o no

    public Cell(int row, int column) {
        this.column = column;
        this.row = row;
        written = false;
        visible = false;
        value = -1;

        for (int i = 0; i < annotations.length; i++) annotations[i] = false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public boolean getWritten(){
        return written;
    }

    public void switchWritten(){  //Aclarar perquè = written.
        this.written ^= true;
    }

    public boolean getVisible(){
        return visible;
    }

    public void switchVisible(){  //Aclarar perquè = visible.
        this.visible ^= true;
    }

}
