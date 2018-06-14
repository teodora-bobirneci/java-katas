package katas.supermarketqueue;

import java.util.Arrays;

class SupermarketQueue {

    private SupermarketQueue() {}

    static int solveSuperMarketQueue(int[] customers, int n) {
        int[] tills = new int[n];
        Arrays.fill(tills, 0);
        int current = 0;
        int totalTime = 0;

        while (current < customers.length) {
            while (isAnyTillAvailable(tills) && current < customers.length) {
                tills[firstAvailable(tills)] = customers[current];
                current++;
            }
            for (int i = 0; i < n; i++) {
                tills[i] -= 1;
            }
            totalTime++;
        }
        totalTime += flushTills(tills);

        return totalTime;
    }

    private static int flushTills(int[] tills) {
        int max = 0;
        for (int till : tills)
            if (till > max)
                max = till;
        return max;
    }

    private static boolean isAnyTillAvailable(int[] tills) {
        for (int till : tills)
            if (till == 0)
                return true;
        return false;
    }

    private static int firstAvailable(int[] tills) {
        for (int i = 0; i < tills.length; i++)
            if (tills[i] == 0)
                return i;
        return -1;
    }
}
