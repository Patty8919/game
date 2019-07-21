package com.kodilla;

import java.util.*;

public class Suit {
    private String name;
    private String symbol;

    public final static Suit TREFL = new Suit("Trefl", "Trefl");
    public final static Suit KARO = new Suit ("Karo", "Karo");
    public final static Suit KIER = new Suit ("Kier", "Kier");
    public final static Suit PIK = new Suit ("Pik", "Pik");

    public final static java.util.List VALUES =
            Collections.unmodifiableList(
                    Arrays.asList(new Suit[] {TREFL, KARO, KIER, PIK}));

    private Suit(String nameValue, String symbolValue) {
        name = nameValue;
        symbol = symbolValue;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return name;
    }


}
