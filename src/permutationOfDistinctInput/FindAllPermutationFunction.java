package permutationOfDistinctInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// The input nums for this problem will be distinct integers, the program will not work if there is duplicates in input
public class FindAllPermutationFunction {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        
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
            	// Using contains to track if we already finish an element, this works cause the input does not have duplicates
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
    
    // Faster way
    public List<List<Integer>> permute2(int[] nums){
    	List<List<Integer>> result = new ArrayList<>();
    	
    	addWhenNeeded(result, 0, nums);
    	
    	return result;		
    }
    
    // Or use a index to keep track instead of temp list
    private void addWhenNeeded(List<List<Integer>> result, int finalIndex, int[] nums){
    	// finalIndex will tell us if we completed the swap and ready to add into result
    	if(finalIndex == nums.length){
    		result.add(convertArrayToList(nums));
    	} else {
    		for(int currentIndex = finalIndex; currentIndex < nums.length; currentIndex++){
    			// First iteration will not swap, when currentIndex increase, it will swap
    			swap(nums, currentIndex, finalIndex);
    			
    			addWhenNeeded(result, finalIndex + 1, nums);
    			
    			// Swap it back to original
    			swap(nums, currentIndex, finalIndex);
    		}
    	}
    	
    }
    
    // convert array to list
    private List<Integer> convertArrayToList (int[] nums){
    	List<Integer> list = new ArrayList<>(nums.length);
    	
    	for(int i : nums){
    		list.add(i);
    	}
    	
    	return list;
    }
    
    // Swapping elements
    private void swap (int[] nums, int i, int j){
    	int temp = nums[i];
    	
    	nums[i] = nums[j];
    	
    	nums[j] = temp;
    }
    
    
    
}
