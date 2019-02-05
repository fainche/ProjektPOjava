package classes;

import javafx.scene.image.Image;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Klient {
    private String login;
    private String email;
    private String nrKarty;
    private String rodzajAbonamentu;
    private Image obraz;
    private String dataUrodzenia;
    private final Random random = new Random();

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getNrKarty() {
        return nrKarty;
    }


    public String getRodzajAbonamentu() {
        return rodzajAbonamentu;
    }


    public Image getObraz() {
        return obraz;
    }


    public String getDataUrodzenia() {
        return dataUrodzenia;
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

    private static final String[] rodzajAbonamentuList;

    static {
        rodzajAbonamentuList = new String[]{"Basic", "Premium", "Family"};
    }

    private static final String[] loginyList;

    static {
        loginyList = new String[]{"marek", "diablo", "user", "anonim", "luke", "lubie-sernik",
                "mirek", "Raptozaur", "kochamKotki", "Giraffe", "Asterix", "Fiona", "Maksik", "PiotrekPL",
                "pikachu", "soldi3r", "songo", "kacperwojownik", "Naruto", "givemegold", "YoloSwaggins",
                "JanuszEU", "StalowyAlchemik", "tsunami", "Destroyer", "DarkWarrior", "DarkVader",
                "Yasiu-Yolo", "Kitty", "skrybaPL"};
    }

    private static final String[] maileList = {"@yahoo.com", "@outlook.com", "@buziaczek.pl", "@put.poznan.pl",
            "@gmail.com", "@onet.pl"};


    public Klient() {

        int tmp;
        int min = 10000000;
        int max = 99999999;
        nrKarty = Long.toString(random.nextInt(max-min)+ min);
        nrKarty += Long.toString(random.nextInt(max-min)+ min);


        tmp = random.nextInt(rodzajAbonamentuList.length);
        rodzajAbonamentu = rodzajAbonamentuList[tmp];

        tmp = random.nextInt(loginyList.length);
        login = loginyList[tmp];
        tmp = random.nextInt(99);
        String temp = Integer.toString(tmp);
        login += temp;
        tmp = random.nextInt(maileList.length);
        email = login + maileList[tmp];

        obraz = new Image(randImage());

        int minDay = (int) LocalDate.of(1960, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2000, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        dataUrodzenia = randomDate.format(formatter);
    }
}
