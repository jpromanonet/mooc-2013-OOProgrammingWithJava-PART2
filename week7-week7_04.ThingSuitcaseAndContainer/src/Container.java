import java.util.ArrayList;

public class Container {
    private ArrayList<Suitcase> container;
    private int weightLimit;

    public Container(int weightLimit) {
        this.container = new ArrayList<Suitcase>();
        this.weightLimit = weightLimit;
    }

    public void addSuitcase(Suitcase suitcase) {
        if (totalWeight() + suitcase.totalWeight() <= this.weightLimit) {
            container.add(suitcase);
        }
    }

    public int totalWeight() {
        int totalWeight = 0;
        for (Suitcase suitcase : container) {
            totalWeight += suitcase.totalWeight();
        }

        return totalWeight;
    }

    public void printThings() {
        for (Suitcase suitcase : container) {
            suitcase.printThings();
        }
    }

    @Override
    public String toString() {
        return this.container.size() + " suitcases (" + totalWeight() + " kg)";
    }


}