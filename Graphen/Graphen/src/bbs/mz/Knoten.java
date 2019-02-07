package bbs.mz;

public class Knoten {

    private String bezeichnung;

    public Knoten() {
        this("default");
    }

    public Knoten(String bezeichnung) {
        this.setBezeichnung(bezeichnung);
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
}
