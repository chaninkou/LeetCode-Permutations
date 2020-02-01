package permutationOfDistinctInput;

import java.util.ArrayList;
import java.util.List;

// The input nums for this problem will be distinct integers, the program will not work if there is duplicates in input
public class FindAllPermutationFunction {
    public List<List<Integer>> permute(int[] nums) {
    	// This is to store answer result
        List<List<Integer>> finalList = new ArrayList<>();
        
        // God practice to call a method to do the recursive
        backtrack(finalList, new ArrayList<>(), nums);
        
        return finalList;
    }
    
    // Base case, if the tempList is the same size of nums
    // Othere wise, skip if templist already contains that element, then add and remove
    public void backtrack(List<List<Integer>> finalList, List<Integer> tempList, int[] nums){
        // Add the temp list to the final list whenever it gets to the same size as given array
        if(tempList.size() == nums.length){
        	// Make sure to add a new arraylist to the solution finalList, not just the tempList
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
                
                // Mostly, when backtracking, we want to remove the last element after the base case is done
                // When it reach to the base case (which is the if statement), then remove the last element of the tempList, since the size is already max
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
