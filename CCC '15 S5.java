import java.util.*;
import java.io.*;
public class Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
        static int m,n,a[],b[],dp[][][][];
	public static void main(String[]args)throws IOException{    
            n = readInt();a=new int[n+1];
            for(int i=1;i<=n;i++)a[i]=readInt();
            m = readInt();b=new int[m+1];
            for(int i=1;i<=m;i++)b[i]=readInt();
            b[0]=-1;
            Arrays.sort(b);
            dp=new int[n+5][2][m+5][m+5];
           for(int[][][]i :dp) {
                for(int[][]j: i) {
                    for(int[]k :j) {
                        Arrays.fill(k, -1);
                    }
		}
            }
            System.out.println(recur(1,1,1,m));
            
           
        }public static int recur(int cur,int take,int l,int r){
        
            if(dp[cur][take][l][r]!=-1)return dp[cur][take][l][r];
            if(cur==n+1){
                if(l<=r){
                    if(take==1)return dp[cur][take][l][r] =b[r]+ recur(cur,0,l,r-1);
                    return dp[cur][take][l][r]=recur(cur,1,l+1,r);
                }return dp[cur][take][l][r]=0;
            }if(take==1){
                dp[cur][take][l][r] = Math.max(a[cur]+recur(cur+1,0,l,r),recur(cur,0,l,r));
                if(l<=r)dp[cur][take][l][r] = Math.max(dp[cur][take][l][r],b[r]+recur(cur,0,l,r-1));
            }else{
                dp[cur][take][l][r]=recur(cur+1,1,l,r);
                if(l<=r)dp[cur][take][l][r]=Math.max(dp[cur][take][l][r],recur(cur,1,l+1,r));
                
            }return dp[cur][take][l][r];
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
