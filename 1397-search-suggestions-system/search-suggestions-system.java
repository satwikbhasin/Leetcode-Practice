class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> results = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            String toSearch = searchWord.substring(0, i + 1);
            List<String> result = new ArrayList<>();
            for (String product : products) {
                if (product.startsWith(toSearch)) {
                    result.add(product);
                }
            }
            Collections.sort(result);
            if (result.size() > 3) {
                results.add(result.subList(0, 3));
            } else {
                results.add(result);
            }
        }
        return results;
    }
}