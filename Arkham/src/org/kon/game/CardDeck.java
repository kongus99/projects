package org.kon.game;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ldudek
 * Date: 1/3/13
 * Time: 9:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class CardDeck {
    private final List<Card> deck;

    public CardDeck(List<Card> initialCards) {
        deck = new LinkedList<Card>(initialCards);
    }

    public Card draw() {
        if (deck.size() > 0)
            return deck.remove(0);
        return null;
    }
}
