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
        int entrada2;
        int column, row;
        int val1, val2, val3;
        int marca;
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
            Boolean fi_joc = false;

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
                Character s = 's';
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
                    System.out.println("Introdueix els valors del taullel per ordre.");
                    System.out.println("(Recorda: Com a minim s'han d'introduir el primer i ultim valor del Hidato. 0 = cela buida, -1 = cela invalida.)");
                    Funcions.llegirTaulell(Taulell);
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
                    Match Partida = new Match(dificultat);
                    //fer coses amb partida
                    BoardHidato TaulellAux = new BoardHidato(size);
                    Funcions.copiarBoard(TaulellAux, Taulell);

                    System.out.println("Benvingut a la partida del joc "+ Joc.getGameId() + ":");
                    System.out.printf("Apretant els seguents numeros podras fer les seguents coses:\n");
                    System.out.println("1 : Introduir valor a una cela.");
                    System.out.println("2: Posar una marca a una cela.");
                    System.out.println("3: Consultar marques que tenim a una cela.");
                    System.out.println("4: Verificar si taulell ben resolt (un cop taulell complert).");
                    System.out.println("-1: Sortir de la partida.");
                    System.out.println("(0: ajuda)");
                    entrada2 = input.nextInt();
                    while(fi_joc == false) {
                        if (entrada2 == 0) {
                            System.out.println("1 : Introduir valor a una cela.");
                            System.out.println("2: Posar una marca a una cela.");
                            System.out.println("3: Consultar marques que tenim a una cela.");
                            System.out.println("4: Verificar si taulell ben resolt (un cop taulell complert).");
                            System.out.println("-1: Sortir de la partida.");
                        } else if (entrada2 == 1) {
                            while (s == 's') {
                                System.out.println("Introdueix el valor que vols posar i la fila i columna de la cela on ho vols posar:");
                                val1 = input.nextInt();
                                val2 = input.nextInt();
                                val3 = input.nextInt();
                                if ((val2 | val3) >= size) System.out.println("Has sortit fora del taulell.");
                                else {
                                    Taulell.setValueCell(val1, val2, val3);
                                    Funcions.imprimeixValors(Taulell);
                                }
                                System.out.println("Vols introduir una altra cela? (s/n):");
                                s = input.next().charAt(0);
                            }
                        } else if (entrada2 == 2) {
                            System.out.println("Introdueix fila i columna de cela on vols posar/treure la marca.");
                            val1 = input.nextInt();
                            val2 = input.nextInt();
                            System.out.println("Indica quina marca vols posar/treure a la cela escollida:");
                            marca = input.nextInt();
                            Taulell.switchAnnotationCell(marca, val1, val2);

                        } else if (entrada2 == 3) {
                            System.out.println("Introdueix fila i columna de cela que vols veure les marques.");
                            val1 = input.nextInt();
                            val2 = input.nextInt();
                            System.out.println("Valors: ");
                            for (int i = 0; i < Taulell.consult_max_annotations(); ++i) {
                                System.out.println(Taulell.getAnnotationCell(i, val1, val2) + " ");
                            }

                        } else if (entrada2 == 4) {
                            if(Funcions.verificadorSolucio(Taulell)) {
                                System.out.println("Ben resolt! Felicitats :)");
                                fi_joc = true;
                            }
                            else {
                                System.out.println("Mal resolt :( Tornar-ho a intentar.");
                            }
                        } else if (entrada2 == -1) {
                            //tornar a l'estat anterior.
                            Funcions.copiarBoard(Taulell,TaulellAux);
                            fi_joc = true;
                        }
                        entrada2 = input.nextInt();
                    }

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

