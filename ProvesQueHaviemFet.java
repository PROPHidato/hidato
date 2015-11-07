package domini;
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
        Taulell.setVisibleCell(1, 1); //Fer cell visible

        //Imprimeix el taulell
        System.out.println();
        Funcions.imprimeixValors(Taulell);
        System.out.println();

        System.out.println("Poso un 23 a la [3][3]");
        Taulell.setValueCell(23, 3, 3);
        Taulell.setVisibleCell(3, 3); //Fer cell visible

        //Imprimeix el taulell
        System.out.println();
        Funcions.imprimeixValors(Taulell);
        System.out.println();
        //cela 0 3 haurai de sortir com a no escrita
        if (Taulell.getWrittenCell(0,3))  System.out.println("ESCRITA");
        else  System.out.println("NO ESCRITA");
        System.out.println("Poso un 3 a la [0][3]");
        Taulell.setValueCell(3,0,3);
        Taulell.setVisibleCell(0,3); //Fer cell visible


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
