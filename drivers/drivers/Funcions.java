package drivers;
import domini.*;

import java.util.*;


/**
 * Created by Jordi Guiu on 02/11/2015.
 * Classe per ficar-hi algunes funcions, mes endavant decidirem com ho fem.
 */


public class Funcions {
    public static void colocar_celesinvalides(BoardHidato Taulell) {
        int sizeT, ncelesvalT;
        sizeT = Taulell.getSize();

       /* colocarem aleatoriament 10 celes invalides.
        haurem de tenir en compte:
        - que no es divideixi el taulell en regions
        - que cap cela es quedi aillada (vindria a ser una especificacio de regio)
        */
        //note a single Random object is reused here
        Random posi = new Random();
        Random posj = new Random();
        int posades = 0;
        while (posades <= 9) {
            ncelesvalT = sizeT - Taulell.consultar_num_celesinvalides();
            int row = posi.nextInt(ncelesvalT);
            int column = posj.nextInt(ncelesvalT);
            if (!Taulell.getValidaCell(row, column)) {
                Taulell.incrementar_celesinvalides(row, column);
                ++posades;
            }
            //consultarem el nombre de celes possibles cada cop
        }
    }

    public static void imprimeixValors(BoardHidato Taulell) {
        for (int i = 0; i < Taulell.getSize();i++) {
            for (int j = 0; j < Taulell.getSize();j++) {
                System.out.print(Taulell.getValueCell(i,j) + " ");

            }
            System.out.println();
        }
    }

    public static void llegirTaulell(BoardHidato Taulell, int size)   {
        int valor;
        Scanner input = new Scanner( System.in );

        for (int i = 0; i < size; ++i)  {
            for (int j = 0; j < size; ++j)  {
                valor = input.nextInt();
                Taulell.setValueCell(valor, i, j);
            }
        }
        //Aqu� mirar si aquest taulell posat t� soluci�, si en t� ok, sin� tot a 0 altre cop.
    }

    public boolean comprovar (BoardHidato Taulell, ArrayList<CellHidato> intermitjos, Integer X[], Integer Y[] ) {

        //boolean resposta = false;
        int size = intermitjos.size();
        int comparador = (size-1)*2+1;  //aquest es el numero al qual ha de ser igual el comprovant si totes les caselles intermitjes tenen una casella adjecent de valor +1 i -1 respecte el seu propi valor i la final nomes en te una -1
        int comprovant = 0;
        for(int i=0; i<size-1; ++i) { //tots els intermitjos
            for (int j=0; j < 8;++j) {
                if (intermitjos.get(i).getValue() == Taulell.getValueCell(intermitjos.get(i).getRow()+X[j],intermitjos.get(i).getColumn()+Y[j])+1 ||
                        intermitjos.get(i).getValue() == Taulell.getValueCell(intermitjos.get(i).getRow()+X[j],intermitjos.get(i).getColumn()+Y[j])-1) ++comprovant;
            }
        }
        for (int k=0; k < 8;++k) { //el finish va a part perque al comprovacio es diferent
            if (intermitjos.get(size-1).getValue() == Taulell.getValueCell(intermitjos.get(k).getRow()+X[k],intermitjos.get(k).getColumn()+Y[k])+1) ++comprovant;
        }
        return (comprovant==comparador);
    }




    public void backtrack(BoardHidato Taulell, boolean[][] visitats, ArrayList<CellHidato> intermitjos,int startx, int starty, /*int finish, int finishx, int finishy,*/ Integer X[], Integer Y[], int current)   {
    // Fent servir el taulell, la matriu de visitats, el punt de start i el punt de finish,
    // resoldre el taulell i posar els valors de caselles not written als que toquen
        if (comprovar(Taulell, intermitjos,X,Y)) imprimeixValors(Taulell);
        else {
            for (int i= 0; i < 8; ++i ) {
                if (!visitats[startx+X[i]][starty+Y[i]])  {
                    if (!Taulell.getWrittenCell(startx+X[i],starty+Y[i])) Taulell.setValueCell(current, startx + X[i], starty + Y[i]);
                    visitats[startx+X[i]][starty+Y[i]] = true;
                    backtrack(Taulell,visitats,intermitjos,startx+X[i],starty+Y[i],X,Y,current+1);
                }
            }
        }
    }


