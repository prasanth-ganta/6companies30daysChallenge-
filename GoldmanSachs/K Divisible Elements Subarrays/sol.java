// Given an integer array nums and two integers k and p, return the number of distinct subarrays,
// which have at most k elements that are divisible by p.
// Input: nums = [2,3,3,2,2], k = 2, p = 2
// Output: 11
// Explanation:
// The elements at indices 0, 3, and 4 are divisible by p = 2.
// The 11 distinct subarrays which have at most k = 2 elements divisible by 2 are:
// [2], [2,3], [2,3,3], [2,3,3,2], [3], [3,3], [3,3,2], [3,3,2,2], [3,2], [3,2,2], and [2,2].
// Note that the subarrays [2] and [3] occur more than once in nums, but they should each be counted only once.
// The subarray [2,3,3,2,2] should not be counted because it has 3 elements that are divisible by 2.

class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        HashSet<ArrayList<Integer>>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            List<Integer>list=new ArrayList<>();
            int count=0;
            for(int j=i;j<nums.length;j++){
                list.add(nums[j]);
                if(nums[j]%p==0){
                    count++;
                }
                if(count>k){
                    break;
                }
                set.add(new ArrayList<>(list));
            }
        }
        return set.size();
    }
}
