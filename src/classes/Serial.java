package classes;

import java.util.Random;

public class Serial extends Produkcja {
    private String gatunek;
    private int liczbaOdcinkow;
    private int liczbaSezonow;
    private String czasTrwania;

    private static final String[] gatunekList;

    static {
        gatunekList = new String[]{"Sensacyjny", "Dramat", "Komedia", "Dokument", "Dla dzieci"};
    }

    private static final String[] czasTrwania1;

    static {
        czasTrwania1 = new String[]{"00:"};
    }

    public String getGatunek() {
        return gatunek;
    }

    public int getLiczbaOdcinkow() {
        return liczbaOdcinkow;
    }

    public int getLiczbaSezonow() {
        return liczbaSezonow;
    }

    public String getCzasTrwania() {
        return czasTrwania;
    }

    public Serial() {

        Random r = new Random();
        int tmp = r.nextInt(gatunekList.length);
        gatunek = gatunekList[tmp];
        liczbaOdcinkow = r.nextInt(20) + 1;
        liczbaSezonow = r.nextInt(10) + 1;

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
