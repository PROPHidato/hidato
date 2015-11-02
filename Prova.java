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

        Funcions.imprimeixValors(Taulell); //imprimeix el taulell

        Taulell.setValueCell(23, 2, 3);

        System.out.println("Posició[2][3]? (Hauria de veure 23):" + Taulell.getValueCell(2, 3));

        System.out.println("Posició[0][0]? (Hauria de veure 0):" + Taulell.getValueCell(0, 0));

        System.out.println("Nombre màxim de marques? (9):" + Taulell.consult_max_annotations());

        CellHidato c = new CellHidato(System.in, System.in);

        System.out.println("Valor de la Cel·la? (Hauria de veure 0):" + c.getValue());

        System.out.println("Columna de la cel·la? (Hauria de veure la columna que he posat):" + c.getColumn());

        System.out.println("Fila de la cel·la? (Hauria de veure la fila que he posat):" + c.getRow());

        System.out.println("Marca 2 en la cela? (false):" + c.getAnnotation(2));

        c.switchAnnotation(2);

        System.out.println("Marca 2 en la cela? (true):" + c.getAnnotation(2));

        c.setAnnotation(3, true);

        System.out.println("Marca 3 en la cela? (true):" + c.getAnnotation(3));


    }
}
