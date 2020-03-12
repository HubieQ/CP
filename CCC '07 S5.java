import java.util.*;

import java.io.*;
public class Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
       
	public static void main(String[] args) throws IOException{
            int t = readInt();
            for(int cases = 0;cases<t;cases++){
            int n = readInt(),k = readInt(),w = readInt();
            int[]pins = new int[n];
            int sum =0;
            for(int i=0;i<n;i++){
                pins[i]=readInt();
   
            }for(int i=0;i<w;i++)sum+=pins[i];
            int sumpins[] = new int[n];
            sumpins[0]=sum;
            int[][]dp = new int[k+1][n];
            for(int i=1;i<n-w+1;i++){
                sum = sum-pins[i-1]+pins[i+w-1];
                sumpins[i]=sum;
            }for(int i=n-w+1;i<n;i++){
                sum-=pins[i-1];
                sumpins[i]=sum;
            }
             for (int j = 1 ; j < n ; j++)
		dp[0][j] = 0;
	    for (int i = 1 ; i<= k ; i++)
		for (int j = 1 ; j < n ; j++)
		    dp[i][j] = -1;

	    for (int ball= 1;ball<= k;ball++)
		for (int i=n- 1 ;i>= 0;i--){
		    if (i>=n -w)dp[ball][i] = sumpins[i];
                    else dp[ball][i] = Math.max (dp[ball-1][i + w] +sumpins[i],dp[ball][i+1]);
		}System.out.println(dp[k][0]);
            }
        }
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
