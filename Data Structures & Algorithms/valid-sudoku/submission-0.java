class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        boolean[][] seenInRow = new boolean[9][9];
        boolean[][] seenInCol = new boolean[9][9];
        boolean[][] seenInBox = new boolean[9][9];


        for (int row = 0; row < board.length ; row++) {

            for (int col = 0 ; col < board[row].length ; col++) {

                char current = board[row][col];
                if ('.' == current) continue;

                int num = current - '1';
                int boxIndex = (row / 3) * 3 + (col / 3);

                if (seenInRow[row][num] 
                    || seenInCol[col][num] 
                    || seenInBox[boxIndex][num]) {
                    return false;   
                }

                seenInRow[row][num] = true;
                seenInCol[col][num] = true;
                seenInBox[boxIndex][num] = true;
            }

        }

        return true;

    }
}
