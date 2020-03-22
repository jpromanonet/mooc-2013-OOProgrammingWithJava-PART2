package movable;

import java.util.List;
import java.util.ArrayList;

public class Group implements Movable {
    private List<Movable> group;

    public Group() {
        this.group = new ArrayList<Movable>();
    }

    public void addToGroup(Movable movable) {
        if (movable != null) {
            this.group.add(movable);
        }
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable movable : this.group) {
            movable.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        String printGroup = "";
        for (Movable movable : this.group) {
            printGroup += movable + "\n";
        }

        return printGroup;
    }
}