    public void solve (BoardHidato Taulell, int size)    {   //de moment ho farem amb un taulell arbitrari
        Scanner input = new Scanner( System.in );



        size = 5;
        Taulell = new BoardHidato(size);       //creem board arbitrari de mida 5

        Taulell.setValueCell(-1, 0, 0);
        //Taulell.get(0).get(0).set
        Taulell.setValueCell(-1, 0, 1);
        Taulell.setValueCell(-1, 0, 2);            //Forma del taulell
        Taulell.setValueCell(-1, 0, 3);
        Taulell.setValueCell(-1, 0, 4);            // -1 -1 -1 -1 -1
                                                   // -1  0  0  3 -1
        Taulell.setValueCell(-1, 1, 0);            // -1  0  1  0 -1     // els 0 son caselles
        //Taulell.setValueCell(0, 1, 1);           // -1  0  0  9 -1     // a omplir
        Taulell.setValidaCell(1,1);
        //Taulell.setValueCell(0, 1, 2);
        Taulell.setValidaCell(1,2);
        Taulell.setValueCell(3, 1, 3); //casella intermitja
        Taulell.setValidaCell(1,3);
        Taulell.switchWrittenCell(1,3); //written intermitja (3)
        Taulell.setValueCell(-1, 1, 4);

        Taulell.setValueCell(-1, 2, 0);
        //Taulell.setValueCell(0, 2, 1);
        Taulell.setValidaCell(2,1);
        Taulell.setValueCell(1, 2, 2); //casella start
        Taulell.setValidaCell(2,2);
        Taulell.switchWrittenCell(2,2); //written start
        //Taulell.setValueCell(0, 2, 3);
        Taulell.setValidaCell(2,3);
        Taulell.setValueCell(-1, 2, 4);

        Taulell.setValueCell(-1, 3, 0);
        //Taulell.setValueCell(0, 3, 1);
        Taulell.setValidaCell(3,1);
        //Taulell.setValueCell(0, 3, 2);
        Taulell.setValidaCell(3,2);
        Taulell.setValueCell(9, 3, 3); //casella finish
        Taulell.setValidaCell(3,3);
        Taulell.switchWrittenCell(3,3);//written finish
        Taulell.setValueCell(-1, 3, 4);

        Taulell.setValueCell(-1, 4, 0);
        Taulell.setValueCell(-1, 4, 1);
        Taulell.setValueCell(-1, 4, 2);
        Taulell.setValueCell(-1, 4, 3);
        Taulell.setValueCell(-1, 4, 4);




        int startx = 0;  //i de la primera cela
        int starty = 0;  //j de la ultima cela
        int finish = 1;
        int finishx = 0; //i  de la ultima cela
        int finishy = 0; //j de la ultima cela
        //llegirTaulell(start, finish, size);
        boolean visitats[][] = new boolean[size][size];
        ArrayList<CellHidato> intermitjos = new ArrayList<CellHidato>();
        Integer X[] = {0,1,1,1,0,-1,-1,-1};
        Integer Y[] = {1,1,0,-1,-1,-1,0,1};

        for (int i = 0; i < size; ++i)  {
            for (int j = 0; j < size; ++j)  {

                if (Taulell.getValidaCell(i,j)) {
                    if (Taulell.getValueCell(i,j) == 1)   {
                        visitats[i][j] = true;               //guardem casella start i la marquem com a visitada
                        startx = i;
                        starty = j;
                    }
                    else visitats[i][j] = false; //caselles a omplir marcades com a "no visitades"
                }
                else /*if (!Taulell.getValidaCell(i, j))*/ visitats[i][j] = true; //caselles invalides marcades com a "visitades"


                if (Taulell.getWrittenCell(i,j) && Taulell.getValueCell(i,j) > finish)    {
                    finish = Taulell.getValueCell(i,j);
                    finishx = i;                                 //guerdem la casella amb el valor mes alt del taulell
                    finishy = j;                                 //com a casella finish
                    intermitjos.add(new CellHidato(i,j));        //afegim els written = true al Array intermitjos

                }

            }
        }
        int current = 1;
        backtrack(Taulell, visitats, intermitjos, startx, starty, /*finish, finishx, finishy,*/ X, Y, current);  //resoldre taulell
    }
}
