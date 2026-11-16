class Solution {
    public String digitSum(String s, int k) {

        while (s.length() > k) {
            StringBuilder t = new StringBuilder();
            for (int i = 0; i < s.length(); i += k) {
                int su = 0;
                for (int j = i; j < s.length() && j < i + k; j++) {
                    su+= s.charAt(j) - '0';
                }
                t.append(su);
            }
            s = t.toString();
        }
        return s;
    }
}