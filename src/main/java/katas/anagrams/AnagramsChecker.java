package katas.anagrams;

import java.util.HashMap;
import java.util.Map;

class AnagramsChecker {

    boolean check(String word1, String word2) {
        if (word1 == null || word2 == null) return false;
        if (word1.length() != word2.length()) return false;

        Map<Character, Integer> word1OccurrenceMap = buildOccurrenceMap(word1);
        Map<Character, Integer> word2OccurrenceMap = buildOccurrenceMap(word2);

       if (word1OccurrenceMap.size() != word2OccurrenceMap.size()) return false;
       if (!word1OccurrenceMap.keySet().containsAll(word2OccurrenceMap.keySet())) return false;

       for (Map.Entry<Character, Integer> charEntry : word1OccurrenceMap.entrySet()){
           if (!word1OccurrenceMap.get(charEntry.getKey()).equals(word2OccurrenceMap.get(charEntry.getKey())))
               return false;
       }
        return true;
    }

    private Map<Character, Integer> buildOccurrenceMap(String word) {
        Map<Character, Integer> occurrences = new HashMap<>();
        for (Character c : word.toCharArray())
            if (occurrences.containsKey(c)) {
                occurrences.put(c, occurrences.get(c) + 1);
            } else
                occurrences.put(c, 1);
        return occurrences;
    }

}
