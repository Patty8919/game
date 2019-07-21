package com.kodilla;


import javafx.scene.image.Image;

public class Card {
    private Suit suitValue;
    private Rank rankValue;
    private Image cardImage;

    public Card(Suit suitValue, Rank rankValue, Image cardImage) {
        this.suitValue = suitValue;
        this.rankValue = rankValue;
        this.cardImage = cardImage;
    }

    public static String getFilename(Suit suitValue, Rank rankValue) {
        return "file:resources/karty/" + rankValue.getSymbol() + suitValue.getSymbol() + ".png";
    }

    public Suit getSuitValue() {
        return suitValue;
    }

    public Rank getRankValue() {
        return rankValue;
    }

    public int getValue() {
        String rank = rankValue.getSymbol();
        try{
            return Integer.parseInt(rank);
        } catch (Exception ex) {

            if(rank.equals("as")) {
                return 11;
            } else {
                return 10;
            }

        }
    }

    public Image getCardImage() {
        return cardImage;
    }
    @Override
    public String toString() {
        return rankValue.toString() + " of " + suitValue.toString();
    }

    public String rankToString() {
        return rankValue.toString();
    }

    public String suitToString() {
        return suitValue.toString();
    }
}


