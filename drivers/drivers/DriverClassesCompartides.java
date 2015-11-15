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
        Character sortida = 'n';

        System.out.printf("Entra nom de jugador:  ");
        String nom = input.nextLine();
        Player Jugador = new Player(nom);


        //CONTROLAR ENRTADA DE TEXT A LES OPCIONS (no chars etc)
        while(sortida == 'n') {
            System.out.println("Estàs al Joc " + GameId + ".");
            System.out.printf("Entra mida del taulell:  ");
            size = input.nextInt();
            System.out.println("Introdueix la dificultat (1 = facil, 2 = mitja, 3 = dificil)");
            dificultat = input.nextInt();
            Game Joc = new Game(GameId, dificultat);
            BoardHidato Taulell = new BoardHidato(size);

            System.out.printf("Benvingut a les proves de les classes Taulell i Cela. \nApretant els seguents numeros podras fer les seguents coses:\n");
            System.out.println("1 : Consultar la mida del taulell creat.");
            System.out.println("2: Consultar usuari actual.");
            System.out.println("3: Consultar dificultat del joc actual.");
            System.out.println("4 : Consultar estat actual del taulell.");
            System.out.println("5 : Introduir un taulell (0 = cela buida, -1 = invalida).");
            System.out.println("6 : Crear un taulell aleatoriament (Encara s'ha d'implementar).");
            System.out.println("7 : Resoldre el taulell la màquina (acabar de fer be)."); //valors dins Taulell, true/false
            System.out.println("8 : Fer una partida al joc.");
            System.out.println("-1 : Sortir.");
            System.out.println("(Si t'oblides dels numeros, posant la paraula el numero 0 et sortira un manual per recordar-t'ho)");
            System.out.println();

            entrada = input.nextInt();
            while(entrada != -1) {
                Character sn = 's';
                if (entrada == 0) {
                    System.out.println("1 : Consultar la mida del taulell creat.");
                    System.out.println("2: Consultar usuari actual.");
                    System.out.println("3: Consultar dificultat del joc actual.");
                    System.out.println("4 : Consultar estat actual del taulell.");
                    System.out.println("5 : Introduir un taulell (0 = cela buida, -1 = invalida).");
                    System.out.println("6 : Crear un taulell aleatoriament (Encara s'ha d'implementar).");
                    System.out.println("7 : Resoldre el taulell la màquina (acabar de fer be).");
                    System.out.println("8 : Fer una partida al joc.");
                    System.out.println("-1 : Sortir.");
                    System.out.println();

                } else if(entrada == 1) {
                    System.out.println("Mida del taulell: " + Taulell.getSize());
                } else if (entrada == 2) {
                    System.out.println("L'usuari actual és: " + Jugador.getName());
                } else if (entrada == 3) {
                    System.out.print("La dificultat és: ");
                    if (Joc.getDifficult() == 1) System.out.println("facil.");
                    else if (Joc.getDifficult() == 2) System.out.println("mitja.");
                    else if (Joc.getDifficult() == 3) System.out.println("dificil. ");
                } else if(entrada == 4) {
                    System.out.println("Taulell actual:");
                    Funcions.imprimeixValors(Taulell);
                } else if(entrada == 5) {
                    System.out.println("Introdueix els valors del taullel per ordre (Recorda 0 = cela buida)");
                    Funcions.llegirTaulell(Taulell);
                    System.out.println("Taulell actualitzat.");
                }else if(entrada == 6) {
                    System.out.println("Generant un taulell qualsevol . . .");
                    //funcio que generi el taulell
                    Funcions.colocar_celesinvalides(Taulell);
                    System.out.println("numero celes invalides: " + Taulell.consultar_num_celesinvalides());
                    System.out.println("numero final: " + size*size+(-Taulell.consultar_num_celesinvalides()));
                    //Funcions.generar_written(Taulell);
                    System.out.println("Generat:");
                    Funcions.imprimeixValors(Taulell);
                } else if(entrada == 7) {
                    System.out.println("Resolent el taulell . . .");
                    System.out.println("Resolt:");
                    Funcions.solve(Taulell, size);
                }
                else if(entrada == 8) {

                } else {
                    System.out.println("Numero no valid.");
                }
                entrada = input.nextInt();
            }
            ++GameId;
            System.out.println("Segur que no vols jugar un altre joc? (s/n)");
            sortida = input.next().charAt(0);
            while (sortida != 's' && sortida != 'n')        {
                System.out.println("Valor introduit erroni: s = si, n = no.");
                System.out.println("Segur que no vols jugar un altre joc? (s/n)");
                sortida = input.next().charAt(0);
            }
            if (sortida == 'n') {
                Funcions.netejaBoard(Taulell);
            }
        }
        System.out.println("Fi de les proves.");
    }
}

