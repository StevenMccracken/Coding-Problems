import java.util.ArrayList;
import java.util.Arrays;

public class H_Index {
    public static void main(String[] args) {
        ArrayList<int[]> citations = new ArrayList<>();//{{11,15},{0,1},{0,0}};
        citations.add(null);
        citations.add(new int[] {});
        citations.add(new int[] {0,0});
        citations.add(new int[] {1,0});
        citations.add(new int[] {11,15});
        citations.add(new int[] {3,0,6,1,5});

        for(int[] citation : citations) {
            if(citation == null) continue;
            System.out.print(Arrays.toString(citation));
            System.out.printf(" -> H-Index = %d%n",hIndex(citation));
            Arrays.sort(citation);
        }

        for(int[] citation: citations) {
            if(citation == null) continue;
            System.out.print(Arrays.toString(citation));
            System.out.printf(" -> H-Index = %d%n",hIndex_inputSorted(citation));
        }
    }

    // O(nlogn) time, O(1) space
    public static int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int hIndex = 0, length = citations.length;
        Arrays.sort(citations);

        for(int i = 0; i < length; i++) {
            int numPapers = length - i;
            if(numPapers <= citations[i] && numPapers > hIndex) hIndex = numPapers;
        }
        return hIndex;
    }

    public static int hIndex_inputSorted(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int length = citations.length;
        if(citations.length == 1) return citations[0] == 0 ? 0 : 1;

        int low = 0, high = length - 1;
        while(low <= high) {
            int mid = (high - low) / 2;
            if(citations[mid] == length - mid)
                return citations[mid];
            else if(citations[mid] > length - mid)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return length - low;
    }
}