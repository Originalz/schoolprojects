package bbs.mz;

import java.util.ArrayList;

public class Graph {

    private ArrayList<Knoten> knoten;
    private ArrayList<Kante> kanten;

    public Graph() {
        this.setKanten(new ArrayList<>());
        this.setKnoten(new ArrayList<>());
    }

    public void erstelleStreckennetz()
    {
        this.addStrecke("Lingen", "Leer", 7);
        this.addStrecke("Lingen", "Rheine", 2);
        this.addStrecke("Rheine", "Osnabrueck", 3);
        this.addStrecke("Lingen", "Osnabrueck", 4);
        this.addStrecke("Osnabrueck", "Oldenburg", 43);
        this.addStrecke("Oldenburg", "Wilhelmshaven", 10);
        this.addStrecke("Wilhelmshaven", "Leer", 25);
        this.addStrecke("Bremen","Oldenburg", 43);
        this.addStrecke("Bremen","Osnabrueck", 20);
        this.addStrecke("Rheine","Muenster", 14);
        this.addStrecke("Osnabrueck","Muenster", 25);
    }

    public boolean knotenInKnoten(String s1) {
        for (Knoten k : this.getKnoten()) {
            if (k.getBezeichnung().equals(s1)) {
                return true;
            }
        }
        return false;
    }

    public boolean kanteInKanten(String s1, String s2) {
        for (Kante k : this.getKanten()) {
            if (k.getK1().getBezeichnung().equals(s1) &&
                    k.getK2().getBezeichnung().equals(s2)) {
                return true;
            }
        }
        return false;
    }

    public void addStrecke2(String s1, String s2)
    {
        if (!knotenInKnoten(s1)) {
            this.getKnoten().add(new Knoten(s1));
        }
        if (!knotenInKnoten(s2)) {
            this.getKnoten().add(new Knoten(s2));
        }

        // Kante zwischen s1 und s2 einfügen, falls noch nicht vorhanden
        // Beachte {s1,s2}={s2,s1}
    }

    public Knoten getKnoten(String bezeichnung) {
        for (Knoten k : knoten
        ) {
            if (k.getBezeichnung().equals(bezeichnung)) {
                return k;
            }
        }
        return null;
    }

    public void addStrecke(String s1, String s2, int distance) {
        // Testet, ob ein Knoten mit der Bezeichnung s1 exisitiert.
        // Falls nicht, wird ein solcher Knoten eingefügt.
        if (!this.getKnoten().stream()
                .anyMatch(t -> t.getBezeichnung().equals(s1))) {
            this.getKnoten().add(new Knoten(s1));
        }

        // Testet, ob ein Knoten mit der Bezeichnung s2 exisitiert.
        // Falls nicht, wird ein solcher Knoten eingefügt.
        if (!this.getKnoten().stream()
                .anyMatch(t -> t.getBezeichnung().equals(s2))) {
            this.getKnoten().add(new Knoten(s2));
        }

        // Testet, ob eine Kante zwischen den beiden Knoten existiert
        // Falls nicht, wird ein solche Kante eingefügt.
        if (!this.getKanten().stream()
                .anyMatch(t -> (t.getK1().getBezeichnung().equals(s1) || t.getK2().getBezeichnung().equals(s1)) &&
                        (t.getK1().getBezeichnung().equals(s2) || t.getK2().getBezeichnung().equals(s2)))) {
            this.getKanten().add(new Kante(
                    this.getKnoten().stream().filter(t -> t.getBezeichnung().equals(s1)).findAny().orElse(null),
                    this.getKnoten().stream().filter(t -> t.getBezeichnung().equals(s2)).findAny().orElse(null),
                    distance
            ));
        }
    }


    public ArrayList<Knoten> getKnoten() {
        return knoten;
    }

    public void setKnoten(ArrayList<Knoten> knoten) {
        this.knoten = knoten;
    }

    public ArrayList<Kante> getKanten() {
        return kanten;
    }

    public void setKanten(ArrayList<Kante> kanten) {
        this.kanten = kanten;
    }

    public String toString() {
        String s = "Graph D { \n";
        for (Kante k : this.getKanten()) {
            s += String.format("\t\"%s\" -- \"%s\" [ label = %d ];\n", k.getK1().getBezeichnung(), k.getK2().getBezeichnung(),
                    k.getDistance());
        }
        s += "}";
        return s;
    }
}