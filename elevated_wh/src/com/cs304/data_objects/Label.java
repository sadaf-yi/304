import java.util.ArrayList;

/**
 * Created by SadafiYadegari on 2016-11-19.
 */
public class Label extends Material {

    private String labelSize;
    private ArrayList<Label> labels;

    public Label(String labelSize, int matID, String matName, float matStock, int matPrice, String matUnit) {
        super(matID, matName, matStock, matPrice, matUnit);
        this.labelSize = labelSize;
    }

    public String getLabelSize(){
        return this.labelSize;
    }

    private void setLabelSize(String labelSize) {
        this.labelSize = labelSize;
    }

    private void removeLabel(Label l) {
        labels.remove(l);
        super.removeMaterial(l);
    }

    private void addLabel(Label l) {
        labels.add(l);
        super.addMaterial(l);
    }

}
