public class Search2dArray {
	public static void main(String[] args) {
		int[][] arr = new int[][] {	{1,4,7,11,15},
									{2,5,8,12,19},
									{3,6,9,16,22},
									{10,13,14,17,24},
									{18,21,23,26,30} };
		for(int i = 0; i < 30; i++)
			System.out.printf("%d %s in the array!%n", i, searchMatrix(arr,i) ? "is" : "is not");
	}
	
	// O(m+n) time, O(1) space
	public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}