package domini;
import java.util.*;


/**
 * Created by Jordi Guiu on 02/11/2015.
 * Classe per ficar-hi algunes funcions, m�s endavant decidirem com ho fem.
 */


public class Funcions {
    public static void imprimeixValors(Board Taulell) {
        for (int i = 0; i < Taulell.getSize(); ++i) {
            System.out.println("mida taulell:" + Taulell.getSize());
            System.out.printf("entra 3 ");
            for (int j = 0; j < Taulell.getSize(); ++j) {
                System.out.printf("entra 4 ");
                System.out.println(Taulell.getValueCell(j, i));
                System.out.println(j);
                System.out.println(i);

            }
        }
    }
}
