import java.util.ArrayList;

/**
 * Created by SadafiYadegari on 2016-11-19.
 */
public class Container extends Material {

    private int volume;
    private ArrayList<Container> containers;


    public Container(int volume, int matID, String matName, float matStock, int matPrice, String matUnit) {
        super(matID, matName, matStock, matPrice, matUnit);
        this.volume = volume;
    }

    public int getVolume(){
        return this.volume;
    }

    public void setVolume(int v){
        this.volume = v;
    }

    public ArrayList<Container> getContainers(){
        return this.containers;
    }

    private void addContainer(Container c) {
        this.containers.add(c);
        super.addMaterial(c);
    }

    private void removeContainer(Container c) {
        containers.remove(c);
        super.removeMaterial(c);
    }

}
