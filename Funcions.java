package domini;
import java.util.*;


/**
 * Created by Jordi Guiu on 02/11/2015.
 * Classe per ficar-hi algunes funcions, m�s endavant decidirem com ho fem.
 */


public class Funcions {
    public static void imprimeixValors(Board Taulell) {
        for (int i = 0; i < Taulell.getSize();i++) {
            System.out.println("mida taulell:" + Taulell.getSize());
            System.out.println("entra 3 ");
            for (int j = 0; j < Taulell.getSize();j++) {
                System.out.println("entra 4 ");
                System.out.println("valor: " + Taulell.getValueCell(i,j));
                System.out.println(j);
                System.out.println(i);

            }
        }
    }
}
