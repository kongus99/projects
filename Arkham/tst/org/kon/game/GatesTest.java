package org.kon.game;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

/**
 * Created with IntelliJ IDEA.
 * User: Kongus
 * Date: 27/12/12
 * Time: 20:18
 * To change this template use File | Settings | File Templates.
 */
public class GatesTest {

    private Random seed;
    private List<Gate> listOfGates;
    private Gates gates;
    private Gate gate1;
    private Gate gate2;
    private Gate gate3;

    @Before
    public void setUp() throws Exception {
        seed = mock(Random.class);
        listOfGates = new ArrayList<>();
        gate1 = new Gate();
        gate2 = new Gate();
        gate3 = new Gate();
        doReturn(2).when(seed).nextInt(3);
        doReturn(1).when(seed).nextInt(2);
        doReturn(0).when(seed).nextInt(1);
        listOfGates.add(gate1);
        listOfGates.add(gate2);
        listOfGates.add(gate3);
        gates = new Gates(seed, listOfGates);
    }

    @Test
    public void shuffleShouldChangeTheGatesSequence() throws Exception {
        gates.shuffle();
        assertEquals(gate3, gates.draw());
        assertEquals(gate2, gates.draw());
        assertEquals(gate1, gates.draw());
    }

    @Test
    public void drawingShouldReturnTheOriginalSequence() throws Exception {
        assertEquals(gate1, gates.draw());
        assertEquals(gate2, gates.draw());
        assertEquals(gate3, gates.draw());
    }

    @Test(expected = Gates.NotEnoughGatesException.class)
    public void drawingTooManyGatesShouldThrowAnException() throws Exception {
        int gateSize = listOfGates.size();
        for (int i = 0; i < gateSize + 1; i++)
            gates.draw();
    }

}
