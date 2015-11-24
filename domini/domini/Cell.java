package domini;

import java.io.Serializable;

/**
 * Created by the Hidato team.
 */

public class Cell implements Serializable {
    protected int value;

    public Cell() {
        value = -1;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void clearValue() {
        this.value = -1;
    }

    public boolean isEmpty() {
        return value == -1;
    }
}
