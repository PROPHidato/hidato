package domini;
import java.util.ArrayList;


/**
 * Created with IntelliJ IDEA.
 * Date: 29/10/15
 * Time: 17:49
 * To change this template use File | Settings | File Templates.
 */


public class BoardHidato extends Board {
    int max_annotations = size; //màxim nombre de marques que poden tenir les cel·es del taulell.

    public BoardHidato(int size) {
        super(size); // Fer la creadora
        board = new ArrayList<ArrayList<Cell>>(size);
    }
}
