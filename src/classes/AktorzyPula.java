package classes;

import java.util.ArrayList;

public class AktorzyPula extends ArrayList<Aktor> {
    public AktorzyPula() {
        for (int i = 0; i < Constants.LICZBA_AKTOROW_PULA; i++) {
            this.add(new Aktor());
        }
    }
}
