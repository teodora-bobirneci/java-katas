package katas.redacted;

public class Redacted {

    public static boolean redacted(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str2.charAt(i) == '\n' && str1.charAt(i) != '\n') {
                return false;
            }
            if (str1.charAt(i) != 'X' && str1.charAt(i) != str2.charAt(i))
                return false;
        }
        return true;
    }

}
