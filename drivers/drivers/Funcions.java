package drivers;
import domini.*;
import java.util.*;

import static java.lang.System.out;

public class Funcions {

    public static void imprimeixValors(BoardHidato Taulell) {
        for (int i = 0; i < Taulell.getSize();i++) {
            for (int j = 0; j < Taulell.getSize();j++) {
                if (Taulell.getValueCell(i,j) == -1) out.print("X" + " ");
                else out.print(Taulell.getValueCell(i,j) + " ");

            }
            out.println();
        }
        out.println();
    }

    public static void llegirTaulell(BoardHidato Taulell)   {
        int valor;
        int valormax = 1;
        Boolean correcte = false;
        Scanner input = new Scanner( System.in );
        while (correcte == false) {
            for (int i = 0; i < Taulell.getSize(); ++i) {
                for (int j = 0; j < Taulell.getSize(); ++j) {
                    valor = input.nextInt();
                    if (valor == 1) {
                        Taulell.setStart_i(i);
                        Taulell.setStart_j(j);
                    } else if (valor > valormax) {
                        Taulell.setFinish_i(i);
                        Taulell.setFinish_j(j);
                        valormax = valor;
                    }
                    Taulell.setValueCell(valor, i, j);
                    if (valor == -1) Taulell.switchValidaCell(i, j);
                }
            }
            correcte = true; //per fer que funcioni ara, dsp més tard esborrar-ho
          /*  if (solveBool(Taulell, Taulell.getSize())) {
                System.out.println("Hidato possible de resoldre.");
                correcte = true;
            } else {
                System.out.println("Hidato sense solucio possible. Torna-ho a provar.");
                netejaBoard(Taulell);
            }*/
        }
    }


    public static void copiarBoard(BoardHidato TaulellCopiat, BoardHidato Taulell) {
        for (int i = 0; i < Taulell.getSize();i++) {
            for (int j = 0; j < Taulell.getSize();j++) {
                TaulellCopiat.setValueCell(Taulell.getValueCell(i,j), i, j);
                TaulellCopiat.setFinish_i(Taulell.getFinish_i());
                TaulellCopiat.setFinish_j(Taulell.getFinish_j());
                TaulellCopiat.setStart_i(Taulell.getStart_i());
                TaulellCopiat.setStart_j(Taulell.getStart_j());
                if (Taulell.getWrittenCell(i,j) != TaulellCopiat.getWrittenCell(i,j)) TaulellCopiat.switchWrittenCell(i,j);
                if (Taulell.getStartCell(i,j) != TaulellCopiat.getStartCell(i, j)) TaulellCopiat.switchStartCell(i,j);
                if (Taulell.getFinishCell(i, j) != TaulellCopiat.getFinishCell(i, j)) TaulellCopiat.switchFinishCell(i,j);
                if (Taulell.getVisibleCell(i, j) != TaulellCopiat.getVisibleCell(i, j)) TaulellCopiat.switchVisibleCell(i,j);
                if (Taulell.getValidaCell(i, j) != TaulellCopiat.getValidaCell(i, j)) TaulellCopiat.switchValidaCell(i,j);
            }
        }
    }

    public static void netejaBoard(BoardHidato Taulell) {
        for (int i = 0; i < Taulell.getSize(); ++i) {
            for (int j = 0; j < Taulell.getSize(); ++j) {
                Taulell.setValueCell(0,i,j);
                if (Taulell.getWrittenCell(i,j) == true) Taulell.switchWrittenCell(i,j);
                else if (Taulell.getVisibleCell(i, j) == true) Taulell.switchVisibleCell(i, j);
                else if (Taulell.getStartCell(i, j) == true) Taulell.switchStartCell(i, j);
                else if (Taulell.getFinishCell(i, j) == true) Taulell.switchFinishCell(i, j);
                else if (Taulell.getValidaCell(i,j) == false) Taulell.switchValidaCell(i, j);
            }
        }
    }

    public static boolean perafegir(BoardHidato Taulell, int row, int column){
        if (Taulell.getValidaCell(row, column) && Taulell.getValueCell(row,column) == 0) return true;
        else return false;
    }

