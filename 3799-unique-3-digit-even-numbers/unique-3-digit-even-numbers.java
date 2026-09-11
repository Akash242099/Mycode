class Solution {
    public int totalNumbers(int[] digits) {
    int[] fr=new int[10];
    int ans=0;
    for(int x:digits){
        fr[x]++;
    }
    for(int i=1;i<10;i++){
        for(int j=0;j<10;j++){
            for(int k=0;k<10;k+=2){
                fr[i]--;
                fr[j]--;
                fr[k]--;
                if(fr[i]>=0 && fr[j]>=0 && fr[k]>=0){
                    ans++;
                }
                fr[i]++;
                fr[j]++;
                fr[k]++;
            }
        }
    }

    return ans;
    }
}