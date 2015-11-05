package domini;


/**
 * Created with IntelliJ IDEA.
 * Date: 29/10/15
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */


public class CellHidato extends Cell {
    boolean start; //marca si la casella es la primera
    boolean finish; //marca si la casella es la ultima
    public CellHidato(int row, int column) {
        super(column, row);
        this.column = column;
        this.row = row;
        written = false;
        visible = false;
        value = 0;  // 0 = cela buida
        start = false;
        finish = false;

        annotations = new boolean[Board.max_annotations];
        for (int i = 0; i < annotations.length; i++) annotations[i] = false;
    }

    public boolean getAnnotation(int value) {
        return annotations[value];
    }

    public void switchAnnotation(int value) {
        this.annotations[value] ^= true;
    }

    public void setAnnotation(int value, boolean annotation) {
        this.annotations[value] = annotation;
    }

    public boolean isStart() {return start;}

    public void setStart() {start = true;}

    public boolean isFinish() {return finish;}

    public void steFinish() {finish = true;}

}