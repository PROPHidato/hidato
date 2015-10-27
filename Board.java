package domini.Basic; //Falten fer els packages


public class Board{
    int size;
    Arraylist<Arraylist<Cell>> board;
    
    public Board(int size) { // Fer la creadora
       board = new ArrayList<ArrayList<Cell>>(size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCell(int column, int row) { 
        return cell.getValue(column,row);
    }
    
    public void setCellValue(int value) {
        cell.setValue(value);
    }
}
