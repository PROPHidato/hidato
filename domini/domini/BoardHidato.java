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
    private static int max_annotations; //màxim nombre de marques que poden tenir les cel·es del taulell.
    private static int num_celesinvalides;
    private static int start_i;
    private static int start_j;
    private static int finish_i;
    private static int finish_j;

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
        colocar_celesinvalides();
    }

    //public boolean isStart(int row, int column) {return (board.get(row).get(column).getStart());}
    //public boolean isFinish(int row, int column) {return (board.get(row).get(column).getFinish());}

    public static int consult_max_annotations(){
        return max_annotations;
    }

    public static void generar_written(){//posem al taulell les celes que al ppi estaran escrites
        int numcela,numvisibles;
        numcela = numvisibles = 1; //comencem per la 1 i amb 1 cela visible

    }

    static boolean posarainvalida(int row,int column) {//si totes les celes veines o totes menys una son invalides, return true
        //primer les q tenen 3 al voltant
        int inva = 0;
        if (row == 0 && column == 0 || row == 0 && column == size - 1 || row == size - 1 && column == 0 || row == size - 1 && column == size - 1) {
            if (row == 0)
                if ((!getValidaCell(row + 1, column))) ++inva;
            if (column == 0)
                if ((!getValidaCell(row, column + 1))) ++inva;
            if (row == size - 1)
                if ((!getValidaCell(row - 1, column))) ++inva;
            if (column == size - 1)
                if ((!getValidaCell(row, column - 1))) ++inva;
            if (inva >= 2) return true;
        } else if ((row > 0 && row < size - 1) && column == 0 || (column > 0 && column < size - 1) && row == 0 ||
                (row > 0 && row < size - 1) && column == size - 1 || (column > 0 && column < size - 1) && row == size - 1) {
            if (row > 0)
                if ((!getValidaCell(row - 1, column))) ++inva; //amunt
            if (column > 0)
                if ((!getValidaCell(row, column - 1))) ++inva;//esq
            if (row < size - 1)
                if ((!getValidaCell(row + 1, column))) ++inva;//abaix
            if (column < size - 1)
                if ((!getValidaCell(row, column + 1))) ++inva;//dreta
            if (row > 0 && column < size - 1)
                if ((!getValidaCell(row - 1, column + 1))) ++inva;//amunt dreta
            if (row > 0 && column > 0)
                if ((!getValidaCell(row - 1, column - 1))) ++inva;//amunt esq
            if (row < size - 1 && column < size - 1)
                if ((!getValidaCell(row + 1, column + 1))) ++inva;//abaix dreat
            if (row < size - 1 && column > 0)
                if ((!getValidaCell(row + 1, column - 1))) ++inva; //abaix esq
            if (inva >= 4) return true;
        } else {
            if (!getValidaCell(row, column + 1)) ++inva;
            if (!getValidaCell(row, column + 1)) ++inva;
            if (!getValidaCell(row + 1, column + 1)) ++inva;
            if (!getValidaCell(row - 1, column)) ++inva;
            if (!getValidaCell(row, column - 1)) ++inva;
            if (!getValidaCell(row - 1, column - 1)) ++inva;
            if (!getValidaCell(row + 1, column - 1)) ++inva;
            if (!getValidaCell(row - 1, column + 1)) ++inva;
            if (inva >= 7) return true;
        }
        return false;
    }
    static double percentatgeceles(){
        double percentatge = Game.getDifficult();
        if (percentatge == 1) percentatge = 0.2;
        else if (percentatge == 2) percentatge = 0.1;
        else percentatge = 0.05;
        return percentatge;

    }
    public static void colocar_celesinvalides() {
        int sizeT, ncelesvalT, posades;
       //colocarem aleatoriament 10 celes invalides.
        Random posi = new Random();
        Random posj = new Random();
        posades = 0;
        double tantpercent = size * size * percentatgeceles();
        int maxinvalides = (int) tantpercent;
        ncelesvalT = size - 1;
        System.out.println(tantpercent);
        System.out.println(maxinvalides);
        while (posades < maxinvalides) {
            int row = posi.nextInt(ncelesvalT);   //fila random entre totes les celes totals
            int column = posj.nextInt(ncelesvalT); //columan random entre totes les celes totals
            if (getValidaCell(row, column)) {   //la cela q hem triat aleatoriament, si no es invalida la posem
                // la posem a invalida
                System.out.println("fila " + row + " columna " + column);
                incrementar_celesinvalides(row, column);
                ++posades;
            }
        }
        boolean posatinici = false;
        Random posiini = new Random();
        Random posjini = new Random();
        int rowini, columnini;
        while(!posatinici) {
            rowini = posi.nextInt(ncelesvalT);
            columnini = posj.nextInt(ncelesvalT);
            if (getValidaCell(rowini,columnini)){
                board.get(rowini).get(columnini).setValue(1);
                board.get(rowini).get(columnini).switchWritten();
                setStart_i(rowini);
                setStart_j(columnini);
                posatinici = true;
            }
        }
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (!getValidaCell(i, j)) {//si no es invalida mirem les del seu voltant
                    //si totes o totes menys una son invalides, la canviem a invalida tambe
                    if (posarainvalida(i, j))
                        System.out.println("posem a invalida la casella " + i + " " + j);
                        switchValidaCell(i, j);
                }
            }
        }
    }

    public int consultar_num_celesinvalides(){
        return num_celesinvalides;
    }

    // //posem una cela a invalida: casella q no formara part
    //hidato en si, pero si del taulell;}
    public static void incrementar_celesinvalides(int row, int column) {
        ++num_celesinvalides;
        board.get(row).get(column).switchValida();
        board.get(row).get(column).setValue(-1);
    }

    public static boolean getValidaCell(int row, int column) {return (board.get(row).get(column).getValida());}

    public static void switchValidaCell (int row, int column) {board.get(row).get(column).switchValida();}

    public CellHidato getCell(int i, int j) {return board.get(i).get(j);}

    public static void setStart_i(int i) {start_i = i;}

    public static int getStart_i() {return start_i;}

    public static void setStart_j(int j) {start_j = j;}

    public static int getStart_j() {return start_j;}

    public static void setFinish_i(int i) {finish_i = i;}

    public static int getFinish_i() {return finish_i;}

    public static void setFinish_j(int j) {finish_j = j;}

    public int getFinish_j() {return finish_j;}


}
