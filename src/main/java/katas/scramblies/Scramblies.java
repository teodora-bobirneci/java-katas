package katas.scramblies;

import java.util.HashMap;
import java.util.Map;


class Scramblies {

	static boolean scramble(String str1, String str2) {
		Map<Character, Integer> occurrencesStr1 = occurrences(str1);
		Map<Character, Integer> occurrencesStr2 = occurrences(str2);

		return containsAll(occurrencesStr1, occurrencesStr2);
	}

	private static Map<Character, Integer> occurrences(String str1) {
		Map<Character, Integer> occurrences = new HashMap<>();

		for (Character c : str1.toCharArray()) {
			occurrences.put(c, occurrences.getOrDefault(c, 0) + 1);
		}

		return occurrences;
	}

	private static boolean containsAll(Map<Character, Integer> map1, Map<Character, Integer> map2) {
		if (!map1.keySet().containsAll(map2.keySet()))
			return false;
		for (Character c : map2.keySet()) {
			if (map2.getOrDefault(c, 0) > map1.getOrDefault(c, 0)) {
				return false;
			}
		}
		return true;
	}
}