    public static void posa_final(BoardHidato Taulell,int numfinal) {
        boolean posatfinal = false;
        int size = Taulell.getSize();
        Random posifi = new Random();
        Random posjfi = new Random();
        int rowfi, columnfi;
        while (!posatfinal) {
            rowfi = posifi.nextInt(size);
            columnfi = posjfi.nextInt(size);
            if (Taulell.getValidaCell(rowfi, columnfi)) {
                Taulell.setValueCell(numfinal, rowfi, columnfi);
                Taulell.switchWrittenCell(rowfi, columnfi);
                Taulell.setStart_i(rowfi);
                Taulell.setStart_j(columnfi);
                posatfinal = true;
            }
        }
    }

    public static void generar_written(BoardHidato Taulell) {//posem al taulell les celes que al ppi estaran escrites
        //anar passant per totes les celes sensse repetirne cap
        //aleatoriament, anar posant visibles fins a arribar al maxim de visibles permeses per la dificultat
        int numcela, numvisibles, posactui, posactuj, posi, posj, size, numfinal;
        size = Taulell.getSize();
        numfinal = size * size - Taulell.consultar_num_celesinvalides();
        numcela = numvisibles = 1; //comencem per la 1 i amb 1 cela visible
        posactui = Taulell.getStart_i();
        posactuj = Taulell.getStart_j();
        Random segi = new Random();
        Random segj = new Random();
        double tantpercent = size * size * percentatgeceles();
        int totalsvisibles = (int) tantpercent;
        posa_final(Taulell,numfinal); //POSEM LA ULTIMA CELA AL TAULELL
        while (numvisibles < totalsvisibles) {
            posi = segi.nextInt(size);
            posj = segj.nextInt(size);
            if (perafegir(Taulell,posi,posj)){  //si la q volem anar es valida i no te valor, hi anem
                posactui = posactuj + posi;
                posactuj = posactuj + posj;
                ++numcela;
                ++numvisibles;
                Taulell.setValueCell(numcela, posactui, posactuj);
                Taulell.switchWrittenCell(posactui, posactuj);
            }
        }
        Taulell.setValueCell(numcela,posactui,posactuj);
        Taulell.switchWrittenCell(posactui,posactuj);
    }
    //if ()
    //posem tambe la ultima cela


