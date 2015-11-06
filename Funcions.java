package domini;
import java.util.*;


/**
 * Created by Jordi Guiu on 02/11/2015.
 * Classe per ficar-hi algunes funcions, mes endavant decidirem com ho fem.
 */


public class Funcions {
    public static void imprimeixValors(Board Taulell) {
        for (int i = 0; i < Taulell.getSize();i++) {
            for (int j = 0; j < Taulell.getSize();j++) {
                if (Taulell.isVisible(i,j)) System.out.print(Taulell.getValueCell(i,j) + " ");
                else System.out.print("_" + " ");

            }
            System.out.println();
            //escric aixo q sino no puc fer commit
        }
    }

    /*public void readBoard (int start, int finish, int size)   {

        Scanner input = new Scanner( System.in );

        for (int i = 0; i < size; ++i)  {
            for (int j = 0; j < size; ++j)  {
                char c = input.next().charAt(0);
            }
        }



    }*/

    public void backtrack(BoardHidato Taulell, boolean[][] visitats, int size, int start, int startx, int starty, int finish, int finishx, int finishy)   {
    // Fent servir el taulell, la matriu de visitats, el punt de start i el punt de finish,
    // resoldre el taulell i posar els valors 0 als que toquen
    }


    public void solve (/*Board Taulell, int size*/)    {   //de moment ho farem amb un taulell arbitrari
        Scanner input = new Scanner( System.in );
        int size = 5;
        BoardHidato Taulell = new BoardHidato(size);       //creem board arbitrari de mida 5

        Taulell.setValueCell(-1, 0, 0);
        Taulell.setValueCell(-1, 0, 1);
        Taulell.setValueCell(-1, 0, 2);            //Forma del taulell
        Taulell.setValueCell(-1, 0, 3);
        Taulell.setValueCell(-1, 0, 4);            // -1 -1 -1 -1 -1
                                                           // -1  0  0  0 -1
        Taulell.setValueCell(-1, 1, 0);            // -1  0  1  0 -1     // els 0 son caselles
        Taulell.setValueCell(0, 1, 1);             // -1  0  0  9 -1     // a omplir
        Taulell.setValueCell(0, 1, 2);             // -1 -1 -1 -1 -1
        Taulell.setValueCell(0, 1, 3);
        Taulell.setValueCell(-1, 1, 4);

        Taulell.setValueCell(-1, 2, 0);
        Taulell.setValueCell(0, 2, 1);
        Taulell.setValueCell(1, 2, 2); //casella start
        Taulell.setValueCell(0, 2, 3);
        Taulell.setValueCell(-1, 2, 4);

        Taulell.setValueCell(-1, 3, 0);
        Taulell.setValueCell(0, 3, 1);
        Taulell.setValueCell(0, 3, 2);
        Taulell.setValueCell(9, 3, 3); //casella finish
        Taulell.setValueCell(-1, 3, 4);

        Taulell.setValueCell(-1, 4, 0);
        Taulell.setValueCell(-1, 4, 1);
        Taulell.setValueCell(-1, 4, 2);
        Taulell.setValueCell(-1, 4, 3);
        Taulell.setValueCell(-1, 4, 4);



        int start = 1;
        int startx = 0;  //i de la primera cela
        int starty = 0;  //j de la ultima cela
        int finish = 0;
        int finishx = 0; //i  de la ultima cela
        int finishy = 0; //j de la ultima cela
        //readBoard(start, finish, size);
        boolean visitats[][] = new boolean[size][size];
        for (int i = 0; i < size; ++i)  {
            for (int j = 0; j < size; ++j)  {

                if (Taulell.getValueCell(i,j) == 0) visitats[i][j] = false; //caselles a omplir marcades com a "no visitades"
                if (Taulell.getValueCell(i,j) == -1) visitats[i][j] = true; //caselles invalides marcades com a "visitades"
                if (Taulell.getValueCell(i,j) == 1)   {
                    visitats[i][j] = true;                                  //guardem casella start i la marquem com a visitada
                    startx = i;
                    starty = j;
                }
                else if (Taulell.getValueCell(i,j) > finish)    {
                    finish = Taulell.getValueCell(i,j);
                    finishx = i;                                 //guerdem la casella amb el valor mes alt del taulell
                    finishy = j;                                 //com a casella finish

                }
            }
        }
        backtrack(Taulell, visitats, size, start, startx, starty, finish, finishx, finishy);  //resoldre taulell
        imprimeixValors(Taulell);   //escriure taulell
    }
}
