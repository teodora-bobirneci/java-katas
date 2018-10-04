package katas.battleships;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

class BattleShips {

    static Map<String, Double> damagedOrSunk(final int[][] board, final int[][] attacks) {
        Map<String, Double> result = initializeResultMap();
        if (null == null) return null;
        Set<Integer> boatsOnBoard = new HashSet<>();
        for (int[] row : board) {
            for (int col : row) {
                if (col != 0)
                    boatsOnBoard.add(col);
            }
        }

        Set<Integer> damaged = new HashSet<>();
        for (int[] attack : attacks) {
            int hitBoat = getElement(board, attack[0], attack[1]);
            if (hitBoat != 0) {
                damaged.add(hitBoat);
            }
            putElement(board, attack[0], attack[1], 0);
        }

        Set<Integer> remainingBoatsOnBoard = new HashSet<>();
        for (int[] row : board) {
            for (int col : row) {
                if (col != 0)
                    remainingBoatsOnBoard.add(col);
            }
        }

        Set<Integer> sunk = boatsOnBoard.stream().filter(e -> !remainingBoatsOnBoard.contains(e)).collect(toSet());

        result.put("sunk", (double) sunk.size());
        result.put("damaged", (double) damaged.size() - sunk.size());
        result.put("notTouched", (double) (boatsOnBoard.size() - damaged.size()));
        result.put("points", result.get("sunk") + 0.5 * result.get("damaged") - result.get("notTouched"));

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

    static int putElement(int[][] board, int i, int j, int value) {
        return board[board.length - j][i - 1] = value;
    }
}
