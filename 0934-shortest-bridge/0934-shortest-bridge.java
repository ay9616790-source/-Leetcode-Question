class Solution {

    int n, m;

    public int shortestBridge(int[][] grid) {

        n = grid.length;
        m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        boolean[][] visited = new boolean[n][m];

        boolean found = false;

        // Find first island
        for (int i = 0; i < n && !found; i++) {

            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {

                    dfs(i, j, grid, visited, q);

                    found = true;
                    break;
                }
            }
        }

        return bfs(grid, visited, q);
    }


    // DFS: first island ke saare cells queue mein daalo
    void dfs(int i, int j, int[][] grid,
             boolean[][] visited, Queue<int[]> q) {

        if (i < 0 || i >= n ||
            j < 0 || j >= m ||
            grid[i][j] != 1 ||
            visited[i][j]) {

            return;
        }

        visited[i][j] = true;

        q.offer(new int[]{i, j});

        dfs(i + 1, j, grid, visited, q);
        dfs(i - 1, j, grid, visited, q);
        dfs(i, j + 1, grid, visited, q);
        dfs(i, j - 1, grid, visited, q);
    }


    int bfs(int[][] grid, boolean[][] visited,
            Queue<int[]> q) {

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int[] curr = q.poll();

                int i = curr[0];
                int j = curr[1];

                // DOWN
                if (i + 1 < n) {

                    if (grid[i + 1][j] == 1 &&
                        !visited[i + 1][j]) {

                        return steps;
                    }

                    if (grid[i + 1][j] == 0 &&
                        !visited[i + 1][j]) {

                        visited[i + 1][j] = true;
                        q.offer(new int[]{i + 1, j});
                    }
                }

                // UP
                if (i - 1 >= 0) {

                    if (grid[i - 1][j] == 1 &&
                        !visited[i - 1][j]) {

                        return steps;
                    }

                    if (grid[i - 1][j] == 0 &&
                        !visited[i - 1][j]) {

                        visited[i - 1][j] = true;
                        q.offer(new int[]{i - 1, j});
                    }
                }

                // RIGHT
                if (j + 1 < m) {

                    if (grid[i][j + 1] == 1 &&
                        !visited[i][j + 1]) {

                        return steps;
                    }

                    if (grid[i][j + 1] == 0 &&
                        !visited[i][j + 1]) {

                        visited[i][j + 1] = true;
                        q.offer(new int[]{i, j + 1});
                    }
                }

                // LEFT
                if (j - 1 >= 0) {

                    if (grid[i][j - 1] == 1 &&
                        !visited[i][j - 1]) {

                        return steps;
                    }

                    if (grid[i][j - 1] == 0 &&
                        !visited[i][j - 1]) {

                        visited[i][j - 1] = true;
                        q.offer(new int[]{i, j - 1});
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}