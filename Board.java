package domini.Basic; //Falten fer els packages


public class Board{
    int size;
    Arraylist<Arraylist<Cell>> board;
    int max_annotations = size; //màxim nombre de marques que poden tenir les cel·es del taulell
    
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
        return cell.getValue(column,row);
    }

    public int getvalue() { 
        return cell.getValue();
    }
    
    public void setCellValue(int value) {
        cell.setValue(value);
    }
}
