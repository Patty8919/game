package com.kodilla;


import java.util.Arrays;
import java.util.Collections;

public class Rank {
    private String name;
    private String symbol;
    private Integer points;

    public final static Rank AS = new Rank ("as", "as", 11);
    public final static Rank TWO = new Rank( "Two", "Two", 2 );
    public final static Rank THREE = new Rank( "Three", "Three", 3);
    public final static Rank FOUR = new Rank( "Four", "Four", 4);
    public final static Rank FIVE = new Rank( "Five", "Five", 5);
    public final static Rank SIX = new Rank( "Six", "Six", 6);
    public final static Rank SEVEN = new Rank( "Seven", "Seven", 7);
    public final static Rank EIGHT = new Rank( "Eight", "Eight", 8);
    public final static Rank NINE = new Rank( "Nine", "Nine", 9);
    public final static Rank TEN = new Rank( "Ten", "Ten", 10);
    public final static Rank JACK = new Rank( "Jack", "Jack", 10);
    public final static Rank QUEEN = new Rank( "Queen", "Queen", 10);
    public final static Rank KING = new Rank( "King", "King", 10);

    public final static java.util.List Values =
            Collections.unmodifiableList(Arrays.asList(new Rank[]{AS, TWO, THREE, FOUR, FIVE, SIX,
                    SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}));

    private Rank(String nameValue, String symbolValue, int pointsValue) {
        name = nameValue;
        symbol = symbolValue;
        points = pointsValue;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
    public Integer getPoints() {
        return points;
    }
}
