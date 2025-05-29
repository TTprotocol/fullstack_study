package exam;

import java.util.ArrayList;
import java.util.List;

public class Band extends BandComponent{
    public String name;
    public List<BandComponent> member = new ArrayList<>();;

    public Band(String name) {
        this.name = name;
    }

    public void add(BandComponent component) {
        member.add(component);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void perform() {

    }

    @Override
    public void printStructure(String prefix) {
        System.out.println(prefix + "|- \uD83C\uDFA4 " + this.name);
        for (BandComponent band : member) {
            band.printStructure(prefix + " " + this);
        }
    }
}
