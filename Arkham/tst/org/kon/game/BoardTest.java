package org.kon.game;

import org.junit.Test;
import org.kon.game.graphics.mock.GameGraphics;
import org.kon.game.interfaces.IGameGraphics;

/**
 * Created with IntelliJ IDEA.
 * User: Kongus
 * Date: 27/12/12
 * Time: 18:35
 * To change this template use File | Settings | File Templates.
 */
public class BoardTest {
    @Test
    public void boardCanBeSetupForUser() throws Exception {
        IGameGraphics graph = mock(IGameGraphics.class);
        Board b = new Board( );
        b.setup();
    }
}
