class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        //Integer[] ar=Arrays.stream(nums).boxed().toArray(x->new int[x]);
        Arrays.sort(nums);
       // List<Integer> ans=new ArrayList<>();
        List<Integer> ans = IntStream.range(0, nums.length).filter(i ->  nums[i] == target).boxed().toList();
       return ans;
    }
}