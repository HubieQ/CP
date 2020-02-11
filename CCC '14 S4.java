import java.io.*;

import java.util.*;
 public class Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
        
    public static void main(String[] args) throws IOException {
        int n=readInt(),t=readInt(),a[][]=new int[5][n];
        ArrayList<Integer>x = new ArrayList<>(),y=new ArrayList<>();
        HashMap<Integer,Integer>cx =new HashMap<>(),cy=new HashMap<>();
        TreeSet<Integer> xd = new TreeSet<>();
	TreeSet<Integer> yd = new TreeSet<>();
        for(int i=0;i<n;i++){
            int x1=readInt(),y1=readInt(),x2=readInt(),y2=readInt(),tint=readInt();
            a[0][i]=x1;
            a[1][i]=y1;
            a[2][i]=x2;
            a[3][i]=y2;
            a[4][i]=tint;
            xd.add(x1);
            xd.add(x2);
            yd.add(y1);
            yd.add(y2);
        
        }x.addAll(xd);y.addAll(yd);
        Collections.sort(x);
        Collections.sort(y);
        long dp[][]=new long[2019][2019];
        for(int i=1;i<=x.size();i++){
            cx.put(x.get(i-1),i);
        }for(int i=1;i<=y.size();i++){
            cy.put(y.get(i-1),i);
        }for(int i=0;i<n;i++){
           int x1=cx.get(a[0][i]),y1=cy.get(a[1][i]),x2=cx.get(a[2][i]),y2=cy.get(a[3][i]),tint=a[4][i];
           dp[x1][y1]+=tint;
           dp[x1][y2]-=tint;
           dp[x2][y1]-=tint;
           dp[x2][y2]+=tint;
        }
        
        long ans=0;
        for(int i=1;i<x.size();i++){
            for(int j=1;j<y.size();j++){
                dp[i][j]+=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1];
                if(dp[i][j]>=t)ans+=((long)x.get(i)-x.get(i-1))*((long)y.get(j)-y.get(j-1));
            }
        }System.out.println(ans);
        
    
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
