import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s) {
        char[] letters = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        String vowels = "aeiouAEIOU";
        while (left < right) {
            while (left < right && vowels.indexOf(letters[left]) == -1) {
                left++;
            }
            while (left < right && vowels.indexOf(letters[right]) == -1) {
                right--;
            }
            char temp = letters[left];
            letters[left] = letters[right];
            letters[right] = temp;
            left++;
            right--;
        }
        return new String(letters);
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length-1 || flowerbed[i+1] == 0)) {
                flowerbed[i] = 1;
                n--;
                if (n == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder mergerString = new StringBuilder();
        if (word1.length() <= word2.length()) {
            for (int i = 0; i < word1.length(); i++) {
                mergerString.append(word1.charAt(i)).append(word2.charAt(i));
            }
            mergerString.append(word2.substring(word1.length()));
        }
        if (word1.length() > word2.length()) {
            for (int i = 0; i < word2.length(); i++) {
                mergerString.append(word1.charAt(i)).append(word2.charAt(i));
            }
            mergerString.append(word1.substring(word2.length()));
        }
        return mergerString.toString();
    }


    public static int largestAltitude(int[] gain) {
        int highest = 0, max = 0;
        for (int i = 0; i < gain.length; ) {
            if (highest < max+gain[i]){
                highest = max+gain[i];
            }
            max += gain[i];
            i++;
        }
        return highest;
    }
}
