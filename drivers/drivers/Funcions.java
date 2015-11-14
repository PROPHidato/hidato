package drivers;
import domini.*;
import java.util.*;

import static java.lang.System.out;

public class Funcions {

    public static void imprimeixValors(BoardHidato Taulell) {
        for (int i = 0; i < Taulell.getSize();i++) {
            for (int j = 0; j < Taulell.getSize();j++) {
                if (!Taulell.getValidaCell(i,j)) out.print("X" + " ");
                else out.print(Taulell.getValueCell(i,j) + " ");

            }
            out.println();
        }
        out.println();
    }

    public static void llegirTaulell(BoardHidato Taulell, int size)   {
        int valor;
        int valormax = 1;
        Scanner input = new Scanner( System.in );

        for (int i = 0; i < size; ++i)  {
            for (int j = 0; j < size; ++j)  {
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
            }
        }
        //Aqui mirar si es podria resoldre, si es pot ok, sinó merda.
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




        //Taulell.setValueCell(17, 0, 0);
        //Taulell.switchValidaCell(0,0);
        //System.out.println("[0][0] Valida?: " + Taulell.getValidaCell(0,0));

        Taulell.setValueCell(33, 0, 1);
        //Taulell.switchValidaCell(0,1);

        Taulell.setValueCell(35, 0, 2);
        //Taulell.switchValidaCell(0,2);

        //Taulell.setValueCell(11, 0, 3);
        //Taulell.switchValidaCell(0,3);

        //Taulell.setValueCell(21, 0, 4);            // -1 -1 -1 -1 -1
        //Taulell.switchValidaCell(0,4);

        Taulell.switchValidaCell(0,5);
        Taulell.switchValidaCell(0,6);
        Taulell.switchValidaCell(0,7);
        // -1  0  0  3 -1
        //Taulell.setValueCell(-1, 1, 0);
        //Taulell.switchValidaCell(1,0);
                                                   // -1  0  1  0 -1     // els 0 son caselles
        //Taulell.setValueCell(1, 1, 1);
        //Taulell.switchValidaCell(1,1);            //-1  0  0  9 -1     // a omplir

        Taulell.setValueCell(24, 1, 2);


        Taulell.setValueCell(22, 1, 3);              //casella intermitja
        //Taulell.switchWrittenCell(1,3);
        //System.out.println("[1][3] Written?: " + Taulell.getWrittenCell(1, 3));
                                                    //written intermitja (3)
        //Taulell.setValueCell(-1, 1, 4);
        //Taulell.switchValidaCell(1,4);

        Taulell.switchValidaCell(1,5);
        Taulell.switchValidaCell(1,6);
        Taulell.switchValidaCell(1,7);

        //Taulell.setValueCell(-1, 2, 0);
        //Taulell.switchValidaCell(2,0);

        //Taulell.setValueCell(6, 2, 1);

        //Taulell.setValueCell(1, 2, 2); //casella start
        //Taulell.switchWrittenCell(2,2); //written start
        //Taulell.switchValidaCell(2,2);
        //System.out.println("[2][2] Written?: " + Taulell.getWrittenCell(2,2));

        Taulell.setValueCell(21, 2, 3);

        //Taulell.setValueCell(-1, 2, 4);
        //Taulell.switchValidaCell(2,4);

        Taulell.switchValidaCell(2,6);
        Taulell.switchValidaCell(2,7);
        //System.out.println("[3][0] Written?: " + Taulell.getWrittenCell(3,0));
        //Taulell.setValueCell(4, 3, 0);
        //System.out.println("[3][0] Written?: " + Taulell.getWrittenCell(3,0));
        //Taulell.switchValidaCell(3,0);
        //System.out.println("[3][0] Written?: " + Taulell.getWrittenCell(3,0));

        Taulell.setValueCell(26, 3, 1);

        //Taulell.setValueCell(8, 3, 2);
        //System.out.println("[3][2] Written?: " + Taulell.getWrittenCell(3,2));

        Taulell.setValueCell(13, 3, 3); //casella finish
        //System.out.println("[3][3] Written?: " + Taulell.getWrittenCell(3,3));
        //Taulell.switchWrittenCell(3,3);//written finish
        //System.out.println("[3][3] Written?: " + Taulell.getWrittenCell(3,3));

        Taulell.setValueCell(40, 3, 4);
        //Taulell.switchValidaCell(3,4);
        Taulell.setValueCell(11, 3, 5);

        Taulell.switchValidaCell(3,6);
        Taulell.switchValidaCell(3,7);

        Taulell.setValueCell(27, 4, 0);
        //Taulell.switchValidaCell(4,0);

        //Taulell.setValueCell(-1, 4, 1);
        //Taulell.switchValidaCell(4,1);

        //Taulell.setValueCell(-1, 4, 2);
        //Taulell.switchValidaCell(4,2);

        //Taulell.setValueCell(-1, 4, 3);
        //Taulell.switchValidaCell(4,3);

        Taulell.setValueCell(9, 4, 4);
        //Taulell.switchValidaCell(4,4);

        Taulell.setValueCell(1, 4, 6);

        Taulell.switchValidaCell(4,7);

        Taulell.switchValidaCell(5,0);
        Taulell.switchValidaCell(5,1);
        Taulell.setValueCell(18, 5, 4);
        Taulell.switchValidaCell(5,7);

        Taulell.switchValidaCell(6,0);
        Taulell.switchValidaCell(6,1);
        Taulell.switchValidaCell(6,2);
        Taulell.switchValidaCell(6,3);
        Taulell.setValueCell(7, 6, 5);

        Taulell.switchValidaCell(7,0);
        Taulell.switchValidaCell(7,1);
        Taulell.switchValidaCell(7,2);
        Taulell.switchValidaCell(7,3);
        Taulell.switchValidaCell(7,4);
        Taulell.switchValidaCell(7,5);
        Taulell.setValueCell(5, 7, 6);




        imprimeixValors(Taulell);

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
}
