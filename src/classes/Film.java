package classes;
import java.util.Random;

public class Film extends Produkcja {
    private String gatunek;
    private String zwiastun;
    private float cena;
    private float cenaPromocja;
    private String czasTrwania;

    public String getGatunek() {
        return gatunek;
    }

    public float getCena() {
        return cena;
    }

    public float getCenaPromocja() {
        return cenaPromocja;
    }

    public String getCzasTrwania() {
        return czasTrwania;
    }

    private static final String[] czasTrwania1;

    static {
        czasTrwania1 = new String[]{"00:", "01:", "02:"};
    }

    private static final String[] gatunekList;

    static {
        gatunekList = new String[]{"Sensacyjny", "Dramat", "Komedia", "Dokument", "Dla dzieci"};
    }



    public Film() {
        Random r = new Random();
        int tmp = r.nextInt(gatunekList.length);
        gatunek = gatunekList[tmp];
        zwiastun = "https://www.youtube.com/watch?v=9k85aMNxVzk";
        int min = 1;
        int max = 30;
        cena = r.nextFloat() * (max - min) + min;
        //promocja od 5% do 50%
        int promocja = r.nextInt(45) + 5;
        cenaPromocja = (100 - promocja) * 0.01f * cena;
        Random random = new Random();
        tmp = random.nextInt(czasTrwania1.length);
        String temp = czasTrwania1[tmp];
        czasTrwania = temp;

        tmp = random.nextInt(60);
        temp = Integer.toString(tmp);
        if (tmp < 10) {
            czasTrwania += ("0" + temp + ":");
        } else
            czasTrwania += (temp + ":");

        tmp = random.nextInt(60);
        temp = Integer.toString(tmp);
        if (tmp < 10) {
            czasTrwania += ("0" + temp);
        } else {
            czasTrwania += (temp);
        }
    }


}
