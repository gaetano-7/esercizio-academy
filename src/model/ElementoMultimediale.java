package model;

public abstract class ElementoMultimediale {

    protected String titolo; // protected perchè deve essere accessibile dalle classi figlie

    // costruiamo il costruttore di default
    public ElementoMultimediale(String titolo) {
        this.titolo = titolo;
    }

    // getter per il titolo
    public String getTitolo() {
        return titolo;
    }

    public abstract void play(); // metodo astratto che deve essere implementato dalle classi figlie
}
