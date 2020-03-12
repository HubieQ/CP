import java.io.*;

import java.util.*;
 public class Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
        
    public static void main(String[] args) throws IOException {
        int n=readInt();
         
        while(n!=0){
            int dp[][]=new int[n+1][n+1];
            for(int i=1;i<=n;i++)
                dp[i][0]=dp[0][i]=i;
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    dp[i][j]=readInt();
                }
            }
            boolean cont = true;
            for(int i=1;i<=n&&cont;i++){
                for(int j=1;j<=n&&cont;j++){
                    for(int k=1;k<=n&&cont;k++){
                        if(dp[i][dp[j][k]]!=dp[dp[i][j]][k]){
                            n=readInt();
                            System.out.println("no");
                            cont=false;
                        }
                    }
                }
            }if(!cont)continue;
           
            int id=0;
            for(int i=1;i<=n&&cont;i++){
                boolean flag = true;
                for(int j=1;j<=n&&flag;j++){
                        if(dp[i][j]==dp[j][i]&&dp[i][j]==j)continue;
                        flag = false;
                }if(flag){id=i;cont=false;}
            }if(cont){
                n=readInt();
                System.out.println("no");
                continue;
            }
            cont =true;
            for(int i=1;i<=n;i++){
                boolean flag = true;
                for(int j=1;j<=n&&flag;j++){
                    if(dp[i][j]==id&&dp[j][i]==id){
                        flag = false;
                    }
                }if(flag){cont = false;}
            }if(!cont)System.out.println("no");
            else System.out.println("yes");
            n=readInt();
        }
        
    
    }
  
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}static char readCharacter () throws IOException {
                return next().charAt(0);
        }
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}        
}
