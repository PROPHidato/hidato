package domini;
import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * Date: 29/10/15
 * Time: 17:49
 * To change this template use File | Settings | File Templates.
 */


public class BoardHidato extends Board {
    private static int max_annotations; //màxim nombre de marques que poden tenir les cel·es del taulell.
    private static int num_celesinvalides;

    public BoardHidato(int size) {
        super(size); // Fer la creadora
        ArrayList<ArrayList<CellHidato>> board = new ArrayList<ArrayList<CellHidato>>(size);
        for (int i=0;i < board.size();++i) {
            board.add(new ArrayList<CellHidato>(size));
            for (int j = 0; j < board.size(); ++j) {
                board.get(i).add(new CellHidato(i,j));
            }
        }
        max_annotations = size*size; //Si taulell hi han 25 caselles podrà anar-hi del 1 al 25 en una casella.
    }

    //no pilla el getStart ni el getFinish perque son funcions de CellHidato i actualment totes les
    //nostres array list de array list son de Cells normals (crec).
    //public boolean isStart(int row, int column) {return (board.get(row).get(column).getStart());}

    //public boolean isFinish(int row, int column) {return (board.get(row).get(column).getFinish());}

    public static int consult_max_annotations(){
        return max_annotations;
    }

    public int consultar_num_celesinvalides(){
        return num_celesinvalides;
    }

    // //posem una cela a invalida: casella q no formara part
    //hidato en si, pero si del taulell;}
    public void incrementar_celesinvalides (int row, int column) {
        ++num_celesinvalides;
        board.get(row).get(column).switchValida();
        board.get(row).get(column).setValue(-1);
    }

    public boolean getValidaCell(int row, int column) {return (board.get(row).get(column).getValida());}

    public void switchValidaCell (int row, int column) {board.get(row).get(column).switchValida();}

    public CellHidato getCell(int i, int j) {return board.get(i).get(j);}

}
