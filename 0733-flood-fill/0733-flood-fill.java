class Solution {
      public void backtrack(int[][] grid,int row,int col,int color,int val) {
        if (row == grid.length || col == grid[0].length || row < 0 || col < 0 || grid[row][col] != val) {
            return ;
        }
        grid[row][col] = color;
        backtrack(grid, row - 1, col,color,val);
        backtrack(grid, row + 1, col,color,val);
        backtrack(grid, row, col - 1,color,val);
        backtrack(grid, row, col + 1,color,val);

    }
  
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
         if(image[sr][sc]==color) return image;
            int val=image[sr][sc];
            backtrack(image, sr, sc, color,val);
        return image;
    }
}