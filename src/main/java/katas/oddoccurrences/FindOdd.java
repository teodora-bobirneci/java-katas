package katas.oddoccurrences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


class FindOdd
{
	static int findIt(int[] a)
	{
		Map<Integer, Integer> occurrences = new HashMap<>();
		for (int no : a)
		{
			if (occurrences.getOrDefault(no, 0) % 2 == 1)
			{
				occurrences.remove(no);
			}
			else occurrences.put(no, 1);
		}
		return new ArrayList<>(occurrences.keySet()).get(0);
	}
}
