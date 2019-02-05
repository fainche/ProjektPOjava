package classes;


import javafx.scene.image.Image;

public class Dystrybutor {
    private String rodzajUmowy;
    private String nazwa;
    private Image dystrybutorObraz;
    private String dataWygasniecia;

    public String getRodzajUmowy() {
        return rodzajUmowy;
    }

    public void setRodzajUmowy(String rodzajUmowy) {
        this.rodzajUmowy = rodzajUmowy;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Image getDystrybutorObraz() {
        return dystrybutorObraz;
    }

    public void setDystrybutorObraz(Image dystrybutorObraz) {
        this.dystrybutorObraz = dystrybutorObraz;
    }

    public String getDataWygasniecia() {
        return dataWygasniecia;
    }

    public void setDataWygasniecia(String dataWygasniecia) {
        this.dataWygasniecia = dataWygasniecia;
    }
}