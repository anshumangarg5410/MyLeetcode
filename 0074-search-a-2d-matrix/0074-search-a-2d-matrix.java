class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int n = matrix.length, m = matrix[0].length;

        while (row < n) {
            int start = 0, end = m-1;
            if (matrix[row][start] <= target && matrix[row][end] >= target) {
                while (start <= end) {
                    int mid = start + (end - start)/2;

                    if (matrix[row][mid] == target) {
                        return true;
                    }
                    else if (matrix[row][mid] > target) {
                        end = mid - 1;
                    }
                    else {
                        start = mid + 1;
                    }
                }
                
                return false; 
            }
            else {
                row++;
            }
        }

        return false;
    }
}