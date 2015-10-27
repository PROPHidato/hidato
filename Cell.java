package domini.Basic;


public class Cell extends Taulell{
    int value; 
    int column; //numero de columna
    int row; //numero de fila
    boolean[] annotations; //marques
    boolean visible; //per veure si la casella és visible
    boolean written; //per veure si el valor ja venia donat en el joc o no
    int max_annotations = 10; 
    
    public Cell(int column, int row) {
        this.column = column;
        this.row = row;
        written = false;
        visible = false;
        value = -1;
        
        annotations = new boolean[max_annotations];
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

    public void setWritten(){
        this.written = written;
    }
    
    public boolean getVisible(){
        return visible;
    }

    public void setVisible(){
        this.visible = visible;
    }
    
    public boolean getAnnotation(int value) {
        return annotations[value - 1];
    }

    public void switchAnnotation(int value) {
        this.annotations[value - 1] ^= true;
    }

    public void setAnnotation(int value, boolean annotation) {
        this.annotations[value - 1] = annotation;
    }
}
