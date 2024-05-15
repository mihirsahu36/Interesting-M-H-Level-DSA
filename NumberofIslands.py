'''Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.'''

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:        # if no value are present inside the grid then return 0
            return 0
        
        def dfs(grid, i, j):
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] == '0':    # this all checks the boundary conditions if its valid or not
                return
            grid[i][j] = '0'      # If the current cell is 1 the it visit it and mark it as 0
            dfs(grid, i+1, j)     # the below 4 dfs function calls are checking grid cell in all 4 direction up, down, left, right
            dfs(grid, i-1, j)
            dfs(grid, i, j+1)
            dfs(grid, i, j-1)
        
        num_islands = 0
        for i in range(len(grid)):          #T hese lines iterate over every cell in the grid using nested loops.
            for j in range(len(grid[0])):
                if grid[i][j] == '1':       # if cell value is 1 then increment the count of island and call to check all connected 1 values above below left and right direction
                    num_islands += 1
                    dfs(grid, i, j)
        
        return num_islands

        
