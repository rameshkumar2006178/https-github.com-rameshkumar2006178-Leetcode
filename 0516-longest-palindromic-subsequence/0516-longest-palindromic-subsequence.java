class Solution {
    public int longestPalindromeSubseq(String s) {
         String s1=" " ;
        for (int i=s.length()-1;i>=0;i--){
            s1 = s1+s.charAt(i);
        }
        int n=s.length();
        int m=s1.length();
        int[][] db=new int[n+1][m+1];
        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                if (s.charAt(i-1)==s1.charAt(j-1)){
                    db[i][j] = db[i-1][j-1]+1;
                }
                else{
                    db[i][j] = Math.max(db[i-1][j], db[i][j-1]);
                }
            }
        }
        return db[n][m];
    }
}