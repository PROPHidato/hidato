package domini;
import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * Date: 29/10/15
 * Time: 17:49
 * To change this template use File | Settings | File Templates.
 */


public class BoardHidato extends Board {
    static int max_annotations; //màxim nombre de marques que poden tenir les cel·es del taulell.

    public BoardHidato(int size) {
        super(size); // Fer la creadora
        ArrayList<ArrayList<Cell>> board = new ArrayList<ArrayList<Cell>>(size); //board = new Cell[size][size];
        for (int i=0;i < board.size();++i) {
            board.add(new ArrayList<Cell>(size));
            for (int j = 0; j < board.size(); ++j) {
                board.get(i).add(new Cell(i,j));
            }
        }
        max_annotations = size*size; //Si taulell hi han 25 caselles podrà anar-hi del 1 al 25 en una casella.
    }

    //no pilla el getStart ni el getFinish perque son funcions de CellHidato i actualment totes les
    //nostres array list de array list son de Cells normals (crec).
    //public boolean isStart(int row, int column) {return (board.get(row).get(column).getStart());}

    //public boolean isFinish(int row, int column) {return (board.get(row).get(column).getFinish());}


    /* AIXÒ FUNCIONA
    int boardSize = 3;
    ArrayList<ArrayList<Character>> board = new ArrayList<ArrayList<Character>>(boardSize);
    for (int i = 0; i < boardSize; i++) {
        board.add(new ArrayList<Character>(boardSize));
        for (int j = 0; j < boardSize; j++){
            board.get(i).add('0');
        }
    }

    COM VA DIR EL JOAN
    ArrayList< ArrayList< Cell > > A(size) = new ArrayList< ArrayList< Cell > >
    for (int i = 0; i < A.size(); ++i) {
    A[i] = new ArrayList< Cell> (size);
    for (int j = 0; j < A[i].size(); ++j) {
    A[i][j] = new Cell;
    } }

    */



    public static int consult_max_annotations(){
        return max_annotations;
    }
}
