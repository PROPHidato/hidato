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

    public int getCell(int column, int row) { // Com utilitzar column i row aquí que són de Cell?
        return cell.getvalue(column,row);
    }
    
    public void setCellvalue(int value) litzar column i row aquí que són de Cell?
        cell.setvalue(value);
    }
}
