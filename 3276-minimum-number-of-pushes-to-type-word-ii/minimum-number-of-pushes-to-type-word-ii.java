class Solution {
    public class Pair{
        private char p;
        private int q;
        Pair(char p,int q){
            this.p=p;
            this.q=q;
        }
    }
    public int minimumPushes(String word) {
        HashMap<Character,Integer>hm=new HashMap<>();
        for(Character x:word.toCharArray()){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        List<Pair>ar=new ArrayList<>();
        for(Map.Entry<Character,Integer> x:hm.entrySet()){
            ar.add(new Pair(x.getKey(),x.getValue()));
        }
        
        Collections.sort(ar,new Comparator<Pair>(){
          public int compare(Pair a,Pair b){
            return b.q-a.q;
          }
        });
int ans=0,i=0;
System.out.println(ar.size());

    while(i<ar.size()){
        System.out.println(ar.get(i).p +"   "+ar.get(i).q);
    if(i<8 && i>=0){
ans=ans+(ar.get(i).q);
    }
    else if(i>=8 && i<16){
ans+=(ar.get(i).q*2);
    }
     else if(i>=16 && i<24){
ans+=(ar.get(i).q*3);
     }
      else if(i>=24 && i<26){
ans+=(ar.get(i).q*4);
     }
     i++;
    }

return ans;
    }
}