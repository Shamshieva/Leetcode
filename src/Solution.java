public class Solution {

    public static void main(String[] args) {

        System.out.println(largestAltitude(new int[]{-5, 1, 5, 0, -7}));
    }

    public int[] topKFrequent(int[] nums, int k) {

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
