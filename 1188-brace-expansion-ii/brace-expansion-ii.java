class Solution {
    private int index;
    private String str;

    public List<String> braceExpansionII(String expression) {
        this.str = expression;
        this.index = 0;

        Set<String> result = parse();
        List<String> answer = new ArrayList<>(result);

        Collections.sort(answer);
        return answer;
    }

    private Set<String> parse() {
        Set<String> result = new TreeSet<>();
        Set<String> current = new TreeSet<>();

        current.add("");

        while (index < str.length() && str.charAt(index) != '}') {
            if (str.charAt(index) == '{') {
                index++;

                Set<String> next = parse();

                index++;
                current = product(current, next);

            } else if (str.charAt(index) == ',') {
                result.addAll(current);

                current = new TreeSet<>();
                current.add("");

                index++;

            } else {
                Set<String> next = new TreeSet<>();
                next.add(String.valueOf(str.charAt(index)));

                index++;
                current = product(current, next);
            }
        }

        result.addAll(current);
        return result;
    }

    private Set<String> product(Set<String> first, Set<String> second) {
        Set<String> ans = new TreeSet<>();

        for (String x : first)
            for (String y : second)
                ans.add(x + y);

        return ans;
    }
}