package permutationOfDistinctInput;

import java.util.ArrayList;
import java.util.List;

public class FindAllPermutationFunction {
	// Need to review this
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        
        backtrack(finalList, new ArrayList<>(), nums);
        
        return finalList;
    }
    
    public void backtrack(List<List<Integer>> finalList, List<Integer> tempList, int[] nums){
        // Add the temp list to the final list whenever it gets to the same size as given array
        if(tempList.size() == nums.length){
        	// Add a new arraylist to he solution finalList
            finalList.add(new ArrayList<>(tempList));
        } else {
            for(int i = 0; i < nums.length; i++){
                // If element already in the templist, just skip to the next element by using continue
                if(tempList.contains(nums[i])){
                    continue;
                }
                
                // Add element that is not in the list already
                tempList.add(nums[i]);
                
                // Backtracking
                backtrack(finalList, tempList, nums);
                
                // When it reach to the base case (which is the if statement), then remove the last element of the tempList, since the size is already max
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
