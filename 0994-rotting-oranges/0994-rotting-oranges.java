class Solution {
    public int orangesRotting(int[][] arr) {
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        int m = arr.length;
        int n = arr[0].length;
        // here for count the numbers of fresh and store the loc of rotten.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    count++;
                } else if (arr[i][j] == 2) {
                    q.offer(new int[] { i, j });
                }
            }
        }
// if thete is no fresh Oranges .
        if (count == 0)
            return 0;
// Now start the rotting process of oranges.
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                // now here i take r , c of the rotten Oranges .
                int curLoc[] = q.poll();
                int r = curLoc[0];
                int c = curLoc[1];
                int grid[][] = {
                        { r - 1, c },
                        { r, c - 1 },
                        { r + 1, c },
                        { r, c + 1 },
                };
                // now rotting the fresh oranges and holding their locations
                for (int nums[] : grid) {
                    int nr = nums[0];
                    int nc = nums[1];
                    // check the conditions if thier no fresh oranges so skip the below part.
                    if (nr < 0 ||
                            nr >= m ||
                            nc < 0 ||
                            nc >= n ||
                            arr[nr][nc] == 0 ||
                            arr[nr][nc] == 2) {
                        continue;
                    }
                    // if fresh oranges exist so rotten them and hold loc.
                    q.offer(new int[] { nr, nc });
                    arr[nr][nc] = 2;
                    
                    if (--count == 0) {
                        return time + 1;
                    }
                }
            }
            // after ending time .

            time++;

        }
//now last check if count == 0 so return time else return -1.
//means it impossible to rotten the fresh oranges.
        return (count == 0) ? time : -1;

    }
}