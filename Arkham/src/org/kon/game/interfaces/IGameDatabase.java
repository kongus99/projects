package org.kon.game.interfaces;

import org.kon.game.BoardField;
import org.kon.game.Gates;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kongus
 * Date: 27/12/12
 * Time: 19:04
 * To change this template use File | Settings | File Templates.
 */
public interface IGameDatabase {
    List<BoardField> getBoardFields();

    Gates getGates();
}
