package org.kon.game;

import org.kon.game.interfaces.IGameDatabase;
import org.kon.game.interfaces.IGameGraphics;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kongus
 * Date: 27/12/12
 * Time: 18:32
 * To change this template use File | Settings | File Templates.
 */
public class Board {
    private final IGameGraphics graphics;
    private final IGameDatabase base;

    public Board(IGameGraphics graphics, IGameDatabase base) {
        this.graphics = graphics;
        this.base = base;
    }

    public void setup() {
        List<BoardField> fields = base.getBoardFields();
        for (BoardField field : fields)
            if (field.type().equals(EFieldType.RED))
                field.addClue(1);
        graphics.drawBoard();
    }
}
