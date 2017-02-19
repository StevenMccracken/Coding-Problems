// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
public class LongestIncreasingPath {
    public static final int[][] dirs = { {0,1}, {1,0}, {-1,0}, {0,-1} };
    
    public static void main(String[] args) { }
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0; // Edge case check
        
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        
        // Get longest increasing path from each cell, keep track of max longest path
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int length = dfs(matrix, cache, i, j, m, n);
                max = Math.max(length, max);
            }
        }
        return max;
    }
    
    public int dfs(int[][] matrix, int[][] cache, int i, int j, int m, int n) {
        if(cache[i][j] != 0) return cache[i][j]; // Check cache first
        
        int max = 1;
        // Call dfs for left, right, up, and down directions from current (i,j) cell
        for(int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            // Skip direction if next cell is out of bounds or smaller than current b/c we want increasing path
            if(x >= m || y >= n || x < 0 || y < 0 || matrix[x][y] <= matrix[i][j]) continue;
            
            int length = 1 + dfs(matrix, cache, x, y, m, n);
            max = Math.max(length, max);
        }
        
        cache[i][j] = max;
        return max;
    }
}