    static boolean posarainvalida(BoardHidato Taulell,int row,int column) {//si totes les celes veines o totes menys una son invalides, return true
        //primer les q tenen 3 al voltant
        int inva = 0;
        int size = Taulell.getSize();
        if (row == 0 && column == 0 || row == 0 && column == size - 1 || row == size - 1 && column == 0 || row == size - 1 && column == size - 1) {
            if (row == 0)
                if ((!Taulell.getValidaCell(row + 1, column))) ++inva;
            if (column == 0)
                if ((!Taulell.getValidaCell(row, column + 1))) ++inva;
            if (row == size - 1)
                if ((!Taulell.getValidaCell(row - 1, column))) ++inva;
            if (column == size - 1)
                if ((!Taulell.getValidaCell(row, column - 1))) ++inva;
            if (row == 0 && column == 0)
                if ((!Taulell.getValidaCell(row + 1, column + 1))) ++inva;
            if (row == 0 && column == size - 1)
                if ((!Taulell.getValidaCell(row + 1, column - 1))) ++inva;
            if (row == size - 1 && column == 0)
                if ((!Taulell.getValidaCell(row - 1, column + 1))) ++inva;
            if (row == size - 1 && column == size - 1)
                if ((!Taulell.getValidaCell(row - 1, column - 1))) ++inva;
            System.out.println(inva + " invalides veines");
            if (inva >= 2) return true;
        }
        else if ((row > 0 && row < size - 1) && column == 0 || (column > 0 && column < size - 1) && row == 0 ||
                (row > 0 && row < size - 1) && column == size - 1 || (column > 0 && column < size - 1) && row == size - 1) {
            if (row > 0)
                if ((!Taulell.getValidaCell(row - 1, column))) ++inva; //amunt
            if (column > 0)
                if ((!Taulell.getValidaCell(row, column - 1))) ++inva;//esq
            if (row < size - 1)
                if ((!Taulell.getValidaCell(row + 1, column))) ++inva;//abaix
            if (column < size - 1)
                if ((!Taulell.getValidaCell(row, column + 1))) ++inva;//dreta
            if (row > 0 && column < size - 1)
                if ((!Taulell.getValidaCell(row - 1, column + 1))) ++inva;//amunt dreta
            if (row > 0 && column > 0)
                if ((!Taulell.getValidaCell(row - 1, column - 1))) ++inva;//amunt esq
            if (row < size - 1 && column < size - 1)
                if ((!Taulell.getValidaCell(row + 1, column + 1))) ++inva;//abaix dreat
            if (row < size - 1 && column > 0)
                if ((!Taulell.getValidaCell(row + 1, column - 1))) ++inva; //abaix esq
            System.out.println(inva + " invalides veines");
            if (inva >= 4) return true;
        } else {
            if (!Taulell.getValidaCell(row, column + 1)) ++inva;
            if (!Taulell.getValidaCell(row, column + 1)) ++inva;
            if (!Taulell.getValidaCell(row + 1, column + 1)) ++inva;
            if (!Taulell.getValidaCell(row - 1, column)) ++inva;
            if (!Taulell.getValidaCell(row, column - 1)) ++inva;
            if (!Taulell.getValidaCell(row - 1, column - 1)) ++inva;
            if (!Taulell.getValidaCell(row + 1, column - 1)) ++inva;
            if (!Taulell.getValidaCell(row - 1, column + 1)) ++inva;
            System.out.println(inva + " invalides veines");
            if (inva >= 4) return true;
        }
        return false;
    }
    static double percentatgeceles(){
        int percentatge = Game.getDifficult();
        if (percentatge == 1) return 0.2;
        else if (percentatge == 2) return 0.1;
        else return 0.05;
    }


