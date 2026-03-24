class Solution {
    public void backtrack(char[][] grid,int row,int col){
        if(row==grid.length || col==grid[0].length ||row<0 ||col<0 ||grid[row][col]=='0')
        {
            return;
        }
        grid[row][col]='0';
        backtrack(grid,row-1,col);
        backtrack(grid,row+1,col);
        backtrack(grid,row,col-1);
        backtrack(grid,row,col+1);
    }
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        int row=grid.length;
        int col=grid[0].length;
        int c=0;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]=='1')
                {
                    backtrack(grid,i,j);
                    c++;
                }
            }
        }
        return c;
    }
}