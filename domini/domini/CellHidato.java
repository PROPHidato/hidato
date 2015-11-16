package domini;


/**
 * Created with IntelliJ IDEA.
 * Date: 29/10/15
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */


public class CellHidato extends Cell {
    private boolean start; //marca si la casella es la primera
    private boolean finish; //marca si la casella es la ultima
    private boolean valida; //per si la casella es valida

    public CellHidato(int row, int column) {
        super(column, row);
        value = 0;  // 0 = cela buida
        valida = true;
        start = false;
        finish = false;

        annotations = new boolean[BoardHidato.consult_max_annotations()];
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

    public boolean getStart() {return start;}

    public void switchStart() {this.start ^= true;}

    public boolean getFinish() {return finish;}

    public void switchFinish() {this.finish ^= true;}

    public boolean getValida(){
        return valida;
    }

    public void switchValida(){  //Aclarar perque = visible.
        this.valida ^= true;
    }
}