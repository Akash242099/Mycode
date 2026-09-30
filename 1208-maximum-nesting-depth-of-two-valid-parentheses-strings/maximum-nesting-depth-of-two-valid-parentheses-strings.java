class Solution {
    public int[] maxDepthAfterSplit(String s) {
        int n = s.length();
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++)
            ans[i] = (i ^ s.charAt(i)) & 1;
            
        return ans;
    }
}