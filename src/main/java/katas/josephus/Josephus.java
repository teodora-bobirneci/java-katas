package katas.josephus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class Josephus {

    static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        if (items.isEmpty())
            return Collections.emptyList();

        int[] visited = new int[items.size()];
        Arrays.fill(visited, 0);
        List<T> result = new ArrayList<>();

        int pos = (k - 1) % visited.length;
        while (unvisitedCount(visited) > 0) {
            result.add(items.get(pos));
            visited[pos] = 1;
            pos = nextKth(visited, k, pos);
        }
        return result;
    }

    private static int nextKth(int[] visited, int k, int pos) {
        int count = 0;
        for (int i = 1; i <= k * visited.length; i++) {
            if (visited[(pos + i % visited.length) % visited.length] == 0) {
                count++;
                if (count == k) {
                    return (pos + i % visited.length) % visited.length;
                }
            }
        }
        return -1;
    }

    private static int unvisitedCount(int[] visited) {
        int sum = 0;

        for (int i : visited) {
            if (i == 0)
                sum += 1;
        }

        return sum;
    }

}
