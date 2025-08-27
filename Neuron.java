package neuron;

import java.util.ArrayList;
import java.util.List;

public class Neuron {
    private static int idCounter = 1;
    private int id;
    private List<Neuron> inputs;
    private final float weight;
    private final float threshold;
    private float total;
    private boolean cycleTag;

    public Neuron(float weight, float threshold) {
        this.weight = weight;
        this.threshold = threshold;
        id = idCounter++;
        inputs = new ArrayList<>();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Neuron)) return false;
        return super.equals(obj) || id == ((Neuron) obj).id;
    }

    public void addInput(Neuron vertex) {
        if (!inputs.contains(vertex)) {
            inputs.add(vertex);
        }
    }

    public float fire() {
        if (!cycleTag) {
            cycleTag = true;
            for (Neuron input : inputs) {
                total += input.fire();
            }
            if (total < threshold) {
                total = 0;
            }
        }
        return total * weight;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
