package org.kon.game;

import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Kongus
 * Date: 27/12/12
 * Time: 20:09
 * To change this template use File | Settings | File Templates.
 */
public class Gates {

    private final Random randomSeed;
    private final List<Gate> gates;

    public Gates(Random seed, List<Gate> listOfGates) {
        randomSeed = seed;
        gates = listOfGates;
    }

    public void shuffle() {
        for (int numberOfGates = gates.size(); numberOfGates > 0; numberOfGates--)
            moveSingleGate(numberOfGates);
    }

    private void moveSingleGate(int numberOfGates) {
        int index = randomSeed.nextInt(numberOfGates);
        gates.add(gates.remove(index));
    }

    public Gate draw() {
        if (gates.size() > 0)
            return gates.remove(0);
        throw new NotEnoughGatesException();
    }

    public class NotEnoughGatesException extends RuntimeException {
    }
}
