import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        System.out.println(mergeAlternately("ab", "cd"));
    }

    public static String mergeAlternately(String word1, String word2) {
        if (word1.length() > word2.length()) return null;
        StringBuilder mergerString = new StringBuilder();
        for (int i = 0; i < word1.length(); i++) {
            mergerString.append(word1.charAt(i)).append(word2.charAt(i));
        }
        mergerString.append(word2.charAt(word1.length()));
        return mergerString.toString();
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int frequent, fir;
        for (int i = 0; i < flowerbed.length; ) {
            frequent = 0;
            fir = flowerbed[i];
            while (fir == flowerbed[i]){
                frequent++;
                if (n*2+1 <= frequent) {
                    return true;
                }
                i++;
            }
            if (i == flowerbed.length-1){
                break;
            }
        }
        return false;
    }

//    public static int[] topKFrequent(int[] nums, int k) {
//        int frequent = 0, j = 0;
//        int[] newArr = new int[nums.length];
//        int n=0;
//        for (int i = 0; i < nums.length;) {
//            n = nums[i];
//            frequent = 0;
//            while (n == nums[i]){
//                frequent++;
//                if (i < nums.length){
//                    break;
//                }
//                i++;
//            }
//            if (frequent >= k){
//                newArr[j] = n;
//            }
//        }
//
//        return newArr;
//    }


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
