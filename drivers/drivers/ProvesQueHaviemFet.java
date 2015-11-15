package drivers;
import domini.*;

import java.util.*;

/**
 * Created by Jordi Guiu on 02/11/2015.
 * Classe per fer proves de Run a veure si funcionen les classes que hem fet com volem.
 */

public class ProvesQueHaviemFet {
    public static void main(/*String[] args*/) {
        Scanner input = new Scanner( System.in );
        int size;
        //int num,dif;
        int column;
        int row;
        System.out.printf("Entra mida taulell:  ");

        size = input.nextInt();
        BoardHidato Taulell = new BoardHidato(size); //cambiat Board per BoardHidato

        /*System.out.printf("numero del joc i dificultat:  ");
        num = input.nextInt();
        dif = input.nextInt();
        Game joc = new Game(num,dif); //id 1 difficult 2

        System.out.println("GameId?:" + joc.getGameId());
        System.out.println("Canvio GameId a 23");
        joc.setGameId(23);
        System.out.println("GameId?:" + joc.getGameId());

        System.out.println("Dificultat? " + joc.getDifficult());
        System.out.println("Canvio Dificult a 3");
        joc.setDifficult(3);
        System.out.println("Dificultat:" + joc.getDifficult());*/

        System.out.println("mida taulell:" + Taulell.getSize()); //treu mida taulell

        System.out.println("Nombre maxim de marques? (size*size):" + Taulell.consult_max_annotations());

        //Imprimeix el taulell
        System.out.println();
        Funcions.imprimeixValors(Taulell);
        System.out.println();

        System.out.println("Poso un 2 a la [1][1]");
        Taulell.setValueCell(2, 1, 1); //Posar el 2
        Taulell.switchVisibleCell(1, 1); //Fer cell visible

        //Imprimeix el taulell
        System.out.println();
        Funcions.imprimeixValors(Taulell);
        System.out.println();

        System.out.println("Poso un 23 a la [3][3]");
        Taulell.setValueCell(23, 3, 3);
        Taulell.switchVisibleCell(3, 3); //Fer cell visible

        //Imprimeix el taulell
        System.out.println();
        Funcions.imprimeixValors(Taulell);
        System.out.println();
        //cela 0 3 haurai de sortir com a no escrita
        if (Taulell.getWrittenCell(0,3))  System.out.println("ESCRITA");
        else  System.out.println("NO ESCRITA");
        System.out.println("Poso un 3 a la [0][3]");
        Taulell.setValueCell(3,0,3);
        Taulell.switchVisibleCell(0,3); //Fer cell visible


        //Imprimeix el taulell
        System.out.println();
        Funcions.imprimeixValors(Taulell);
        System.out.println();

        System.out.println("Posicio[0][0]? " + Taulell.getValueCell(0,0));
        System.out.println("Posicio[0][3]? " + Taulell.getValueCell(0,3));
        System.out.println("Posicio[4][4]? " + Taulell.getValueCell(4,4));

        System.out.println("mirem si aquesta cela esta escrita");
        //hauria de donar ESCRITA
        if (Taulell.getWrittenCell(0,3))  System.out.println("ESCRITA");
        else  System.out.println("NO ESCRITA");


        System.out.println();
        /*
        System.out.println("PROVA DE CELA HIDATO");
        System.out.println("Entra una fila i una columna per crear una cela hidato qualsevol:  ");

        row = input.nextInt();
        column = input.nextInt();

        System.out.println("Es crea una cela c amb fila i columna que acabes de posar");

        CellHidato c = new CellHidato(row, column);

        System.out.println("Valor de la Cela? (Hauria de veure 0, valor per defecte): " + c.getValue());

        System.out.println("Columna de la cela? (Hauria de veure la columna que he posat): " + c.getColumn());

        System.out.println("Fila de la cela? (Hauria de veure la fila que he posat): " + c.getRow());

        System.out.println("Marca 2 en la cela? (false): " + c.getAnnotation(2));

        System.out.println("Fas switchAnnotation de la marca 2");
        c.switchAnnotation(2);

        System.out.println("Marca 2 en la cela? (true): " + c.getAnnotation(2));

        System.out.println("Fas un setAnnotation per posar la marca 3 a true");
        c.setAnnotation(3, true);

        System.out.println("Marca 3 en la cela? (true): " + c.getAnnotation(3));


        System.out.println("Esta escrit el c2?: " + c.getWritten());

        System.out.println("Faig un switchWritten per canviar l'estat de Escrit");

        c.switchWritten();

        System.out.println("Esta escrit el c2?: " + c.getWritten());

        System.out.println("Faig un switchWritten per canviar l'estat de Escrit");

        c.switchWritten();

        System.out.println("Esta escrit el c2?: " + c.getWritten());

        System.out.println("Esta visible el c2?: " + c.getVisible());

        System.out.println("Faig un switchVisible per canviar l'estat de Escrit");

        c.switchVisible();

        System.out.println("Esta visible el c2?: " + c.getVisible());

        System.out.println("Faig un switchVisible per canviar l'estat de Escrit");

        c.switchVisible();

        System.out.println("Esta escrit el c2?: " + c.getVisible());
        */
    }

    public static void imprimeixVisibles(BoardHidato Taulell) {
        System.out.println("+: Visible, _: No visible");
        for (int i = 0; i < Taulell.getSize();i++) {
            for (int j = 0; j < Taulell.getSize();j++) {
                if (Taulell.getVisibleCell(i,j)) System.out.print ("+ _");
                else System.out.print("_ ");
            }
            System.out.println();
        }
    }
}



//PROVES DE CONSULTAR I EDITAR VALOR DE CELA

/*System.out.println("4 : Consultar el valor d'una certa cela.");
            System.out.println("5 : Canviar el valor d'una certa cela.");  */

/*else if(entrada == 4) {
                    while (sn == 's') {
                        System.out.println("Introdueix  la fila i columna de la cela que vols consultar:");
                        val1 = input.nextInt();
                        val2 = input.nextInt();
                        if ((val1 | val2) >= size) System.out.println("Has sortit fora del taulell.");
                        else System.out.println(Taulell.getValueCell(val1,val2));
                        System.out.println("Vols consultar una altra cela? (s/n):");
                        sn = input.next().charAt(0);
                    }
                } else if(entrada == 5) {
                    while (sn == 's') {
                        System.out.println("Introdueix el valor que vols posar i la fila i columna de la cela on ho vols posar:");
                        val1 = input.nextInt();
                        val2 = input.nextInt();
                        val3 = input.nextInt();
                        if ((val2 | val3) >= size) System.out.println("Has sortit fora del taulell.");
                        else {
                            Taulell.setValueCell(val1, val2, val3);
                            System.out.println("Valor introduit.");
                        }
                        System.out.println("Vols introduir una altra cela? (s/n):");
                        sn = input.next().charAt(0);
                    }
                } */




//PEL BACKTRACK


/*
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
        Taulell.setValueCell(5, 7, 6);*/



    /**/