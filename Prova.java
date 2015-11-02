package domini;
import java.util.*;

/**
 * Created by Jordi Guiu on 02/11/2015.
 * Classe per fer proves de Run a veure si funcionen les classes que hem fet com volem.
 */

public class Prova {
    public static void main(String[] args) {

        Board Taulell = new BoardHidato(System.in);

        System.out.println("mida taulell:" + Taulell.getSize()); //treu mida taulell

        Taulell.setValueCell(1, 1, 1); //Posa valor 1 a la Cel·la [1][1]

        Funcions.imprimeix(Taulell); //imprimeix el taulell

        Taulell.setValueCell(23, 2, 3);

        System.out.println("Posició[2][3]? (Hauria de veure 23):" + Taulell.getValueCell(2, 3));

        System.out.println("Posició[0][0]? (Hauria de veure -1):" + Taulell.getValueCell(0, 0));

        System.out.println("Nombre màxim de marques? (9):" + Taulell.consult_max_annotations());



        int i = 42;
        System.out.println("i:" + i);
    }



}
