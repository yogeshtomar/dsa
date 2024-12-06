package binaryTrees;

public class Pair<F, S> {
    private F node;
    private S value;

    public Pair(F node, S value) {
        this.node = node;
        this.value = value;
    }

    public void setNode(F node) {
        this.node = node;
    }

    public void setValue(S value) {
        this.value = value;
    }

    public F getNode() {
        return node;
    }

    public S getValue() {
        return value;
    }
}
