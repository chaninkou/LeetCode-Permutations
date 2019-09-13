package permutationOfDistinctInput;

import java.util.ArrayList;
import java.util.List;

public class FindAllPermutationFunction {
	public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> finalList = new ArrayList<>();
		
		backtrack(finalList, new ArrayList<>(), nums);
		
		return finalList;
	}
	
	private void backtrack(List<List<Integer>> finalList, List<Integer> tempList, int[] nums){
		if(tempList.size() == nums.length){
			finalList.add(new ArrayList<>(tempList));
		} else {
			for(int i = 0; i < nums.length; i++){
				if(tempList.contains(nums[i])){
					continue;
				}
				tempList.add(nums[i]);
				
				backtrack(finalList, tempList, nums);
				
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
