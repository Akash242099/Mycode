class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        int score = 0;
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '(') {
                arr.add(score);
                score = 0;
            } 
            else {
                if (s.charAt(i - 1) == '(') {
                    score = arr.get(arr.size() - 1) + 1;
                } 
                else {
                    score = arr.get(arr.size() - 1) + (2 * score);
                }

                arr.remove(arr.size() - 1);
            }
        }

        return score;
    }
}