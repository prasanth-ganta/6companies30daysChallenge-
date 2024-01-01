// //Sorting is Key for this problem 
// For ascending sort use (ONLY FOR BELOW PROBLEM) VARIES BASED ON PROBLEM
//   list.sort(Comparator.comparing((Pair p) -> p.s).thenComparingInt(p -> p.idx));
// For Decesending sort use
//   list.sort(Comparator.comparing((Pair p) -> p.s).thenComparingInt(p -> p.idx).reversed());

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];

            List<Pair> list = new ArrayList<>();
            for (int j=0; j<nums.length; j++){
                String s = nums[j];
                int len = s.length();
                String ss = s.substring(len-trim, len);
                list.add(new Pair(ss, j));
            }

        list.sort(Comparator.comparing((Pair p)->p.s).thenComparingInt(p ->p.idx));
        
        res[i] = list.get(k-1).idx;
        }

        return res;
    }
    
    static class Pair{
        String s;
        int idx;

        public Pair(String s, int idx) {
            this.s = s;
            this.idx = idx;
        }
    }
}
