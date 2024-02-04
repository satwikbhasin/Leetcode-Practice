class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> outerList = new ArrayList<>();

        for (int i = 0; i < searchWord.length(); i++) {
            List<String> innerList = new ArrayList<>();
            int left = 0;
            int right = products.length - 1;
            int firstOccurance = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int len = Math.min((i), products[mid].length() - 1);
                //System.out.println("Comparing " + products[mid].substring(0, len + 1) + " to " + searchWord.substring(0, i + 1));
                if (products[mid].substring(0, len + 1).compareTo(searchWord.substring(0, i + 1)) > 0) {
                    right = mid - 1;
                } else if (products[mid].substring(0, len + 1).compareTo(searchWord.substring(0, i + 1)) < 0) {
                    left = mid + 1;
                } else {
                    firstOccurance = mid;
                    right = mid - 1;
                }
            } 
            
            if(firstOccurance != -1){
                innerList.add(products[firstOccurance]);
                if((firstOccurance + 1) < products.length && products[firstOccurance+1].startsWith(searchWord.substring(0, i + 1)))
                    innerList.add(products[firstOccurance+1]);
                if((firstOccurance + 2) < products.length && products[firstOccurance+2].startsWith(searchWord.substring(0, i + 1)))
                    innerList.add(products[firstOccurance+2]);
            }   
                outerList.add(innerList);
            }
        return outerList;
    }
}
