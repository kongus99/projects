package org.kon.game;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: ldudek
 * Date: 1/8/13
 * Time: 12:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class InvestigatorTest {
    @Test
    public void investigatorShouldHaveListOfFixedPossessions() throws Exception {
        List<Possession> possessions = new ArrayList<Possession>();
        Possession p1 = new Possession();
        Possession p2 = new Possession();
        Possession p3 = new Possession();
        Possession p4 = new Possession();
        possessions.add(p1);
        possessions.add(p2);
        Investigator investigator = new Investigator(p2,p4);
        possessions.add(p3);
        possessions.add(p4);
        Random seed = new Random();
        Deck<Possession> deck = new Deck<Possession>(possessions,seed);
        investigator.assignFixedPossessions(deck);
        Assert.assertTrue(investigator.has(p2));
        Assert.assertTrue(investigator.has(p4));
    }
}