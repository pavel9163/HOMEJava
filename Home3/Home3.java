import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Box {
    private double weight;

    public Box(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}

class Container implements Comparable<Container>, Iterable<Box> {
    private List<Box> boxes;

    public Container() {
        this.boxes = new ArrayList<>();
    }

    public void addBox(Box box) {
        boxes.add(box);
    }

    public double getTotalWeight() {
        double totalWeight = 0.0;
        for (Box box : boxes) {
            totalWeight += box.getWeight();
        }
        return totalWeight;
    }

    @Override
    public int compareTo(Container other) {
        double thisWeight = getTotalWeight();
        double otherWeight = other.getTotalWeight();
        return Double.compare(thisWeight, otherWeight);
    }

    @Override
    public Iterator<Box> iterator() {
        return boxes.iterator();
    }
}

class ContainerWeightComparator implements Comparator<Container> {
    @Override
    public int compare(Container c1, Container c2) {
        double weight1 = c1.getTotalWeight();
        double weight2 = c2.getTotalWeight();
        return Double.compare(weight1, weight2);
    }
}

class ContainerCountComparator implements Comparator<Container> {
    @Override
    public int compare(Container c1, Container c2) {
        int count1 = c1.boxes.size();
        int count2 = c2.boxes.size();
        return Integer.compare(count1, count2);
    }
}

public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addBox(new Box(2.5));
        container.addBox(new Box(1.8));
        container.addBox(new Box(3.2));

        System.out.println("Total weight of container: " + container.getTotalWeight());

        ContainerWeightComparator weightComparator = new ContainerWeightComparator();
        ContainerCountComparator countComparator = new ContainerCountComparator();

        Container anotherContainer = new Container();
        anotherContainer.addBox(new Box(1.0));
        anotherContainer.addBox(new Box(2.0));

        int weightComparison = weightComparator.compare(container, anotherContainer);
        if (weightComparison < 0) {
            System.out.println("container has less weight than anotherContainer");
        } else if (weightComparison > 0) {
            System.out.println("anotherContainer has less weight than container");
        } else {
            System.out.println("container and anotherContainer have the same weight");
        }

        int countComparison = countComparator.compare(container, anotherContainer);
        if (countComparison < 0) {
            System.out.println("container has fewer boxes than anotherContainer");
        } else if (countComparison > 0) {
            System.out.println("anotherContainer has fewer boxes than container");
        } else {
            System.out.println("container and anotherContainer have the same number of boxes");
        }

        System.out.println("Iterating over the boxes in container:");
        for (Box box : container) {
            System.out.println("Box weight: " + box.getWeight());
        }
    }
}
