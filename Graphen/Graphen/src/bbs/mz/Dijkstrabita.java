package bbs.mz;

import java.util.ArrayList;
import java.util.HashMap;

public class Dijkstrabita {

    private Graph g;
    private Knoten start;
    private Knoten ende;
    private HashMap<Knoten, Integer> abstand;
    private HashMap<Knoten, Knoten> vorgaenger;
    private ArrayList<Knoten> q;

    public Dijkstrabita(Graph g, Knoten start, Knoten ende) {
        this.g = g;
        this.start = start;
        this.ende = ende;
        abstand = new HashMap<>();
        vorgaenger = new HashMap<>();

        initialisiere();

        while (!q.isEmpty()) {
            Knoten u = this.qMitKleinstemWertInAbstand();
            q.remove(u);

            for (Knoten v : jederNachbar(u)) {
                if (q.contains(v)) {
                    distanz_update(u,v);
                }

            }
        }
        ArrayList<Knoten> weg = erstelleKürzestenPfad();
        for (Knoten k : weg) {
            System.out.println(k.getBezeichnung());

        }
    }

    private ArrayList<Knoten> erstelleKürzestenPfad() {
        ArrayList<Knoten> weg = new ArrayList<>();
        weg.add(ende);
        Knoten u = ende;
        while (vorgaenger.get(u) != null) {
            u = vorgaenger.get(u);
            weg.add(0,u);
        }
        return weg;
    }

    private void distanz_update(Knoten u, Knoten v) {
        Integer alternativ = abstand.get(u) + 1;
        if (alternativ<abstand.get(v)) {
            abstand.put(v,alternativ);
            vorgaenger.put(v,u);
        }
    }


    private Knoten qMitKleinstemWertInAbstand() {
        Integer tmpAbstand = Integer.MAX_VALUE;
        Knoten tmpK=null;
        for (Knoten k : q) {
            if (abstand.get(k)<tmpAbstand) {
                tmpK = k;
                tmpAbstand = abstand.get(k);
            }
        }
        return tmpK;
    }

    private ArrayList<Knoten> jederNachbar(Knoten k) {
        ArrayList<Knoten> nachbarn = new ArrayList<>();
        for (Kante kante : g.getKanten()) {
            if (kante.getK1() == k) {
                nachbarn.add(kante.getK2());
            }
            if (kante.getK2() == k) {
                nachbarn.add(kante.getK1());
            }
        }
        return nachbarn;
    }

    public void initialisiere() {
        for (Knoten k : g.getKnoten()) {
            abstand.put(k, Integer.MAX_VALUE);
            vorgaenger.put(k, null);
        }
        abstand.put(start,0);
        q = new ArrayList<>(g.getKnoten());
    }
}
