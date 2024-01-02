// Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
// Only numbers 1 through 9 are used.
// Each number is used at most once.
// Return a list of all possible valid combinations.
// The list must not contain the same combination twice, and the combinations may be returned in any order.

//BackTracking
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        function(1,k,n,temp,result);
        return result;
    }
    void function(int start,int k,int target,List<Integer>temp,List<List<Integer>>result){
        if(k==0&&target==0){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<=9&&target>0&&k>0;i++){
           if(target-i>=0){
                temp.add(i);
                function(i+1,k-1,target-i,temp,result);
                temp.remove(temp.size()-1);
           }
        }
    }
}
