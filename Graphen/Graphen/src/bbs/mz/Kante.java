package bbs.mz;

public class Kante {

    private Knoten k1;
    private Knoten k2;
    private int distance;

    public Kante() {
        this(null, null, 0);
    }

    public Kante(Knoten k1, Knoten k2, int distance) {
        this.setK1(k1);
        this.setK2(k2);
        this.setDistance(distance);
    }

    public Knoten getK1() {
        return k1;
    }

    public void setK1(Knoten k1) {
        this.k1 = k1;
    }

    public Knoten getK2() {
        return k2;
    }

    public void setK2(Knoten k2) {
        this.k2 = k2;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}