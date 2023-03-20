package VALE.palindrom;

import java.util.*;

public class Palindrome {

    private static final Set<String> palindromes = new HashSet<>();
    private static boolean showReverse = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input;
        while (true) {
            System.out.println("1-palindrome  2-list of palindrome 3-show reversed toggle  4-end");
            input = Integer.parseInt(sc.nextLine());
            switch (input) {
                case 1 -> System.out.println(isPalindrome(sc.nextLine()) ? "Is a Palindrome." : "Is not a Palindrome.");
                case 2 -> palindromes.forEach(System.out::println);
                case 3 -> showReverse = !showReverse;
                case 4 -> {return;}
                default -> System.out.println("wrong input!");
            }
        }
    }

    private static boolean isPalindrome(final String s) {
        if (showReverse) {
            System.out.println(Arrays.toString(s.toLowerCase().toCharArray()));
            System.out.println(Arrays.toString(reverse(s.toLowerCase().toCharArray())));
        }
        for (int i = 0;i < s.length();i++) {
            if (s.toLowerCase().toCharArray()[i] != reverse(s.toLowerCase().toCharArray())[i])
                return false;
        }
        palindromes.add(s);
        return true;
    }

    private static char[] reverse(final char[] chars) {
        final char[] temp = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            temp[chars.length - i - 1] = chars[i];
        }
        return temp;
    }
}
