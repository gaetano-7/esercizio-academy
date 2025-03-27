package model;

import model.interfaces.Riproducibile;
import model.interfaces.VolumeRegolabile;

public class RegistrazioneAudio extends ElementoMultimediale implements Riproducibile, VolumeRegolabile {

    private int durata;

    private int volume;

    public RegistrazioneAudio(String titolo, int durata) {
        super(titolo); // chiamiamo il costruttore della classe padre
        this.durata = durata;
        this.volume = 50;
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + " " + "!".repeat(volume));
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
    public int getDurata() {
        return durata;
    }

}
