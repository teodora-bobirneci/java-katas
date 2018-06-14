package katas.camelcase;

class CamelCase {

    private CamelCase(){}

    static String camelCase(String str) {
        String[] words = str.split(" ");
        StringBuilder camelCased = new StringBuilder();
        for (String s : words) {
            if (s.isEmpty())
                continue;
            camelCased.append(s.substring(0, 1).toUpperCase()).append(s.substring(1, s.length()));
        }
        return camelCased.toString();
    }

}
