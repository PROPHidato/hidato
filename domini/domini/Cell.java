package domini;


/**
 * Created with IntelliJ IDEA.
 * Date: 29/10/15
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */


public class Cell {
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
        return value == 1;
    }
}