    public static void posa_start(BoardHidato Taulell){
        boolean posatinici = false;
        int size = Taulell.getSize();
        Random posiini = new Random();
        Random posjini = new Random();
        int rowini, columnini;
        while (!posatinici) {
            rowini = posiini.nextInt(size);
            columnini = posjini.nextInt(size);
            if (Taulell.getValidaCell(rowini, columnini)) {
                Taulell.setValueCell(1, rowini, columnini);
                Taulell.switchWrittenCell(rowini, columnini);
                Taulell.setStart_i(rowini);
                Taulell.setStart_j(columnini);
                posatinici = true;
            }
        }
    }
    public static void colocar_celesinvalides(BoardHidato Taulell) {
        int posades, size;
        size = Taulell.getSize();
        //colocarem aleatoriament 10 celes invalides.
        Random posi = new Random();
        Random posj = new Random();
        posades = 0;
        double tantpercent = size * size * percentatgeceles();
        int maxinvalides = (int) tantpercent;
        System.out.println(percentatgeceles());
        System.out.println(size);
        System.out.println(size*size);
        System.out.println(tantpercent);
        System.out.println(maxinvalides);
        while (posades < maxinvalides) {
            int row = posi.nextInt(size);   //fila random entre totes les celes totals
            int column = posj.nextInt(size); //columan random entre totes les celes totals
            if (Taulell.getValidaCell(row, column)) {   //la cela q hem triat aleatoriament, si no es invalida la posem
                // la posem a invalida
                System.out.println("fila " + row + " columna " + column);
                Taulell.incrementar_celesinvalides(row, column);
                ++posades;
            }
        }
        posa_start(Taulell);
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (Taulell.getValidaCell(i, j)) {//si no es invalida mirem les del seu voltant
                    //si totes o totes menys una son invalides, la canviem a invalida tambe
                    System.out.println("comprovem " + i + " " + j);
                    if (Taulell.getValueCell(i,j) == 0 && posarainvalida(Taulell,i,j)) {
                        System.out.println("posem a invalida la casella " + i + " " + j);
                        Taulell.incrementar_celesinvalides(i, j);
                    }
                }
            }
        }
    }
    public static boolean verificadorSolucio(BoardHidato Taulell) {
        int actual_i = Taulell.getStart_i();;
        int actual_j = Taulell.getStart_j();
        int val_actual;
        boolean verificat = true;
        val_actual = Taulell.getValueCell(actual_i, actual_j);

        while ((actual_i != Taulell.getFinish_i() || actual_j != Taulell.getFinish_j()) && verificat) {
            if (actual_i < Taulell.getSize()-1 && (val_actual + 1) == Taulell.getValueCell(actual_i+1, actual_j)) ++actual_i;
            else if (actual_i > 0 && (val_actual + 1) == Taulell.getValueCell(actual_i-1, actual_j)) --actual_i;
            else if (actual_j < Taulell.getSize()-1 && (val_actual + 1) == Taulell.getValueCell(actual_i, actual_j+1))  ++actual_j;
            else if (actual_j > 0 && (val_actual + 1) == Taulell.getValueCell(actual_i, actual_j-1))  --actual_j;
            else if (actual_i > 0 && actual_j > 0 && (val_actual + 1) == Taulell.getValueCell(actual_i-1, actual_j-1)) {
                --actual_i;
                --actual_j;
            }
            else if (actual_i < Taulell.getSize()-1 && actual_j < Taulell.getSize()-1 && (val_actual + 1) == Taulell.getValueCell(actual_i+1, actual_j+1)) {
                ++actual_i;
                ++actual_j;
            }
            else if (actual_i > 0 && actual_j < Taulell.getSize()-1 && (val_actual + 1) == Taulell.getValueCell(actual_i-1, actual_j+1))  {
                --actual_i;
                ++actual_j;
            }
            else if (actual_j > 0 && actual_i < Taulell.getSize()-1 && (val_actual + 1) == Taulell.getValueCell(actual_i+1, actual_j-1)) {
                ++actual_i;
                --actual_j;
            }
            else {
                verificat = false;
            }
            ++val_actual;
        }
        return verificat;
    }

    public static boolean comprovar (BoardHidato Taulell, CellHidato[] intermitjos, Integer X[], Integer Y[], int countsize, int size) {

        //boolean resposta = false;
        //int size = countsize;
        //System.out.println(countsize);
        boolean espais_blancs = false;
        int comparador = (countsize-1)*2+1;  //aquest es el numero al qual ha de ser igual el comprovant si totes les caselles intermitjes tenen una casella adjecent de valor +1 i -1 respecte el seu propi valor i la final nomes en te una -1
        int comprovant = 0;
        //System.out.println("comprovant " + comprovant);
        int i;
        for(/*int*/ i=0; i<countsize; ++i) { //tots els intermitjos
            //System.out.println("entro");
            for (int j=0; j < 8;++j) {
                //System.out.println(intermitjos[i].getValue());
                //System.out.println("  " + (Taulell.getValueCell(intermitjos[i].getRow() + X[j], intermitjos[i].getColumn() + Y[j])+1));
                //System.out.println("  " + (Taulell.getValueCell(intermitjos[i].getRow() + X[j], intermitjos[i].getColumn() + Y[j])-1));
                if (intermitjos[i].getRow() + X[j] < size && intermitjos[i].getRow()+X[j] >= 0 && intermitjos[i].getColumn()+Y[j] < size && intermitjos[i].getColumn()+ Y[j] >= 0) {
                    if (intermitjos[i].getValue() == Taulell.getValueCell(intermitjos[i].getRow() + X[j], intermitjos[i].getColumn() + Y[j]) + 1 ||
                            intermitjos[i].getValue() == Taulell.getValueCell(intermitjos[i].getRow() + X[j], intermitjos[i].getColumn() + Y[j]) - 1) {
                        //System.out.println("comprovant " + comprovant);
                        //System.out.println("comprovant " + comprovant);
                        ++comprovant;
                    }
                    //System.out.println("entro");
                }
            }
        }
        //imprimeixValors(Taulell);
        //System.out.println("entro");
        /*for (int k=0; k < 8;++k) {
            //System.out.println(k);
            //System.out.println((countsize-1));
            //System.out.println(intermitjos[countsize-1].getValue());
            //el finish va a part perque al comprovacio es diferent
            if (intermitjos[countsize - 1].getRow() + X[k] < size && intermitjos[countsize - 1].getRow()+X[k] >= 0 && intermitjos[countsize - 1].getColumn()+Y[k]  < size && intermitjos[countsize - 1].getColumn()+ Y[k] >= 0) {
                if (intermitjos[countsize - 1].getValue() == Taulell.getValueCell(intermitjos[countsize - 1].getRow() + X[k], intermitjos[countsize - 1].getColumn() + Y[k]) + 1) {
                    ++comprovant;
                    //System.out.println("entro");
                }
            }
        }*/
        //System.out.println("comprovant  " + comprovant);
        //System.out.println("comparador " + comparador);
        //System.out.println();
        //imprimeixValors(Taulell);
        for (int k=0; k <size; ++k) {
            for (int p = 0; p < size; ++p){
                if (Taulell.getValidaCell(k,p) && Taulell.getValueCell(k,p) == 0) espais_blancs= true;
            }
        }


        return (comprovant==comparador && !espais_blancs);
    }






    public static void backtrack(BoardHidato Taulell, boolean[][] visitats, CellHidato[] intermitjos,int startx, int starty, Integer X[], Integer Y[], int current, int countsize, int size)   {
        // Fent servir el taulell, la matriu de visitats, el punt de start i el punt de finish,
        // resoldre el taulell i posar els valors de caselles not written als que toquen
        //Boolean acabat = false;
        Boolean canviat = false;
        if (comprovar(Taulell, intermitjos, X, Y,countsize, size)) {
            imprimeixValors(Taulell);

        }

        else  {
            //imprimeixValors(Taulell);
            //System.out.println();
            //System.out.println("entro");
            for (int i= 0; i < 8; ++i ) {
                if (startx+X[i] >=0 && startx+X[i] < size && starty+Y[i] >= 0 && starty+Y[i] < size) {
                    //System.out.println((startx + X[i])+ " "+(starty + Y[i]));
                    //System.out.println(size);
                    //if (startx + X[i] < size && startx + X[i] >= 0 && startx + Y[i] < size && startx + Y[i] >= 0) {
                    if (!visitats[startx + X[i]][starty + Y[i]]) {
                        if (!Taulell.getWrittenCell(startx + X[i], starty + Y[i])|| (Taulell.getWrittenCell(startx + X[i], starty + Y[i]) && Taulell.getValueCell(startx + X[i], starty + Y[i]) == current)) {
                            if (!Taulell.getWrittenCell(startx + X[i], starty + Y[i])) {
                                Taulell.setValueCell(current, startx + X[i], starty + Y[i]);
                                canviat = true;
                            }
                            visitats[startx + X[i]][starty + Y[i]] = true;
                            //System.out.println("entro");
                            backtrack(Taulell, visitats, intermitjos, startx + X[i], starty + Y[i], X, Y, current + 1, countsize, size);
                            visitats[startx + X[i]][starty + Y[i]] = false;
                            if (canviat) {
                                Taulell.setValueCell(0, startx + X[i], starty + Y[i]);
                                Taulell.switchWrittenCell(startx + X[i], starty + Y[i]);
                                canviat = false;
                            }
                        }

                    }

                }
            }
        }
        //System.out.println("acabat");
    }


    public static void solve (BoardHidato Taulell, int size)    {   //de moment ho farem amb un taulell arbitrari

        //imprimeixValors(Taulell);

        int startx = 0;  //i de la primera cela
        int starty = 0;  //j de la ultima cela
        int finish = 1;
        int countsize = 0;
        //int finishx = 0; //i  de la ultima cela
        //int finishy = 0; //j de la ultima cela
        //llegirTaulell(start, finish, size);
        boolean visitats[][] = new boolean[size][size];
        //ArrayList<CellHidato> intermitjos = new ArrayList<CellHidato>();

        Integer X[] = {0,1,1,1,0,-1,-1,-1};
        Integer Y[] = {1,1,0,-1,-1,-1,0,1};

        for (int i = 0; i < size; ++i)  {
            for (int j = 0; j < size; ++j)  {
                //System.out.println(j);
                if (Taulell.getValidaCell(i,j)) {

                    if (Taulell.getValueCell(i,j) == 1)   {
                        visitats[i][j] = true;               //guardem casella start i la marquem com a visitada
                        startx = i;
                        starty = j;
                    }
                    else visitats[i][j] = false; //caselles a omplir marcades com a "no visitades"


                    //System.out.println("finish " +finish);
                    //System.out.println(i + " " + j + " " + Taulell.getWrittenCell(i,j));
                    //System.out.println(i + " " + j + " " + Taulell.getValueCell(i,j));
                if (Taulell.getWrittenCell(i,j) && Taulell.getValueCell(i,j) > finish)    {
                    //finish = Taulell.getValueCell(i,j);
                    //finishx = i;                                  //guerdem la casella amb el valor mes alt del taulell
                    //finishy = j;
                    ++countsize;

                    //System.out.println("countsize " + countsize);                  //com a casella finish
                    //intermitjos.add(new CellHidato(i,j));         //afegim els written = true al Array intermitjos


                }
                }
                else if (!Taulell.getValidaCell(i, j)) visitats[i][j] = true; //caselles invalides marcades com a "visitades"
                //System.out.println(Taulell.getValueCell(i,j) + " " +Taulell.getWrittenCell(i,j));

            }
        }
        /*for (int p = 0; p < size; ++p){
            for (int u = 0; u < size; ++u)  {
                System.out.println(Taulell.getValueCell(p,u) + " " + visitats[p][u]);
            }
        }*/

        CellHidato intermitjos[] = new CellHidato[countsize];
        int iterador = 0;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if(Taulell.getValidaCell(i,j) && Taulell.getWrittenCell(i,j) && Taulell.getValueCell(i,j) > 1) {
                    if (Taulell.getValueCell(i,j) > finish) finish = Taulell.getValueCell(i, j);
                    intermitjos[iterador] = Taulell.getCell(i,j);
                    ++iterador;
                }
            }
        }
        //System.out.println("iterador " + iterador);
        //System.out.println("finish " + finish);
        //System.out.println("valor de 0 " + intermitjos[0].getValue());
        //System.out.println("valor de 1 " + intermitjos[1].getValue());
        //System.out.println("valor de 2 " + intermitjos[2].getValue());

        int current = 2;
        backtrack(Taulell, visitats, intermitjos, startx, starty, X, Y, current,countsize,size);  //resoldre taulell
    }

    public static boolean backtrackBool(BoardHidato Taulell, boolean[][] visitats, CellHidato[] intermitjos,int startx, int starty, Integer X[], Integer Y[], int current, int countsize, int size, boolean solucio)   {
        // Fent servir el taulell, la matriu de visitats, el punt de start i el punt de finish,
        // resoldre el taulell i posar els valors de caselles not written als que toquen
        //Boolean acabat = false;
        Boolean canviat = false;
        if (comprovar(Taulell, intermitjos, X, Y,countsize, size)) {
            //imprimeixValors(Taulell);
            solucio = true;

        }

        else  {
            //imprimeixValors(Taulell);
            //System.out.println();
            //System.out.println("entro");
            for (int i= 0; i < 8; ++i ) {
                if (startx+X[i] >=0 && startx+X[i] < size && starty+Y[i] >= 0 && starty+Y[i] < size) {
                    //System.out.println((startx + X[i])+ " "+(starty + Y[i]));
                    //System.out.println(size);
                    //if (startx + X[i] < size && startx + X[i] >= 0 && startx + Y[i] < size && startx + Y[i] >= 0) {
                    if (!visitats[startx + X[i]][starty + Y[i]]) {
                        if (!Taulell.getWrittenCell(startx + X[i], starty + Y[i])|| (Taulell.getWrittenCell(startx + X[i], starty + Y[i]) && Taulell.getValueCell(startx + X[i], starty + Y[i]) == current)) {
                            if (!Taulell.getWrittenCell(startx + X[i], starty + Y[i])) {
                                Taulell.setValueCell(current, startx + X[i], starty + Y[i]);
                                canviat = true;
                            }
                            visitats[startx + X[i]][starty + Y[i]] = true;
                            //System.out.println("entro");
                            backtrackBool(Taulell, visitats, intermitjos, startx + X[i], starty + Y[i], X, Y, current + 1, countsize, size, solucio);
                            visitats[startx + X[i]][starty + Y[i]] = false;
                            if (canviat) {
                                Taulell.setValueCell(0, startx + X[i], starty + Y[i]);
                                Taulell.switchWrittenCell(startx + X[i], starty + Y[i]);
                                canviat = false;
                            }
                        }

                    }

                }
            }
        }
        //System.out.println("acabat");
        return solucio;
    }

    public static boolean solveBool (BoardHidato Taulell, int size)    {   //de moment ho farem amb un taulell arbitrari
        //imprimeixValors(Taulell);

        int startx = 0;  //i de la primera cela
        int starty = 0;  //j de la ultima cela
        int finish = 1;
        int countsize = 0;
        boolean solucio = false;
        //int finishx = 0; //i  de la ultima cela
        //int finishy = 0; //j de la ultima cela
        //llegirTaulell(start, finish, size);
        boolean visitats[][] = new boolean[size][size];
        //ArrayList<CellHidato> intermitjos = new ArrayList<CellHidato>();

        Integer X[] = {0,1,1,1,0,-1,-1,-1};
        Integer Y[] = {1,1,0,-1,-1,-1,0,1};

        for (int i = 0; i < size; ++i)  {
            for (int j = 0; j < size; ++j)  {
                //System.out.println(j);
                if (Taulell.getValidaCell(i,j)) {

                    if (Taulell.getValueCell(i,j) == 1)   {
                        visitats[i][j] = true;               //guardem casella start i la marquem com a visitada
                        startx = i;
                        starty = j;
                    }
                    else visitats[i][j] = false; //caselles a omplir marcades com a "no visitades"


                    //System.out.println("finish " +finish);
                    //System.out.println(i + " " + j + " " + Taulell.getWrittenCell(i,j));
                    //System.out.println(i + " " + j + " " + Taulell.getValueCell(i,j));
                    if (Taulell.getWrittenCell(i,j) && Taulell.getValueCell(i,j) > finish)    {
                        //finish = Taulell.getValueCell(i,j);
                        //finishx = i;                                  //guerdem la casella amb el valor mes alt del taulell
                        //finishy = j;
                        ++countsize;

                        //System.out.println("countsize " + countsize);                  //com a casella finish
                        //intermitjos.add(new CellHidato(i,j));         //afegim els written = true al Array intermitjos


                    }
                }
                else if (!Taulell.getValidaCell(i, j)) visitats[i][j] = true; //caselles invalides marcades com a "visitades"
                //System.out.println(Taulell.getValueCell(i,j) + " " +Taulell.getWrittenCell(i,j));

            }
        }
        /*for (int p = 0; p < size; ++p){
            for (int u = 0; u < size; ++u)  {
                System.out.println(Taulell.getValueCell(p,u) + " " + visitats[p][u]);
            }
        }*/

        CellHidato intermitjos[] = new CellHidato[countsize];
        int iterador = 0;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if(Taulell.getValidaCell(i,j) && Taulell.getWrittenCell(i,j) && Taulell.getValueCell(i,j) > 1) {
                    if (Taulell.getValueCell(i,j) > finish) finish = Taulell.getValueCell(i, j);
                    intermitjos[iterador] = Taulell.getCell(i,j);
                    ++iterador;
                }
            }
        }
        //System.out.println("iterador " + iterador);
        //System.out.println("finish " + finish);
        //System.out.println("valor de 0 " + intermitjos[0].getValue());
        //System.out.println("valor de 1 " + intermitjos[1].getValue());
        //System.out.println("valor de 2 " + intermitjos[2].getValue());

        int current = 2;
        solucio = backtrackBool(Taulell, visitats, intermitjos, startx, starty, X, Y, current, countsize, size, solucio);  //resoldre taulell
        return solucio;
    }
}
