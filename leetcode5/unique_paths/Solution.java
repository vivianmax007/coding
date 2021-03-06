public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0; 
        }
        
        int[][] T = new int[m][n]; 
        
        for (int i = 0; i < m; i++) {
            T[i][0] = 1; 
        }
        
        for (int j = 0; j < n; j++) {
            T[0][j] = 1; 
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                T[i][j] = T[i][j - 1] + T[i - 1][j]; 
            }
        }
        
        return T[m - 1][n - 1]; 
    }
}
