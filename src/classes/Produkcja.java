package classes;

import javafx.scene.image.Image;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class Produkcja {
    private String nazwa;
    private String opis;
    private String dystrybutor;
    private String krajProdukcji;
    private String dataProdukcji;
    private float ocena;
    private Image obraz;
    private final ArrayList<String> listaAktorow = new ArrayList<>();
    private final Random random = new Random();
    public static final AktorzyPula aktorzy = new AktorzyPula();

    public String getNazwa() {
        return nazwa;
    }

    public ArrayList<String> getListaAktorow() {
        return listaAktorow;
    }

    public String getOpis() {
        return opis;
    }

    public String getDystrybutor() {
        return dystrybutor;
    }

    public String getKrajProdukcji() {
        return krajProdukcji;
    }

    public String getDataProdukcji() {
        return dataProdukcji;
    }

    public float getOcena() {
        return ocena;
    }

    public Image getObraz() {
        return obraz;
    }

    private static final String[] nazwaList;

    static {
        nazwaList = new String[]{"Shy", "Hot", "Big", "Small", "Fat", "Helpful", "Harmful",
                "Dirty", "Happy", "Famous", "Impossible", "Friendly", "Simple", "Wide",
                "Clean", "Fast", "Important", "Boring", "Pretty", "Silly", "Unforgettable",
                "Sleepy", "Funny", "Weird", "Incredible", "Lonely", "Alone", "Hard", "Scary", "Terrify"};
    }

    private static final String[] nazwa2List;

    static {
        nazwa2List = new String[]{"Night", "Day", "Home", "Mother", "Child", "Story", "Student",
                "Love", "Plane", "Giraffe", "Cat", "Car", "Street", "Bob", "Jimmy", "Hospital",
                "Laptop", "Kitty", "Blondie", "Train", "Network", "Coin", "Wizard", "Dinosaur",
                "Lion", "House", "Place", "Road", "World", "City", "Country", "Dog", "Giraffe", "Garden"};
    }

    private static final String[] krajProdukcjiList;

    static {
        krajProdukcjiList = new String[]{"USA", "England",
                "France", "Poland", "Germany", "Panama", "Japan",
                "South Korea", "Turkey", "Indie", "Iceland", "Indonesia",
                "Brasil", "Russia", "Egypt", "Ukraine", "Iran" };
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

    private static final String[] dystrybutorzy;

    static {
        dystrybutorzy = new String[]{"PUTtv", "Disney", "SesjaTV", "ZmeczonyKotekProductions"};
    }

    private String randImage() {
        int tmp = random.nextInt(images.length);
        return images[tmp];
    }

    Produkcja() {

        int tmp = random.nextInt(nazwaList.length);
        String temp = nazwaList[tmp];

        nazwa = temp;
        tmp = random.nextInt(nazwa2List.length);
        temp = nazwa2List[tmp];
        nazwa += " ";
        nazwa += temp;

        for (int i = 0; i < Constants.LICZBA_AKTOROW_W_PRODUKCJI; i++) {
            tmp = random.nextInt(aktorzy.size());
            listaAktorow.add(aktorzy.get(tmp).getImieNazwisko());
        }


        tmp = random.nextInt(krajProdukcjiList.length);
        krajProdukcji = krajProdukcjiList[tmp];

        ocena = random.nextFloat() * 9 + 1;

        tmp = random.nextInt(dystrybutorzy.length);
        dystrybutor = dystrybutorzy[tmp];

        opis = "To bardzo ciekawa produkcja. Warto obejrzeć.";

        int minDay = (int) LocalDate.of(1960, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        dataProdukcji = randomDate.format(formatter);

        obraz = new Image(randImage());
    }
}
