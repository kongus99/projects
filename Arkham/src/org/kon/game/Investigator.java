package org.kon.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ldudek
 * Date: 1/10/13
 * Time: 9:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class Investigator {
    private List<Possession> fixedPossessions;
    private List<Possession> currentPossessions;

    public Investigator(List<Possession> fixedPossessions) {
        createInventory();
        assignFixedPossessions(fixedPossessions);
    }

    private void createInventory() {
        currentPossessions = new ArrayList();
        fixedPossessions = new ArrayList();
    }

    private void assignFixedPossessions(List<Possession> possessions) {
        for (Possession possession : possessions)
            fixedPossessions.add(possession);
    }

    public void assignFixedPossessions(Deck<Possession> deck) {
        for (Possession fixedPossession : fixedPossessions)
            currentPossessions.add(deck.draw(fixedPossession));
    }

    public boolean has(Possession possession) {
        return currentPossessions.contains(possession);
    }
}
