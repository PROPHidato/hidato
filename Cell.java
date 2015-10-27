package domini.Basic;


public class Cell extends Taulell{
    int value;
    Region region;
    Column column;
    Row row;
    boolean written; //per veure si el valor ja venia donat en el joc o no
    public Cell(Region region, Column column, Row row) {
        this.region = region;
        this.column = column;
        this.row = row;
        written = false;
        }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Region getRegion() {
        return region;
    }

    public Column getColumn() {
        return column;
    }

    public Row getRow() {
        return row;
    }

    public boolean getWritten(){
        return written;
    }

    public void setWritten(){
        this.written = written;
    }
