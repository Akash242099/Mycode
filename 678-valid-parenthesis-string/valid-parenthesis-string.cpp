// class Solution {
// public:
//     bool checkValidString(string s) {
//         int n=s.size(),st=0,l=0;
//         for(int i=0;i<n;i++){
//             if(s[i]=='('){
//                 l++;
//             }
//             else if(s[i]==')'){
//                 if(l>0){
//                     l--;
//                 }
//                 else if(st>0){
//                     st--;
//                 }
//                 else return false;
//             }
//             else{
//                 st++;
//             }
//         }
//         cout<<l<<". "<<st<<"\n";
//     if(st>=l) return true;
        
//         return false;
//     }
// };

class Solution {
public:
    bool checkValidString(string s) {
        int mini = 0, maxi = 0;

        for (char c : s) {
            if (c == '(') {
                mini++;
                maxi++;
            } else if (c == ')') {
                mini--;
                maxi--;
            } else {
                mini--;
                maxi++;
            }
            if (maxi < 0) return false;
            if (mini < 0) mini = 0;
        }
        
        return mini == 0;
    }
};