class Solution {
    public boolean checkString(String s) {
        boolean p=false;
        for(char x:s.toCharArray()){
            if(x=='b'){
              //  if(p) return false;
                p=true;
            }
            else{
                if(p) return false;
              //  p=true;
            }
        }
        return true;
    }
}