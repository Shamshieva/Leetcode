import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
//        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
//        System.out.println(canPlaceFlowers(new int[]{0,0,1,0,1}, 1));
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1,0,0}, 2));
//        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1,0,0,0,0}, 4));
//        System.out.println(canPlaceFlowers(new int[]{1}, 0));
//        System.out.println(canPlaceFlowers(new int[]{0}, 1));
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
