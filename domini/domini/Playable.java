/**
 * Created by victor on 11/11/2015.
 */

package domini;

// aquesta interface és la que ens permetrà fer servir stats tant amb game com amb board.

public interface Playable {
    int getDifficult(); // això els KK ho podeu deixar en un return 0, no ho fareu servir.
    int getId();        // això si que ho heu d'implementar. per diferenciar entre Boards.
}