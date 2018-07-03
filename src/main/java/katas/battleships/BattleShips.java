package katas.battleships;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class BattleShips {

    static Map<String, Double> damagedOrSunk(final int[][] board, final int[][] attacks) {
        Map<String, Double> result = initializeResultMap();

        int rows = board.length;
        int cols = board[0].length;

        for (int[] attack : attacks) {
            if (board[attack[0]][attack[1]] != 0){

            }
        }

        return result;
    }

    private static Map<String, Double> initializeResultMap() {
        Map<String, Double> res = new HashMap<>();

        res.put("sunk", 0.0);
        res.put("damaged", 0.0);
        res.put("notTouched", 0.0);
        res.put("points", 0.0);

        return res;
    }

    static int getElement(int[][] board, int i, int j) {
        return board[board.length - j][i - 1];
    }
}