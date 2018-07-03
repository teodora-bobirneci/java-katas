package katas.battleships;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static katas.battleships.BattleShips.getElement;
import static org.junit.Assert.assertEquals;

public class BattleShipsTest {
    @Test
    public void example1() {
        int[][] board = new int[][]{new int[]{0, 0, 1, 0},
                new int[]{0, 0, 1, 0},
                new int[]{0, 0, 1, 0}};
        int[][] attacks = new int[][]{new int[]{3, 1}, new int[]{3, 2}, new int[]{3, 3}};

        Map<String, Double> expected = new HashMap<>();
        expected.put("sunk", 1.0);
        expected.put("damaged", .0);
        expected.put("notTouched", .0);
        expected.put("points", 1.0);

        assertEquals(expected, BattleShips.damagedOrSunk(board, attacks));
    }

    @Test
    public void example2() {
        int[][] board = new int[][]{new int[]{3, 0, 1},
                new int[]{3, 0, 1},
                new int[]{0, 2, 1},
                new int[]{0, 2, 0}};
        int[][] attacks = new int[][]{new int[]{2, 1}, new int[]{2, 2}, new int[]{3, 2}, new int[]{3, 3}};

        Map<String, Double> expected = new HashMap<>();
        expected.put("sunk", 1.0);
        expected.put("damaged", 1.0);
        expected.put("notTouched", 1.0);
        expected.put("points", 0.5);

        assertEquals(expected, BattleShips.damagedOrSunk(board, attacks));
    }

    @Test
    public void matrixIsCorrectlyIterated() {
        int[][] board = new int[][]{new int[]{3, 0, 1},
                new int[]{3, 0, 1},
                new int[]{0, 2, 1},
                new int[]{0, 2, 0}};
        assertEquals(0, getElement(board, 1, 1));
        assertEquals(0, getElement(board, 1, 2));
        assertEquals(3, getElement(board, 1, 3));
        assertEquals(3, getElement(board, 1, 4));
        assertEquals(2, getElement(board, 2, 1));
        assertEquals(2, getElement(board, 2, 2));
        assertEquals(0, getElement(board, 2, 3));
        assertEquals(0, getElement(board, 2, 4));
        assertEquals(0, getElement(board, 3, 1));
        assertEquals(1, getElement(board, 3, 2));
        assertEquals(1, getElement(board, 3, 3));
        assertEquals(1, getElement(board, 3, 4));
    }
}