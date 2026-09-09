class Solution {
    private static final long[] temp = { 1000L, 1000000L, 1000000000L, 1000000000000L, 1000000000000000L, 1000000000000000000L };
    
    public long countCommas(long n) {
        int k = 0;        
        for (long p : temp) if (n >= p) k++;
        
        return k * (n + 1) - (temp[k] - 1000) / 999;
    }
}