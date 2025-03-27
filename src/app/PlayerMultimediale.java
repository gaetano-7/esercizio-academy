package app;

import model.ElementoMultimediale;
import model.Immagine;
import model.RegistrazioneAudio;
import model.Video;

import java.util.Scanner;

public class PlayerMultimediale {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElementoMultimediale[] elementi = new ElementoMultimediale[5];
        System.out.println("Benvenuto nel Player Multimediale!");

        for (int i = 0; i < 5; i++) {
            int tipo = 0;
            do {
                System.out.println("Inserisci il tipo di elemento multimediale (1=Audio, 2=Video, 3=Immagine):");
                while (!scanner.hasNextInt()) {
                    System.out.println("Input non valido! Inserisci un numero tra 1 e 3.");
                    scanner.next();
                }
                tipo = scanner.nextInt();
                if (tipo < 1 || tipo > 3) {
                    System.out.println("Errore: numero non valido! Inserisci un valore tra 1 e 3.");
                }
            } while (tipo < 1 || tipo > 3);

            scanner.nextLine();
            System.out.println("Inserisci il titolo:");
            String titolo = scanner.nextLine();

            switch (tipo) {
                case 1:
                    System.out.println("Inserisci la durata:");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Durata non valida! Inserisci un numero intero.");
                        scanner.next();
                    }
                    int durataAudio = scanner.nextInt();
                    elementi[i] = new RegistrazioneAudio(titolo, durataAudio);
                    break;
                case 2:
                    System.out.println("Inserisci la durata:");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Durata non valida! Inserisci un numero intero.");
                        scanner.next();
                    }
                    int durataVideo = scanner.nextInt();
                    elementi[i] = new Video(titolo, durataVideo);
                    break;
                case 3:
                    elementi[i] = new Immagine(titolo);
                    break;
            }
        }

        int scelta;
        do {
            System.out.println("\nQuale elemento vuoi eseguire? (1-5, 0 per uscire)");
            for (int i = 0; i < 5; i++) {
                System.out.println((i + 1) + ") " + elementi[i].getTitolo() + " (" + getTipoElemento(elementi[i]) + ")");
            }

            while (!scanner.hasNextInt()) {
                System.out.println("Scelta non valida! Inserisci un numero tra 0 e 5.");
                scanner.next();
            }
            scelta = scanner.nextInt();

            if (scelta >= 1 && scelta <= 5) {
                elementi[scelta - 1].play();
            } else if (scelta != 0) {
                System.out.println("Scelta non valida!");
            }
        } while (scelta != 0);

        scanner.close();
    }

    private static String getTipoElemento(ElementoMultimediale elemento) {
        if (elemento instanceof RegistrazioneAudio) {
            return "Audio";
        } else if (elemento instanceof Video) {
            return "Video";
        } else {
            return "Immagine";
        }
    }
}
