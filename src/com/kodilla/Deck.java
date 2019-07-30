package com.kodilla;

import javafx.scene.image.Image;

import java.util.*;

public class Deck {
    private java.util.List deck;
    private int index;

    public Deck(){ this(1); }
    public Deck(int numDecks) {
        deck = new ArrayList();
        index = 0;

        try{
            for(int i = 0; i<numDecks; i++) {
                Iterator suitItertor = Suit.VALUES.iterator();
                while (suitItertor.hasNext()) {
                    Suit suit = (Suit) suitItertor.next();
                    Iterator rankIterator = Rank.Values.iterator();
                    while (rankIterator.hasNext()) {
                        Rank rank = (Rank) rankIterator.next();

                        Card card = new Card(suit, rank, new Image(Card.getFilename(suit, rank)));
                        addCard(card);
                    }
                    }
                }
            shuffle();
            } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        }



    public void addCard(Card card) {
        deck.add(card);
    }

    public Card dealCard() {
        if (index >= deck.size())
            return null;
        else
            return (Card) deck.get(index++);
    }

    public void restoreDeck() {
        index = 0;

    }

    public void shuffle() {
        Collections.shuffle(deck);

    }

    public int getNumberOfCardsRemaining() {
        return deck.size() - index;
    }

    public boolean isEmpty() {
        if (index >= deck.size())
            return true;
        else
            return false;
    }

    public int getSizeOfDeck() {
        return deck.size();
    }
}
