import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CutSticks {
	public static void main(String[] args) {
		int[] nums = new int[] {8,1,2,3,4,3,3,2,1};
		System.out.println("Numbers: " + Arrays.toString(nums));
		int[] res = cutSticks(nums);
		System.out.println("Number of cuts: " + Arrays.toString(res));
	}
	
	public static int[] cutSticks(int[] lengths) {
        List<Integer> cutCounts = new ArrayList<>();
        boolean stillNeedToCut = true;
        
        while(stillNeedToCut) {
            stillNeedToCut = false;
            // Find smallest element
            int smallestLength = Integer.MAX_VALUE;
            for(int i = 0; i < lengths.length; i++) {
                if(lengths[i] < smallestLength && lengths[i] != 0) smallestLength = lengths[i];
            }

            // Cut the elements
            int elementCuts = 0;
            for(int i = 0; i < lengths.length; i++) {
                if(lengths[i] != 0) {
                    lengths[i] -= smallestLength;
                    elementCuts++;
                    if(lengths[i] != 0 && !stillNeedToCut) stillNeedToCut = true;
                }
            }
            cutCounts.add(elementCuts);
        }
        int[] results = new int[cutCounts.size()];
        for(int i = 0; i < results.length; i++) results[i] = cutCounts.get(i);
        return results;
    }

}
