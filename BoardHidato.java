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
        board = new Cell[size][size];
        //board = new ArrayList<ArrayList<Cell>>(size);
        max_annotations = size*size;
    }

    public static int consult_max_annotations(){
        return max_annotations;
    }
}
