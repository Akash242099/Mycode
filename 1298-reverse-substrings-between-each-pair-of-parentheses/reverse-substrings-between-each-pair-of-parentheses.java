class Solution {
    public String reverseParentheses(String s) {
        Deque<Integer> st = new LinkedList<>();
        StringBuilder ans = new StringBuilder();

        for (char x : s.toCharArray()) {
            if (x == '(') {
                st.push(ans.length());
            } else if (x == ')') {
                int i = st.pop();
                String reversed = new StringBuilder(ans.substring(i)).reverse().toString();
                ans.replace(i, ans.length(), reversed);
            } else {
                ans.append(x);
            }
        }

        return ans.toString();
    }
}