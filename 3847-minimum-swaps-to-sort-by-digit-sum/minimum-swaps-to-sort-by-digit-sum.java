class Solution {
    int sum(int p){
        int s=0;
        while(p>0){
            s+=p%10;
            p/=10;
        }
        return s;
    }
    public int minSwaps(int[] nums) {
        Integer[] newArr=Arrays.stream(nums).boxed().toArray(size -> new Integer[size]);
        Arrays.sort(newArr,(a,b)->{
            int p=sum(a);
            int q=sum(b);
            if(p!=q) return p-q;
            return a-b;
        });

Arrays.stream(newArr).forEach(a -> System.out.print(a + "  "));
       
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],i);
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(newArr[i]!=nums[i]){
                int j = hm.get(newArr[i]);
                int p = nums[i];

                nums[i] = nums[j];
                nums[j] = p;

                hm.put(nums[i], i);
                hm.put(p, j);

                ans++;
            }
        }


        return ans;
        
    }
}