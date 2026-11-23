class ProductOfNumbers {
    private List<Integer> ar;

    public ProductOfNumbers() {
      
        ar = new ArrayList<>();
        ar.add(1);
    }

    public void add(int num) {
        if (num > 0) {
         
            ar.add(ar.get(ar.size() - 1) * num);
        } else {
       
            ar.clear();
            ar.add(1);
        }
    }

    public int getProduct(int k) {

        return ar.size() > k ? ar.get(ar.size() - 1) / ar.get(ar.size() - k - 1) : 0;
    }
}
/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */