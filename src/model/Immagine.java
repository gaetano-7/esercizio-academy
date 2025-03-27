package model;

import model.interfaces.LuminositaRegolabile;

public class Immagine extends ElementoMultimediale implements LuminositaRegolabile {

    private int luminosita;  // private perchè non deve essere accessibile dalle classi esterne

    // costruiamo il costruttore di default
    public Immagine(String titolo) {
        super(titolo); // chiamiamo il costruttore della classe padre
        this.luminosita = 50;
    }

    @Override
    public void aumentaLuminosita() {
        luminosita++;
    }

    @Override
    public void diminuisciLuminosita() {
        if (luminosita > 1) { // per evitare che la luminosità scenda sotto 1
            luminosita--;
        }
    }

    @Override
    public int getLuminosita() {
        return luminosita;
    }

    public void show() {
        System.out.println(titolo + " " + "*".repeat(luminosita));
    }

    @Override
    public void play() {
        show();
    }

}
