package katas.uniquechars;

public class UniqueCharactersKata {
    public static boolean hasUniqueChars(String str) {
        return str.chars().distinct().count() == str.chars().count();
    }
}
