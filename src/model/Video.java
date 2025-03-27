package model;

import model.interfaces.LuminositaRegolabile;
import model.interfaces.Riproducibile;
import model.interfaces.VolumeRegolabile;

public class Video extends ElementoMultimediale implements Riproducibile, VolumeRegolabile, LuminositaRegolabile {

    private int durata;

    private int volume;

    private int luminosita;

    public Video(String titolo, int durata) {
        super(titolo); // chiamiamo il costruttore della classe padre
        this.durata = durata;
        this.volume = 50;
        this.luminosita = 50;
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + " " + "!".repeat(volume) + " " + "*".repeat(luminosita));
        }
    }

    @Override
    public void abbassaVolume() {
        if (volume > 1) { // per evitare che il volume scenda sotto 1
            volume--;
        }
    }

    @Override
    public void alzaVolume() {
        volume++;
    }

    @Override
    public int getVolume() {
        return volume;
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

    @Override
    public int getDurata() {
        return durata;
    }

}
