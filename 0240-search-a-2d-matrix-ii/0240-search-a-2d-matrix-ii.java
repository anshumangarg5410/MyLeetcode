class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;

        while (row < matrix.length) {
            int start = 0, end = matrix[row].length - 1;

            while (start <= end) {
                int mid = start + (end - start)/2;

                if (matrix[row][mid] == target) return true;
                else if (matrix[row][mid] > target) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }

             }

            row++;
        }

        return false;
    }
}