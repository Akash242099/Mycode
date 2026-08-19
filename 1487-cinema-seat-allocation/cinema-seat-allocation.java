class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,Set<Integer>>hm=new HashMap<>();
        int m=reservedSeats.length;
        for(int i=0;i<m;i++){
            hm.computeIfAbsent(reservedSeats[i][0], k -> new HashSet<>()).add(reservedSeats[i][1]);
        }

         int ans=0;
         int p=n-hm.size();
         ans+=(2*p);
        for(Set<Integer> x:hm.values()){
          boolean f=x.contains(2) || x.contains(3) || x.contains(4) || x.contains(5);
            boolean s= x.contains(4) || x.contains(5) || x.contains(6) || x.contains(7);
        boolean t= x.contains(6) || x.contains(7) ||  x.contains(8) || x.contains(9) ;
        if(!f && !t){
            ans+=2;
        }
        else if(!f || !s || !t){
            ans+=1;
        }

        }
        return ans;
    }
}

/*

1.     2
2.     2              7       10
3. 1.            5
4  1                     9    

*/