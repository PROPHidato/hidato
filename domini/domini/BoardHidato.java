package domini;
import domini.Game;
import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * Date: 29/10/15
 * Time: 17:49
 * To change this template use File | Settings | File Templates.
 */


public class BoardHidato extends Board {
    static int max_annotations; //màxim nombre de marques que poden tenir les cel·es del taulell.
    private int num_celesinvalides;
    private int start_i;
    private int start_j;
    private int finish_i;
    private int finish_j;

    public BoardHidato(int size) {
        super(size);
        for (int i=0;i < size;++i) {
            board.add(new ArrayList<CellHidato>(size));
            for (int j = 0; j < size; ++j) {
                board.get(i).add(new CellHidato());

            }
        }
        max_annotations = size*size; //Si taulell hi han 25 caselles podrà anar-hi del 1 al 25 en una casella.
    }

    public static int consult_max_annotations(){
        return max_annotations;
    }

    public void reset_numerocelesinvalides(){num_celesinvalides = 0;}

    public int consultar_num_celesinvalides(){
        return num_celesinvalides;
    }

    //posem una cela a invalida: casella q no formara part
    //hidato en si, pero si del taulell;}
    public void incrementar_celesinvalides(int row, int column) {
        ++num_celesinvalides;
        switchValidaCell(row,column);
        setValProvCell(-1, row, column);
    }

    public boolean getAnnotationCell(int value, int row, int column) {
        return board.get(row).get(column).getAnnotation(value);
    }

    public void switchAnnotationCell(int value, int row, int column) {
        board.get(row).get(column).switchAnnotation(value);
    }

    public void setAnnotationCell(int value, boolean annotation, int row, int column) {
        board.get(row).get(column).setAnnotation(value, annotation);
    }

    public int getValueCell(int row, int column) {
        return super.getValueCell(row+1,column+1);
    }

    public void setValProvCell(int value, int row, int column) {
        super.setCell(value, row+1, column+1);
    }


    public void setValueCell(int value, int row, int column) {
        board.get(row).get(column).setValue(value);
        if (getValueCell(row,column) != 0) switchWrittenCell(row,column);
    }

    public boolean getWrittenCell(int row, int column) {return (board.get(row).get(column).getWritten());}

    public void switchWrittenCell (int row, int column) {board.get(row).get(column).switchWritten();}

    public boolean getValidaCell(int row, int column) {return board.get(row).get(column).getValida();}

    public void switchValidaCell (int row, int column) {board.get(row).get(column).switchValida();}

    public boolean getStartCell(int row, int column) {return board.get(row).get(column).getStart();}

    public void switchStartCell(int row, int column) {board.get(row).get(column).switchStart();}

    public boolean getFinishCell(int row, int column) {return board.get(row).get(column).getFinish();}

    public void switchFinishCell(int row, int column) {board.get(row).get(column).switchFinish();}

    public void setStart_i(int i) {start_i = i;}

    public int getStart_i() {return start_i;}

    public void setStart_j(int j) {start_j = j;}

    public int getStart_j() {return start_j;}

    public void setFinish_i(int i) {finish_i = i;}

    public int getFinish_i() {return finish_i;}

    public void setFinish_j(int j) {finish_j = j;}

    public int getFinish_j() {return finish_j;}
}
