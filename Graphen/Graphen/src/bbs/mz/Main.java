package bbs.mz;

public class Main {

    public static void main(String[] args) {
        Graph g = new Graph();
        g.erstelleStreckennetz();
        System.out.println(g);
        Dijkstrabita db = new Dijkstrabita(g, g.getKnoten("Lingen"),
                g.getKnoten("Wilhelmshaven"));


    }
}
