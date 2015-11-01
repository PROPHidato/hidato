package domini;


/**
 * Created with IntelliJ IDEA.
 * Date: 29/10/15
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */


public class Cell {
    static int value;
    int column; //numero de columna
    int row; //numero de fila
    boolean[] annotations = new boolean[Board.consult_max_annotations()]; //marques
    boolean visible; //per veure si la casella és visible
    boolean written; //per veure si el valor ja venia donat en el joc o no

    public Cell(int column, int row) {
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

    public static void setValue(int value) {
        Cell.value = value;
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

    public void setWritten(){  //Aclarar perquè = written.
        this.written = written;
    }

    public boolean getVisible(){
        return visible;
    }

    public void setVisible(){  //Aclarar perquè = visible.
        this.visible = visible;
    }

    //NO ÉS COMÚ PERÒ AQUÍ TENIU PER FER-HO SIMILAR
    /*public boolean getAnnotation(int value) {
        return annotations[value - 1];
    }
    public void switchAnnotation(int value) {
        this.annotations[value - 1] ^= true;
    }
    public void setAnnotation(int value, boolean annotation) {
        this.annotations[value - 1] = annotation;
    }*/
}
