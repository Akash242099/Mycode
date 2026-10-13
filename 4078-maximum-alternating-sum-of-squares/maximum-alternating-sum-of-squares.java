class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        long[] arr = new long[n];
        for (int i = 0; i < nums.length; i++){
            arr[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(arr);

        long res = 0;
        int k = n / 2;

        for (int i = 0; i < k; i++){
            res -= arr[i];
        }

        for (int i = k; i < nums.length; i++){      
            res += arr[i];
        }

        return res;
    }
}
