package permutationOfDistinctInput;

import java.util.Arrays;

// Need to review permutation!!
public class Main {
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		
		System.out.println("Input: " + Arrays.toString(nums));
		
		FindAllPermutationFunction solution = new FindAllPermutationFunction();
		
		System.out.println("Solution: " + solution.permute2(nums));
	}
}
