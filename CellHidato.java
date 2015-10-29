package domini.Basic;


public class CellHidato extends Cell{
    
    public Cell(int column, int row) {
        this.column = column;
        this.row = row;
        written = false;
        visible = false;
        value = 0;  // 0 = cela buida
        
        annotations = new boolean[max_annotations];
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
}
