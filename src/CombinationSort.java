import java.util.*;

public class CombinationSort {


    public static List<String> sortStrings(List<String> strings) {
        // collection sort using lambda expression compaareing first char of both string.
        Collections.sort(strings, (a, b) -> (a.charAt(0)<b.charAt(0))? -1: 1);

        return strings;
    }
    public static List<String> sortStringsdes(List<String> lst) {
        // create a map to store the strings with the same initial character
        Map<Character, List<String>> groups = new HashMap<>();
        for (String string : lst) {
            char initialChar = string.charAt(0);
            if (groups.containsKey(initialChar)) {
                groups.get(initialChar).add(string);
            } else {
                List<String> group = new ArrayList<>();
                group.add(string);
                groups.put(initialChar, group);
            }
        }

        // Sort each group by the number formed by the remaining characters
        for (List<String> group : groups.values()) {
            Collections.sort(group, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    int num1 = Integer.parseInt(s1.substring(1));
                    int num2 = Integer.parseInt(s2.substring(1));
                    return num2 - num1;
                }

            });
        }

        // Combine the sorted groups into a single sorted list
        List<String> sortedList = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (groups.containsKey(c)) {
                sortedList.addAll(groups.get(c));
            }
        }

        return sortedList;

    }
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("d34", "g54", "d12", "b87", "g1", "c65", "g40", "g5", "d77");
        List<String> sortedStrings = sortStrings(strings);
        System.out.println(sortedStrings);
        List<String> sortedStrings2 = sortStringsdes(sortedStrings);
        System.out.println(sortedStrings2);

    }
}
