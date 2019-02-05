package classes;

import javafx.scene.image.Image;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Aktor {
    private String imie;
    private String nazwisko;
    private String kraj;
    private String dataUrodzenia;
    private String imieNazwisko;
    private Image zdjecieAktora;
    private final Random random = new Random();

    private static final String[] imiona;

    static {
        imiona = new String[]{"Oliver", "Abigail", "Jacob", "Noah", "Benjamin", "Mia",
                "Olivia", "Sophie", "Scarlett", "Camila", "Riley", "Penelope", "Chloe",
                "Layla", "John", "Ian", "Ben", "Lily", "Robin", "Elizabeth", "Marie",
                "George", "Jack", "Liam"};
    }

    private static final String[] nazwiska;

    static {
        nazwiska = new String[]{"von iksnizezrb", "Warunek", "Smith", "Hall", "Brown", "Green",
                "White", "Walker", "Evans", "Wright", "Wilson", "Cooper", "Tyler", "Eastwood",
                "Kowalski", "Wick", "Holmes", "Doe", "Choi"};
    }

    private static final String[] kraje;

    static {
        kraje = new String[]{"USA", "England", "France", "Poland", "Germany", "Panama", "Japan",
                "South Korea", "Turkey", "Indie", "Iceland"};
    }

    private String randImage() {
        int tmp = random.nextInt(images.length);
        return images[tmp];
    }

    private static final String[] images;

    static {
        images = new String[]{"file:images/giraffe.png", "file:images/giraffe1.png",
                "file:images/giraffe2.png", "file:images/giraffe3.png",
                "file:images/kotek.png", "file:images/kotek1.png",
                "file:images/unicorn.png", "file:images/unicorn1.png",
                "file:images/1.png", "file:images/2.png", "file:images/3.png", "file:images/4.png",
                "file:images/5.png", "file:images/6.png", "file:images/7.png", "file:images/8.png",
                "file:images/9.png", "file:images/10.png", "file:images/11.png", "file:images/12.png",
                "file:images/13.png", "file:images/13-1.png", "file:images/14.png",
                "file:images/15.png", "file:images/16.png", "file:images/17.png", "file:images/18.png",
                "file:images/19.png", "file:images/20.png", "file:images/21.png", "file:images/22.png",
                "file:images/23.png", "file:images/24.png", "file:images/25.png", "file:images/26.png",
                "file:images/27.png", "file:images/28.png", "file:images/29.png", "file:images/30.png",
                "file:images/31.png", "file:images/32.png"};
    }

    public Image getZdjecieAktora() {
        return zdjecieAktora;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getKraj() {
        return kraj;
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public String getImieNazwisko() {
        return imieNazwisko;
    }

    public Aktor() {
        Random random = new Random();
        int tmp;
        int minDay = (int) LocalDate.of(1960, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2000, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        dataUrodzenia = randomDate.format(formatter);

        tmp = random.nextInt(kraje.length);
        kraj = kraje[tmp];

        tmp = random.nextInt(imiona.length);
        imie = imiona[tmp];

        tmp = random.nextInt(nazwiska.length);
        nazwisko = nazwiska[tmp];

        imieNazwisko = imie + " " + nazwisko;

        zdjecieAktora = new Image(randImage());
    }
}
