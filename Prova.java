package domini;
import java.util.*;

/**
 * Created by Jordi Guiu on 02/11/2015.
 * Classe per fer proves de Run a veure si funcionen les classes que hem fet com volem.
 */

public class Prova {
    public static void main(String[] args) {

        Scanner input = new Scanner( System.in );

        int size;
        int column;
        int row;
        System.out.printf("Entra mida taulell:  ");

        size = input.nextInt();

        BoardHidato Taulell = new BoardHidato(size);

        System.out.println("mida taulell:" + Taulell.getSize()); //treu mida taulell

        System.out.println("Nombre maxim de marques? (size*size):" + Taulell.consult_max_annotations());

        Taulell.setValueCell(1, 1, 1); //Posa valor 1 a la Cel�la [1][1]
/*
        //Funcions.imprimeixValors(Taulell); //imprimeix el taulell

        System.out.println("Posici�[0][0]? (Hauria de veure 0):" + Taulell.getValueCell(2, 0));

        Taulell.setValueCell(23, 2, 3);

        System.out.println("Posici�[0][0]? (Hauria de veure 0):" + Taulell.getValueCell(2, 0));

        System.out.println("Posici�[2][3]? (Hauria de veure 23):" + Taulell.getValueCell(2, 3));

        System.out.println("Posici�[2][3]? (Hauria de veure 1):" + Taulell.getValueCell(1, 1));

        System.out.println("Posici�[0][0]? (Hauria de veure 0):" + Taulell.getValueCell(0, 0));
/*
        System.out.printf("Entra columna i fila d'una cela:  ");

        column = input.nextInt();
        row = input.nextInt();

        CellHidato c = new CellHidato(column, row);

        System.out.println("Valor de la Cel�la? (Hauria de veure 0):" + c.getValue());

        System.out.println("Columna de la cel�la? (Hauria de veure la columna que he posat):" + c.getColumn());

        System.out.println("Fila de la cel�la? (Hauria de veure la fila que he posat):" + c.getRow());

        System.out.println("Marca 2 en la cela? (false):" + c.getAnnotation(2));

        c.switchAnnotation(2);

        System.out.println("Marca 2 en la cela? (true):" + c.getAnnotation(2));

        c.setAnnotation(3, true);

        System.out.println("Marca 3 en la cela? (true):" + c.getAnnotation(3));
*/

    }
}
