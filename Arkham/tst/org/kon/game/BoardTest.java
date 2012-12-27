package org.kon.game;

import org.junit.Before;
import org.junit.Test;
import org.kon.game.interfaces.IGameDatabase;
import org.kon.game.interfaces.IGameGraphics;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created with IntelliJ IDEA.
 * User: Kongus
 * Date: 27/12/12
 * Time: 18:35
 * To change this template use File | Settings | File Templates.
 */
public class BoardTest {

    private IGameGraphics graph;
    private IGameDatabase base;
    private Board board;
    private List<BoardField> fields;
    private BoardField redField;
    private BoardField greenField;
    private BoardField streetField;

    @Before
    public void setUp() throws Exception {
        graph = mock(IGameGraphics.class);
        base = mock(IGameDatabase.class);
        board = new Board(graph, base);
        fields = new ArrayList<>();
        redField = new BoardField(EFieldType.RED);
        greenField = new BoardField(EFieldType.GREEN);
        streetField = new BoardField(EFieldType.STREET);
        fields.add(greenField);
        fields.add(redField);
        fields.add(streetField);
        doReturn(fields).when(base).getBoardFields();
    }

    @Test
    public void boardCanBeSetupForUser() throws Exception {
        board.setup();
        verify(graph).drawBoard();
        verify(base).getBoardFields();
    }

    @Test
    public void onSetupBoardHasClueTokensAddedOnlyOnRedFields() throws Exception {
        assertEquals(0, redField.cluesNumber());
        assertEquals(0, greenField.cluesNumber());
        assertEquals(0, streetField.cluesNumber());
        board.setup();
        assertEquals(1, redField.cluesNumber());
        assertEquals(0, greenField.cluesNumber());
        assertEquals(0, streetField.cluesNumber());
    }


}
