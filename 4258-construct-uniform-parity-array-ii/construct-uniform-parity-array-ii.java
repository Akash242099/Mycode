class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length,o=0,e=0;
       // HashMap<Integer> hm=new HashMap<>();
    //    HashMap<Boolean,Set<Integer>> hm= Arrays.stream(nums1).boxed().collect(Collectors.partitioningBy(x->x%2==0,Collectors.toSet()));
      int mini=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums1[i]%2==1){
              o++;
               mini=Math.min(mini,nums1[i]);
            }
            else{
                e++;
            }

        }
        if(e==n || o==n) return true;
         o=0;
       
          for(int i=0;i<n;i++){
           if(nums1[i]%2==1){
            }
            else{
                if(mini>=nums1[i]) return false;
            
            }
           
        }
        return true;
    }
}