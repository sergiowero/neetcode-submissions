class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int size = matrix.length * matrix[0].length;
        int rowSize = matrix[0].length;

        int left = 0 , right = size - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            int row = mid / rowSize;
            int col = mid % rowSize; 
            int val = matrix[row][col];

            if (val > target) {
                right = mid - 1;
            } else if (val < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;

    }
}
