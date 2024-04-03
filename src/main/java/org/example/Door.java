package org.example;

public class Door {
    private Prise prise;

    public Door(Prise prise) {
        this.prise = prise;
    }

    public Prise open() {
        return prise;
    }
}
