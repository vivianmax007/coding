class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     * 
     * Recursive solution. 
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        
        return helper(nums, 0);
    }
    
    private ArrayList<ArrayList<Integer>> helper(int[] nums, int index) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        
        if (index == nums.length) {
            result.add(new ArrayList<Integer>());
            return result; 
        }
        
        result = helper(nums, index + 1); 
        
        for (int i = result.size() - 1; i >= 0; i--) {
            ArrayList<Integer> temp = new ArrayList<Integer>(result.get(i));
            temp.add(0, nums[index]);
            result.add(temp);
        }
        
        return result; 
    }
}
