package drivers;
import domini.*;

import java.util.*;

/**
 * Created by Jordi Guiu on 02/11/2015.
 * Classe per fer proves de Run a veure si funcionen les classes que hem fet com volem.
 */

public class DriverClassesCompartides {
    public static void main(String[] args) {
        Scanner input = new Scanner( System.in );
        int size;
        int entrada;
        int column, row;
        int val1, val2, val3;
        int GameId = 1;
        int dificultat;
        System.out.printf("Entra mida taulell:  ");
        System.out.println();

        size = input.nextInt();
        BoardHidato Taulell = new BoardHidato(size);

        System.out.printf("Benvingut a les proves de les classes Taulell i Cela. \nApretant els seguents numeros podras fer les seguents coses:\n");
        System.out.println("1 : Consultar la mida del taulell creat.");
        System.out.println("2 : Introduir un taulell (0 = cela buida)."); //Comprovar que sigui un Hidato amb resoldre taulell.
        System.out.println("3 : Consultar estat actual del taulell.");
        System.out.println("4 : Consultar el valor d'una certa cela.");
        System.out.println("5 : Canviar el valor d'una certa cela.");
        System.out.println("6 : Resoldre el taulell (Encara s'ha d'implementar).");
        System.out.println("7 : Crear un taulell aleatoriament (Encara s'ha d'implementar).");
        System.out.println("8 : Generar celes invalides aleatoriament.");
        System.out.println("9 : Jugar partida.");
        System.out.println("10 : Introduir jugador.");
        System.out.println("-1 : Per acabar amb les proves.");
        System.out.println("(Si t'oblides dels numeros, posant la paraula el numero 0 et sortira un manual per recordar-t'ho)");
        System.out.println();

        //CONTROLAR ENRTADA DE TEXT  (no chars etc)

        entrada = input.nextInt();
        while(entrada != -1) {
            Character sn = 's';
            if (entrada == 0) {
                System.out.println("1 : Consultar la mida del taulell creat.");
                System.out.println("2 : Introduir un taulell (0 = cela buida).");
                System.out.println("3 : Consultar estat actual del taulell.");
                System.out.println("4 : Consultar el valor d'una certa cela.");
                System.out.println("5 : Canviar el valor d'una certa cela.");
                System.out.println("6 : Resoldre el taulell (Encara s'ha d'implementar).");
                System.out.println("7 : Crear un taulell aleatoriament (Encara s'ha d'implementar).");
                System.out.println("8 : generar celes invalides aleatoriament.");
                System.out.println("-1 : Per acabar amb les proves.");
                System.out.println();
            } else if(entrada == 1) {
                System.out.println("Mida del taulell: " + Taulell.getSize());
            } else if(entrada == 2) {
                System.out.println("Introdueix els valors del taullel per ordre (Recorda 0 = cela buida)");
                Funcions.llegirTaulell(Taulell, size);
                System.out.println("Taulell actualitzat.");
            } else if(entrada == 3) {
                System.out.println("Taulell actual:");
                Funcions.imprimeixValors(Taulell);
            } else if(entrada == 4) {
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
            } else if(entrada == 6) {
                System.out.println("Resolent el taulell . . .");

                //funcio que resolgui el taulell
                //System.out.println("Resolt:");
                Funcions.solve(Taulell, size);
                //Funcions.imprimeixValors(Taulell);
            }
            /*//*else if(entrada == 7) {
                System.out.println("Generant un taulell qualsevol . . .");
                //funcio que generi el taulell
                System.out.println("Generat:");
                Funcions.imprimeixValors(Taulell);
            } */
            else if(entrada == 8) {
                Funcions.colocar_celesinvalides(Taulell);
            }
            else if(entrada == 9) {
                System.out.println("Introdueix la dificultat (1 = fàcil, 2 = mitjà, 3 = difícil)");
                dificultat = input.nextInt();
                Game Joc = new Game(GameId, dificultat);
                ++GameId;
                //guarda la partida (numjoc i usuari)
                //
                //
                //
                //
            }
            else {
                System.out.println("Numero no valid . . .");
            }
            entrada = input.nextInt();
        }
    }
}
