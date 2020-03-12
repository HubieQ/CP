import java.io.*;

import java.util.*;
 public class Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
        static int max,a[];
    public static void main(String[] args) throws IOException {
        int n = readInt();a=new int[4];
        for(int abba=0;abba<n;abba++){
            
            a[0]=readInt();a[1]=readInt();a[2]=readInt();a[3]=readInt();
            max=0;
            Arrays.sort(a);
            do{
                recur(1,a[0],a[1]);
            }while(next_permutation(a,0,3));
            System.out.println(max);
        }
    }static boolean next_permutation(int a[],int L,int R){
            if(L==R)return false;
            int p = R-1,q=R;
            while(p>=L && a[p]>=a[p+1])p--;
            if(p<L)return false;
            while(a[q]<=a[p])q--;
            int tmp = a[p];a[p]=a[q];a[q]=tmp;
            for(int i=p+1,j=R;i<j;i++,j--){
                tmp=a[i];a[i]=a[j];a[j]=tmp;
            }return true;
        }static void recur(int c,int cur,int next){
            if(c==3){
                if(cur+next<=24)max=Math.max(max,cur+next);
                if(cur-next<=24)max=Math.max(max,cur-next);
                if(cur*next<=24)max=Math.max(max,cur*next);
                if(next>0&&cur%next==0&&cur/next<=24)max=Math.max(max,cur/next);
            }else{
                recur(c+1,cur+next,a[c+1]);
                recur(c+1,cur-next,a[c+1]);
                recur(c+1,cur*next,a[c+1]);
                if(next>0&&cur%next==0)recur(c+1,cur/next,a[c+1]);
                recur(c+1,cur,next+a[c+1]);
                recur(c+1,cur,next-a[c+1]);
                recur(c+1,cur,next-a[c+1]);
                if(next%a[c+1]==0)recur(c+1,cur,next/a[c+1]);
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
