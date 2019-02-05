package sample;

import classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    static private Controller runningController;
    @FXML
    private TreeItem<String> galazSeriale;
    @FXML
    private TreeItem<String> galazFilmy;
    @FXML
    private TreeItem<String> galazStreamy;
    @FXML
    private TreeView<String> produkcjeList;
    @FXML
    private TreeView<String> dystrybutorzyLista;
    @FXML
    private ImageView image;
    @FXML
    private ImageView miniaturka;
    @FXML
    private ImageView dystrybutorImage;
    @FXML
    private ImageView zdjecieAktora;
    @FXML
    private Label tytul;
    @FXML
    private Label gatunek;
    @FXML
    private Label czasTrwania;
    @FXML
    private Label krajProdukcji;
    @FXML
    private Label ocena;
    @FXML
    private Label dystrybutor;
    @FXML
    private Label opis;
    @FXML
    private Label dataProdukcji;
    @FXML
    private Label cena;
    @FXML
    private ListView<String> listaAktorow;
    @FXML
    private ListView<String> uzytkownicyList;
    @FXML
    private ListView<String> aktorzyPula;
    @FXML
    private Label liczbaSezonow;
    @FXML
    private Label dataWygasniecia;
    @FXML
    private Label rodzajUmowy;
    @FXML
    private Label liczbaOdcinkow;
    @FXML
    private Label odcinkiEtykieta;
    @FXML
    private Label sezonyEtykieta;
    @FXML
    private Label ocenaEtykieta;
    @FXML
    private Label gatunekEtykieta;
    @FXML
    private Label cenaEtykieta;
    @FXML
    private Label cenaPromocja;
    @FXML
    private Label promocjaEtykieta;
    @FXML
    private Label dataEtykieta;
    @FXML
    private Label premieraEtykieta;
    @FXML
    private Label login;
    @FXML
    private Label nrKarty;
    @FXML
    private Label email;
    @FXML
    private Label abonament;
    @FXML
    private Label dataUrodzenia;
    @FXML
    private Label nazwaDystrybutora;
    @FXML
    private Label imieAktora;
    @FXML
    private Label nazwiskoAktora;
    @FXML
    private Label dataAktora;
    @FXML
    private Label krajAktora;
    @FXML
    private
    Zarzadzanie zarzadzanie;
    @FXML
    private final
    DecimalFormat df = new DecimalFormat("#.##");
    @FXML
    private
    String formatted;
    @FXML
    ObservableList<String> oAktorzyList = FXCollections.observableArrayList();
    @FXML
    ObservableList<String> oUzytkownicyList = FXCollections.observableArrayList();

    @FXML
    public static void setRunningController(Controller runningController) {
        Controller.runningController = runningController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TreeItem<String> korzenDrzewa = new TreeItem<>();
        korzenDrzewa.setExpanded(true); //rozwiniete
        korzenDrzewa.setValue("korzenDrzewa");
        produkcjeList.setShowRoot(false); //nie pokazuj korzenia
        produkcjeList.setRoot(korzenDrzewa);
        galazSeriale = galaz("Seriale", korzenDrzewa);
        galazFilmy = galaz("Filmy", korzenDrzewa);
        galazStreamy = galaz("Streamy", korzenDrzewa);
        zarzadzanie = new Zarzadzanie();
        for (Serial serial : zarzadzanie.getSerialePula()) {
            galaz(serial.getNazwa(), galazSeriale);
        }
        for (Film film : zarzadzanie.getFilmyPula()) {
            galaz(film.getNazwa(), galazFilmy);
        }
        for (Stream stream : zarzadzanie.getStreamyPula()) {
            galaz(stream.getNazwa(), galazStreamy);
        }

        produkcjeList.setEditable(false);
        produkcjeList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        for (Klient klient : zarzadzanie.getKlienciPula()) {
            oUzytkownicyList.add(klient.getLogin());
        }
        uzytkownicyList.setItems(oUzytkownicyList);

        for (Aktor aktor : Produkcja.aktorzy) {
            oAktorzyList.add(aktor.getImieNazwisko());
        }
        aktorzyPula.setItems(oAktorzyList);

        ArrayList<String> dystrybutorzyList = new ArrayList<>();
        ArrayList<String> PUTtvList = new ArrayList<>();
        ArrayList<String> SesjaTVList = new ArrayList<>();
        ArrayList<String> DisneyList = new ArrayList<>();
        ArrayList<String> KotekList = new ArrayList<>();

        dystrybutorzyList.add("PUTtv");
        dystrybutorzyList.add("SesjaTV");
        dystrybutorzyList.add("Disney");
        dystrybutorzyList.add("ZmeczonyKotekProductions");

        for (int i = 0; i < zarzadzanie.getFilmyPula().size(); i++) {
            if (dystrybutorzyList.get(0).equals(zarzadzanie.getFilmyPula().get(i).getDystrybutor())) {
                PUTtvList.add(zarzadzanie.getFilmyPula().get(i).getNazwa());
            } else if (dystrybutorzyList.get(1).equals(zarzadzanie.getFilmyPula().get(i).getDystrybutor())) {
                SesjaTVList.add(zarzadzanie.getFilmyPula().get(i).getNazwa());
            } else if (dystrybutorzyList.get(2).equals(zarzadzanie.getFilmyPula().get(i).getDystrybutor())) {
                DisneyList.add(zarzadzanie.getFilmyPula().get(i).getNazwa());
            } else if (dystrybutorzyList.get(3).equals(zarzadzanie.getFilmyPula().get(i).getDystrybutor())) {
                KotekList.add(zarzadzanie.getFilmyPula().get(i).getNazwa());
            }
        }

        for (int i = 0; i < zarzadzanie.getSerialePula().size(); i++) {
            if (Objects.equals(dystrybutorzyList.get(0), zarzadzanie.getSerialePula().get(i).getDystrybutor())) {
                PUTtvList.add(zarzadzanie.getSerialePula().get(i).getNazwa());
            }
            if (Objects.equals(dystrybutorzyList.get(1), zarzadzanie.getSerialePula().get(i).getDystrybutor())) {
                SesjaTVList.add(zarzadzanie.getSerialePula().get(i).getNazwa());
            }
            if (Objects.equals(dystrybutorzyList.get(2), zarzadzanie.getSerialePula().get(i).getDystrybutor())) {
                DisneyList.add(zarzadzanie.getSerialePula().get(i).getNazwa());
            }
            if (Objects.equals(dystrybutorzyList.get(3), zarzadzanie.getSerialePula().get(i).getDystrybutor())) {
                KotekList.add(zarzadzanie.getSerialePula().get(i).getNazwa());
            }
        }

        for (int i = 0; i < zarzadzanie.getStreamyPula().size(); i++) {
            if (Objects.equals(dystrybutorzyList.get(0), zarzadzanie.getStreamyPula().get(i).getDystrybutor())) {
                PUTtvList.add(zarzadzanie.getStreamyPula().get(i).getNazwa());
            }
            if (Objects.equals(dystrybutorzyList.get(1), zarzadzanie.getStreamyPula().get(i).getDystrybutor())) {
                SesjaTVList.add(zarzadzanie.getStreamyPula().get(i).getNazwa());
            }
            if (Objects.equals(dystrybutorzyList.get(2), zarzadzanie.getStreamyPula().get(i).getDystrybutor())) {
                DisneyList.add(zarzadzanie.getStreamyPula().get(i).getNazwa());
            }
            if (Objects.equals(dystrybutorzyList.get(3), zarzadzanie.getSerialePula().get(i).getDystrybutor())) {
                KotekList.add(zarzadzanie.getStreamyPula().get(i).getNazwa());
            }
        }

        TreeItem<String> korzen = new TreeItem<>();
        korzen.setValue("korzen");
        korzen.setExpanded(true); //nierozwiniete

        dystrybutorzyLista.setShowRoot(false); //nie pokazuj korzenia
        dystrybutorzyLista.setRoot(korzen);

        TreeItem<String> galazPUTtv = galaz("PUTtv", korzen);
        TreeItem<String> galazSesjaTV = galaz("SesjaTV", korzen);
        TreeItem<String> galazDisney = galaz("Disney", korzen);
        TreeItem<String> galazKotek = galaz("ZmęczonyKotekProductions", korzen);

        for (String aPUTtvList : PUTtvList) {
            galaz(aPUTtvList, galazPUTtv);
        }
        for (String aDisneyList : DisneyList) {
            galaz(aDisneyList, galazDisney);
        }
        for (String aSesjaTVList : SesjaTVList) {
            galaz(aSesjaTVList, galazSesjaTV);
        }
        for (String aKotekList : KotekList) {
            galaz(aKotekList, galazKotek);
        }
        galazPUTtv.setExpanded(false);
        galazDisney.setExpanded(false);
        galazSesjaTV.setExpanded(false);
        galazKotek.setExpanded(false);

    }

    @FXML
    private TreeItem<String> galaz(String title, @NotNull TreeItem<String> korzenDrzewa) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        korzenDrzewa.getChildren().add(item);
        return item;
    }

    @FXML
    private void wybranyUzytkownik(MouseEvent mouseEvent) {
        String wybranyUzytkownik = uzytkownicyList.getSelectionModel().getSelectedItems().get(0);
        for (Klient klient : zarzadzanie.getKlienciPula()) {
            if (Objects.equals(wybranyUzytkownik, klient.getLogin())) {
                login.textProperty().set(klient.getLogin());
                email.textProperty().set(klient.getEmail());
                nrKarty.textProperty().set(klient.getNrKarty());
                abonament.textProperty().set(klient.getRodzajAbonamentu());
                miniaturka.setImage(klient.getObraz());
                dataUrodzenia.setText(klient.getDataUrodzenia());
                break;
            }
        }
    }

    @FXML
    private void wybranaProdukcja(MouseEvent mouseEvent) {
        TreeItem<String> wybranaProdukcja = produkcjeList.getSelectionModel().getSelectedItems().get(0);
        if (wybranaProdukcja.getParent().getValue().equals("Seriale")) {
            pokazSerial(wybranaProdukcja);
        }
        if (wybranaProdukcja.getParent().getValue().equals("Filmy")) {
            pokazFilm(wybranaProdukcja);
        }
        if (wybranaProdukcja.getParent().getValue().equals("Streamy")) {
            pokazStream(wybranaProdukcja);
        }
        if (wybranaProdukcja.getParent().getValue().equals("korzenDrzewa")) {
        }
    }

    @FXML
    private void wybranyAktor(MouseEvent mouseEvent) {
        String wybranyaktor = aktorzyPula.getSelectionModel().getSelectedItems().get(0);
        for (Aktor aktor : Produkcja.aktorzy) {
            if (aktor.getImieNazwisko().equals(wybranyaktor)) {
                imieAktora.textProperty().set(aktor.getImie());
                nazwiskoAktora.textProperty().set(aktor.getNazwisko());
                dataAktora.textProperty().set(aktor.getDataUrodzenia());
                zdjecieAktora.setImage(aktor.getZdjecieAktora());
                krajAktora.textProperty().set(aktor.getKraj());
            }
        }
    }

    @FXML
    private void wybranyDystrybutor(MouseEvent mouseEvent) {
        TreeItem<String> stringTreeItem = dystrybutorzyLista.getSelectionModel().getSelectedItems().get(0);
        if (stringTreeItem.getParent().getValue().equals("korzen")) {
            if (stringTreeItem.getValue().equals("SesjaTV")) ;
            {
                Dystrybutor SesjaTV = new Dystrybutor();
                SesjaTV.setNazwa("SesjaTV");
                SesjaTV.setDystrybutorObraz(new Image("file:images/sesja.png"));
                SesjaTV.setRodzajUmowy("Ryczałt miesięczny");
                SesjaTV.setDataWygasniecia("31 grudnia 2019");
                nazwaDystrybutora.textProperty().set(SesjaTV.getNazwa());
                dystrybutorImage.setImage(SesjaTV.getDystrybutorObraz());
                rodzajUmowy.textProperty().set(SesjaTV.getRodzajUmowy());
                dataWygasniecia.textProperty().set(SesjaTV.getDataWygasniecia());
            }
            if (stringTreeItem.getValue().equals("Disney")) {
                Dystrybutor Disney = new Dystrybutor();
                Disney.setNazwa("Disney");
                Disney.setDystrybutorObraz(new Image("file:images/disney.png"));
                Disney.setRodzajUmowy("Ryczałt miesięczny");
                Disney.setDataWygasniecia("21 sierpnia 2021");
                nazwaDystrybutora.textProperty().set(Disney.getNazwa());
                dystrybutorImage.setImage(Disney.getDystrybutorObraz());
                rodzajUmowy.textProperty().set(Disney.getRodzajUmowy());
                dataWygasniecia.textProperty().set(Disney.getDataWygasniecia());
            }
            if (stringTreeItem.getValue().equals("ZmęczonyKotekProductions")) {
                Dystrybutor ZmeczonyKotek = new Dystrybutor();
                ZmeczonyKotek.setNazwa("ZmęczonyKotekProductions");
                ZmeczonyKotek.setDystrybutorObraz(new Image("file:images/zmeczonykotek.png"));
                ZmeczonyKotek.setRodzajUmowy("Płatność za każde oddtworzenie");
                ZmeczonyKotek.setDataWygasniecia("9 stycznia 2020");
                nazwaDystrybutora.textProperty().set(ZmeczonyKotek.getNazwa());
                dystrybutorImage.setImage(ZmeczonyKotek.getDystrybutorObraz());
                rodzajUmowy.textProperty().set(ZmeczonyKotek.getRodzajUmowy());
                dataWygasniecia.textProperty().set(ZmeczonyKotek.getDataWygasniecia());
            }
            if (stringTreeItem.getValue().equals("PUTtv")) {
                Dystrybutor PutTV = new Dystrybutor();
                PutTV.setNazwa("PUTtv");
                PutTV.setDystrybutorObraz(new Image("file:images/put.png"));
                PutTV.setRodzajUmowy("Płatność za każde oddtworzenie");
                PutTV.setDataWygasniecia("3 marca 2023");
                nazwaDystrybutora.textProperty().set(PutTV.getNazwa());
                dystrybutorImage.setImage(PutTV.getDystrybutorObraz());
                rodzajUmowy.textProperty().set(PutTV.getRodzajUmowy());
                dataWygasniecia.textProperty().set(PutTV.getDataWygasniecia());
            }

        }
    }

    private void pokazStream(TreeItem<String> wybranaProdukcja) {
        Stream wybranyStream = new Stream();
        for (int i = 0; i < (zarzadzanie.getStreamyPula().size()); i++) {
            if (zarzadzanie.getStreamyPula().get(i).getNazwa().equals(wybranaProdukcja.getValue())) {
                wybranyStream = zarzadzanie.getStreamyPula().get(i);
                break;
            }
        }
        renderStream(wybranyStream);
    }

    private void renderStream(@NotNull Stream wybranyStream) {
        tytul.textProperty().set(wybranyStream.getNazwa());
        image.setImage(wybranyStream.getObraz());
        czasTrwania.textProperty().set(wybranyStream.getCzasTrwania());
        krajProdukcji.textProperty().set(wybranyStream.getKrajProdukcji());
        dystrybutor.textProperty().set(wybranyStream.getDystrybutor());
        opis.textProperty().set(wybranyStream.getOpis());
        dataProdukcji.textProperty().set(wybranyStream.getDataProdukcji());
        ObservableList<String> oListaAktorow = FXCollections.observableArrayList(wybranyStream.getListaAktorow());
        listaAktorow.setItems(oListaAktorow);
        formatted = df.format(wybranyStream.getCena());
        cena.textProperty().set(formatted + "$");
        formatted = df.format(wybranyStream.getCenaPromocja());
        cenaPromocja.textProperty().set(formatted + "$");
        gatunek.setVisible(false);
        gatunekEtykieta.setVisible(false);
        liczbaOdcinkow.setVisible(false);
        liczbaSezonow.setVisible(false);
        sezonyEtykieta.setVisible(false);
        odcinkiEtykieta.setVisible(false);
        ocena.setVisible(false);
        ocenaEtykieta.setVisible(false);
        cenaEtykieta.setVisible(true);
        cena.setVisible(true);
        cenaPromocja.setVisible(true);
        promocjaEtykieta.setVisible(true);
        dataEtykieta.setVisible(false);
        premieraEtykieta.setVisible(true);
    }

    private void pokazFilm(TreeItem<String> wybranaProdukcja) {
        Film wybranyFilm = new Film();
        for (int i = 0; i < (zarzadzanie.getFilmyPula().size()); i++) {
            if (zarzadzanie.getFilmyPula().get(i).getNazwa().equals(wybranaProdukcja.getValue())) {
                wybranyFilm = zarzadzanie.getFilmyPula().get(i);
                break;
            }
        }
        tytul.textProperty().set(wybranyFilm.getNazwa());
        image.setImage(wybranyFilm.getObraz());
        gatunek.textProperty().set(wybranyFilm.getGatunek());
        czasTrwania.textProperty().set(wybranyFilm.getCzasTrwania());
        krajProdukcji.textProperty().set(wybranyFilm.getKrajProdukcji());
        dystrybutor.textProperty().set(wybranyFilm.getDystrybutor());
        opis.textProperty().set(wybranyFilm.getOpis());
        dataProdukcji.textProperty().set(wybranyFilm.getDataProdukcji());
        ObservableList<String> oListaAktorow = FXCollections.observableArrayList(wybranyFilm.getListaAktorow());
        listaAktorow.setItems(oListaAktorow);
        image.setImage(wybranyFilm.getObraz());
        formatted = df.format(wybranyFilm.getOcena());
        ocena.textProperty().set(formatted);
        formatted = df.format(wybranyFilm.getCena());
        cena.textProperty().set(formatted + "$");
        formatted = df.format(wybranyFilm.getCenaPromocja());
        cenaPromocja.textProperty().set(formatted + "$");
        liczbaOdcinkow.setVisible(false);
        liczbaSezonow.setVisible(false);
        sezonyEtykieta.setVisible(false);
        odcinkiEtykieta.setVisible(false);
        gatunekEtykieta.setVisible(true);
        ocenaEtykieta.setVisible(true);
        ocena.setVisible(true);
        gatunek.setVisible(true);
        cena.setVisible(true);
        cenaEtykieta.setVisible(true);
        cenaPromocja.setVisible(true);
        promocjaEtykieta.setVisible(true);
        dataEtykieta.setVisible(true);
        premieraEtykieta.setVisible(false);
    }

    private void pokazSerial(TreeItem<String> wybranaProdukcja) {
        Serial wybranySerial = new Serial();
        for (int i = 0; i < (zarzadzanie.getSerialePula().size()); i++) {
            if (zarzadzanie.getSerialePula().get(i).getNazwa().equals(wybranaProdukcja.getValue())) {
                wybranySerial = zarzadzanie.getSerialePula().get(i);
                break;
            }
        }
        tytul.textProperty().set(wybranySerial.getNazwa());
        image.setImage(wybranySerial.getObraz());
        gatunek.textProperty().set(wybranySerial.getGatunek());
        czasTrwania.textProperty().set(wybranySerial.getCzasTrwania());
        krajProdukcji.textProperty().set(wybranySerial.getKrajProdukcji());
        dystrybutor.textProperty().set(wybranySerial.getDystrybutor());
        opis.textProperty().set(wybranySerial.getOpis());
        dataProdukcji.textProperty().set(wybranySerial.getDataProdukcji());
        ObservableList<String> oListaAktorow = FXCollections.observableArrayList(wybranySerial.getListaAktorow());
        listaAktorow.setItems(oListaAktorow);
        formatted = df.format(wybranySerial.getOcena());
        ocena.textProperty().set(formatted);
        String liczba = Integer.toString(wybranySerial.getLiczbaOdcinkow());
        liczbaOdcinkow.textProperty().set(liczba);
        image.setImage(wybranySerial.getObraz());
        liczba = Integer.toString(wybranySerial.getLiczbaSezonow());
        liczbaSezonow.textProperty().set(liczba);
        liczbaSezonow.setVisible(true);
        liczbaOdcinkow.setVisible(true);
        gatunekEtykieta.setVisible(true);
        odcinkiEtykieta.setVisible(true);
        sezonyEtykieta.setVisible(true);
        gatunek.setVisible(true);
        ocenaEtykieta.setVisible(true);
        ocena.setVisible(true);
        cena.setVisible(false);
        cenaEtykieta.setVisible(false);
        cenaPromocja.setVisible(false);
        promocjaEtykieta.setVisible(false);
        dataEtykieta.setVisible(true);
        premieraEtykieta.setVisible(false);
    }

    @FXML
    private void dodajSerial() {
        Serial nowySerial = new Serial();
        zarzadzanie.getSerialePula().add(nowySerial);
        galaz(nowySerial.getNazwa(), galazSeriale);
        produkcjeList.refresh();
    }

    @FXML
    private void dodajFilm() {
        Film nowyFilm = new Film();
        zarzadzanie.getFilmyPula().add(nowyFilm);
        galaz(nowyFilm.getNazwa(), galazFilmy);
        produkcjeList.refresh();
    }

    @FXML
    private void dodajStream() {
        Stream nowyStream = new Stream();
        zarzadzanie.getStreamyPula().add(nowyStream);
        galaz(nowyStream.getNazwa(), galazStreamy);
        produkcjeList.refresh();
    }

    @FXML
    private void dodajAktora() {
        Aktor aktor = new Aktor();
        Produkcja.aktorzy.add(aktor);
        oAktorzyList.add(aktor.getImieNazwisko());
        aktorzyPula.setItems(oAktorzyList);
        aktorzyPula.refresh();
    }

    @FXML
    private void usunAktora() {
        String wybranyaktor = aktorzyPula.getSelectionModel().getSelectedItems().get(0);
        oAktorzyList.clear();
        Aktor doSmieciarki = null;
        for (Aktor aktor : Produkcja.aktorzy) {
            if (aktor.getImieNazwisko().equals(wybranyaktor)) {
                doSmieciarki = aktor;
            }
        }
        Produkcja.aktorzy.remove(doSmieciarki);
        for (Aktor actor : Produkcja.aktorzy) {
            oAktorzyList.add(actor.getImieNazwisko());
        }
        aktorzyPula.setItems(oAktorzyList);
        aktorzyPula.refresh();
    }

    @FXML
    private void dodajUzytkownika() {
        Klient klient = new Klient();
        zarzadzanie.getKlienciPula().add(klient);
        oUzytkownicyList.add(klient.getLogin());
        aktorzyPula.setItems(oAktorzyList);
        aktorzyPula.refresh();
    }

    @FXML
    private void usunUzytkownika() {
        String wybranyuzytkownik = uzytkownicyList.getSelectionModel().getSelectedItems().get(0);
        oUzytkownicyList.clear();
        Klient doSmieciarki = null;
        for (Klient klient : zarzadzanie.getKlienciPula()) {
            if (klient.getLogin().equals(wybranyuzytkownik)) {
                doSmieciarki = klient;
            }
        }
        zarzadzanie.getKlienciPula().remove(doSmieciarki);
        for (Klient client : zarzadzanie.getKlienciPula()) {
            oUzytkownicyList.add(client.getLogin());
        }
        uzytkownicyList.setItems(oUzytkownicyList);
        uzytkownicyList.refresh();
    }

    @FXML
    private void usunProdukcje() {
        TreeItem<String> wybranaProdukcja = produkcjeList.getSelectionModel().getSelectedItem();
        if (wybranaProdukcja.getParent().getValue().equals("Seriale")) {
            for (Serial serial : zarzadzanie.getSerialePula()) {
                if (serial.getNazwa().equals(wybranaProdukcja.getValue())) {
                    zarzadzanie.getSerialePula().remove(serial);
                    break;
                }
            }
        }
        if (wybranaProdukcja.getParent().getValue().equals("Filmy")) {
            for (Film film : zarzadzanie.getFilmyPula()) {
                if (film.getNazwa().equals(wybranaProdukcja.getValue())) {
                    zarzadzanie.getFilmyPula().remove(film);
                    break;
                }
            }
        }
        if (wybranaProdukcja.getValue() == "Streamy") {
            for (Stream stream : zarzadzanie.getStreamyPula()) {
                if (stream.getNazwa().equals(wybranaProdukcja.getValue())) {
                    zarzadzanie.getStreamyPula().remove(stream);
                    break;
                }
            }
        }
        produkcjeList.setRoot(null);
        TreeItem<String> korzenDrzewa = new TreeItem<>();
        korzenDrzewa.setExpanded(true); //rozwiniete
        korzenDrzewa.setValue("korzenDrzewa");
        produkcjeList.setShowRoot(false); //nie pokazuj korzenia
        produkcjeList.setRoot(korzenDrzewa);
        galazSeriale = galaz("Seriale", korzenDrzewa);
        galazFilmy = galaz("Filmy", korzenDrzewa);
        galazStreamy = galaz("Streamy", korzenDrzewa);
        for (Serial serial : zarzadzanie.getSerialePula()) {
            galaz(serial.getNazwa(), galazSeriale);
        }
        for (Film film : zarzadzanie.getFilmyPula()) {
            galaz(film.getNazwa(), galazFilmy);
        }
        for (Stream stream : zarzadzanie.getStreamyPula()) {
            galaz(stream.getNazwa(), galazStreamy);
        }

    }
}



