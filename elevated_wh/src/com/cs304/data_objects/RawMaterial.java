import java.util.ArrayList;

/**
 * Created by SadafiYadegari on 2016-11-19.
 */
public  class RawMaterial extends Material{

    private String potency;
    private String active;
    private ArrayList<RawMaterial> rawMaterials;



    public RawMaterial(String potency, String active, int matID, String matName, float matStock, int matPrice, String matUnit) {
        super(matID, matName, matStock, matPrice, matUnit);
        this.active = active;
        this.potency = potency;
    }



    public String getPotency() {
        return this.potency;
    }

    public String getActive() {
        return this.active;
    }

    private void setPotency(String p) {
        this.potency = p;
    }

    private void setActive(String a) {
        this.active = a;
    }

    public ArrayList<RawMaterial> getRawMaterials() {
        return this.rawMaterials;
    }

    private void addRawMaterial(RawMaterial rm) {
        rawMaterials.add(rm);
        super.addMaterial(rm);
    }

    private void removeRawMaterial(RawMaterial rm){
        rawMaterials.remove(rm);
        super.removeMaterial(rm);
    }

}
