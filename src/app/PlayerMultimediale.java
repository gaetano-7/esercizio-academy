package app;

import model.ElementoMultimediale;
import model.Immagine;
import model.RegistrazioneAudio;
import model.Video;
import model.interfaces.LuminositaRegolabile;
import model.interfaces.VolumeRegolabile;

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
                ElementoMultimediale elementoScelto = elementi[scelta - 1];
                elementoScelto.play();
                gestisciRegolazione(scanner, elementoScelto);
            } else if (scelta != 0) {
                System.out.println("Scelta non valida!");
            }
        } while (scelta != 0);

        scanner.close();
    }

    private static void gestisciRegolazione(Scanner scanner, ElementoMultimediale elemento) {
        boolean continua = true;

        while (continua) {
            System.out.println("\nOperazioni disponibili:");

            boolean haVolume = elemento instanceof VolumeRegolabile;
            boolean haLuminosita = elemento instanceof LuminositaRegolabile;

            if (haVolume) {
                System.out.println("1 - Alza volume");
                System.out.println("2 - Abbassa volume");
            }

            if (haLuminosita) {
                System.out.println("3 - Aumenta luminosità");
                System.out.println("4 - Diminuisci luminosità");
            }

            System.out.println("0 - Torna al menu principale");

            System.out.println("Scegli un'opzione:");

            while (!scanner.hasNextInt()) {
                System.out.println("Scelta non valida! Inserisci un numero che corrisponde ad un opzione.");
                scanner.next();
            }
            int opzione = scanner.nextInt();

            switch (opzione) {
                case 0:
                    continua = false;
                    break;
                case 1:
                    if (haVolume) {
                        ((VolumeRegolabile) elemento).alzaVolume();
                        System.out.println("Volume alzato a: " + ((VolumeRegolabile) elemento).getVolume());
                        elemento.play();
                    } else {
                        System.out.println("Questo elemento non supporta l'aumento del volume");
                    }
                    break;
                case 2:
                    if (haVolume) {
                        ((VolumeRegolabile) elemento).abbassaVolume();
                        System.out.println("Volume abbassato a: " + ((VolumeRegolabile) elemento).getVolume());
                        elemento.play();
                    } else {
                        System.out.println("Questo elemento non supporta la diminuzione del volume");
                    }
                    break;
                case 3:
                    if (haLuminosita) {
                        ((LuminositaRegolabile) elemento).aumentaLuminosita();
                        System.out.println("Luminosità aumentata a: " + ((LuminositaRegolabile) elemento).getLuminosita());
                        elemento.play();
                    } else {
                        System.out.println("Questo elemento non supporta l'aumento della luminosità");
                    }
                    break;
                case 4:
                    if (haLuminosita) {
                        ((LuminositaRegolabile) elemento).diminuisciLuminosita();
                        System.out.println("Luminosità diminuita a: " + ((LuminositaRegolabile) elemento).getLuminosita());
                        elemento.play();
                    } else {
                        System.out.println("Questo elemento non supporta la diminuzione della luminosità");
                    }
                    break;
                default:
                    System.out.println("Opzione non valida!");
                    break;
            }
        }
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
