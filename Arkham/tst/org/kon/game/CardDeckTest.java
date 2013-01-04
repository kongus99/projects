package org.kon.game;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

/**
 * Created with IntelliJ IDEA.
 * User: ldudek
 * Date: 1/3/13
 * Time: 9:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class CardDeckTest {

    private List<Card> initialCards;
    private CardDeck deck;

    @Before
    public void setUp() throws Exception {
        initialCards = new ArrayList<Card>();
        initialCards.add(new Card());
        initialCards.add(new Card());
        initialCards.add(new Card());
        deck = new CardDeck(initialCards);
    }

    @Test
    public void whenCardDeckIsNotShuffledWeDrawCardsInTheSameSequenceTheyWerePutIntoDeck() throws Exception {
        List<Card> cards = new LinkedList<Card>();
        Card c = deck.draw();
        while (c != null) {
            cards.add(c);
            c = deck.draw();
        }
        assertArrayEquals(initialCards.toArray(), cards.toArray());
    }

    @Test
    public void whenCardDeckIsEmptyDrawShouldReturnNull() throws Exception {
        List<Card> initialCards = new ArrayList<Card>();
        CardDeck deck = new CardDeck(initialCards);
        assertNull(deck.draw());
    }

    @Test
    public void whenCardsAreShuffledDeckIsEmptyDrawShouldReturnNull() throws Exception {
        List<Card> initialCards = new ArrayList<Card>();
        CardDeck deck = new CardDeck(initialCards);
        assertNull(deck.draw());
    }
}
