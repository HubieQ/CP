import java.io.*;
import java.util.*;
 
 public class Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
      

  public static void main (String[] args)throws IOException
  {
   int n = readInt();Pair[]p = new Pair[1001];
   for(int i=0;i<1001;i++){
       p[i]=new Pair(i,0);
   }for(int i=0;i<n;i++){
       p[readInt()].d++;
   }Arrays.sort(p);
   
   int max = p[1000].a,max2=p[999].d,id=Math.abs(max-p[999].a);
   
        for(int i=999;i>=0;i--){
            if(max2!=p[i].d)break;
            else id = Math.max(id,max-p[i].a);
        } 
   
   System.out.println(id);
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
