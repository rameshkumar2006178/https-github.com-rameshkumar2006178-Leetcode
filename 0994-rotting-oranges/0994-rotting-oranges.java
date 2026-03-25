class Solution {
    public int orangesRotting(int[][] arr) {
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        int m = arr.length;
        int n = arr[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    count++;
                } else if (arr[i][j] == 2) {
                    q.offer(new int[] { i, j });
                }
            }
        }
        if (count == 0)
            return 0;
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int curLoc[] = q.poll();
                int r = curLoc[0];
                int c = curLoc[1];
                int grid[][] = {
                        { r - 1, c },
                        { r, c - 1 },
                        { r + 1, c },
                        { r, c + 1 },
                };
                for (int nums[] : grid) {
                    int nr = nums[0];
                    int nc = nums[1];
                    if (nr < 0 ||
                            nr >= m ||
                            nc < 0 ||
                            nc >= n ||
                            arr[nr][nc] == 0 ||
                            arr[nr][nc] == 2) {
                        continue;
                    }
                    q.offer(new int[] { nr, nc });
                    arr[nr][nc] = 2;
                    
                    if (--count == 0) {
                        return time + 1;
                    }
                }
            }

            time++;

        }

        return (count == 0) ? time : -1;

    }
}