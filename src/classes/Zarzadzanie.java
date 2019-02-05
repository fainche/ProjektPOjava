package classes;

import java.util.*;

public class Zarzadzanie {
    private final ArrayList<Serial> SerialePula = new ArrayList<>();
    private final ArrayList<Stream> StreamyPula = new ArrayList<>();
    private final ArrayList<Film> FilmyPula = new ArrayList<>();
    private final ArrayList<Klient> KlienciPula = new ArrayList<>();

    public Zarzadzanie() {

        for (int i = 0; i < Constants.LICZBA_FILMOW; i++) {
            FilmyPula.add(new Film());
        }
        for (int i = 0; i < Constants.LICZBA_SERIALI; i++) {
            SerialePula.add(new Serial());
        }
        for (int i = 0; i < Constants.LICZBA_STREAMOW; i++) {
            StreamyPula.add(new Stream());
        }
        for (int i = 0; i < Constants.LICZBA_UZYTKOWNIKOW; i++) {
            KlienciPula.add(new Klient());
        }
    }


    public ArrayList<Serial> getSerialePula() {
        return SerialePula;
    }

    public ArrayList<Stream> getStreamyPula() {
        return StreamyPula;
    }

    public ArrayList<Film> getFilmyPula() {
        return FilmyPula;
    }

    public ArrayList<Klient> getKlienciPula() {
        return KlienciPula;
    }
}