package bbs.mz;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class Dijkstra {

    private Graph g;
    private Knoten startknoten;

    public Dijkstra(Graph g) {
        this.setG(g);
    }

    private Knoten kleinsterAbstandInQ(HashMap<Knoten,Integer> abstand){
        Integer minAbstand = Integer.MAX_VALUE;
        Knoten knoten = null;
        for (Map.Entry<Knoten,Integer> k : abstand.entrySet() ) {
            if (k.getValue()<=minAbstand) {
                minAbstand = k.getValue();
                knoten = k.getKey();
            }
        }
        return knoten;
    }

    public ArrayList<Knoten> getRoute(String Startknoten) {
        this.startknoten = g.getKnoten(Startknoten);

        HashMap<Knoten, Knoten> vorgaenger = new HashMap<>();
        HashMap<Knoten,Integer> abstand = new HashMap<>();
        ArrayList<Knoten> q = new ArrayList<>(this.g.getKnoten());
        initialisiere(abstand,vorgaenger,q);
        /*while (!q.isEmpty()) {
            u:= Knoten in Q mit kleinstem Wert in abstand[]
            5          entferne u aus Q                                // für u ist der kürzeste Weg nun bestimmt
            6          für jeden Nachbarn v von u:
            7              falls v in Q:                            // falls noch nicht berechnet
            8                 distanz_update(u,v,abstand[],vorgänger[])
        }*/
        return null;
    }

    public void initialisiere(HashMap<Knoten,Integer> abstand,
                              HashMap<Knoten, Knoten> vorgaenger, ArrayList<Knoten> q) {
        for (Knoten v : this.g.getKnoten()) {
            abstand.put(v,Integer.MAX_VALUE);
            vorgaenger.put(v,null);
        }
        abstand.put(startknoten, 0);
    }


    public Graph getG() {
        return g;
    }

    public void setG(Graph g) {
        this.g = g;
    }
}
