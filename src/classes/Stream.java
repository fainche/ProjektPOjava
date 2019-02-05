package classes;

import java.util.Random;



public class Stream extends Produkcja {
    private float cena;
    private float cenaPromocja;
    private String czasTrwania;

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
        czasTrwania1 = new String[]{"00:", "01:"};
    }

    public Stream() {
        Random r = new Random();
        int min = 1;
        int max = 30;
        cena = r.nextFloat() * (max - min) + min;
        //promocja od 5% do 50%
        int promocja = r.nextInt(45) + 5;
        cenaPromocja = (100 - promocja) * 0.01f * cena;

        Random random = new Random();
        int tmp = random.nextInt(czasTrwania1.length);
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
