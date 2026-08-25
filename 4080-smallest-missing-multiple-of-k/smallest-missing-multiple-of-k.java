class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>(Arrays.stream(nums).boxed().toList());

        for (int i = k; i <= 202; i += k) {
            if (!hs.contains(i)) {
                return i;
            }
        }

        return k;
    }
}