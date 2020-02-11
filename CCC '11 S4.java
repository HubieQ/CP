import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
        static int people[];
        static int avaliable[];
    public static void main(String[] args) throws IOException {
            people=new int[8];avaliable = new int[8];
            for(int i=0;i<8;i++)avaliable[i]=readInt();
            for(int i=0;i<8;i++)people[i]=readInt();
            int count =0;
            //O-
            count+=recur(0,0);
            //O+
            count+=recur(1,1);
            count+=recur(1,0);
            //A-
            count+=recur(2,2);
            count+=recur(2,0);
            //B-
            count+=recur(4,4);
            count+=recur(4,0);
            //A+
            count+=recur(3,3);
            count+=recur(3,2);
            count+=recur(3,1);
            count+=recur(3,0);
            //B+
            count+=recur(5,5);
            count+=recur(5,4);
            count+=recur(5,1);
            count+=recur(5,0);
            
            //AB-
            for(int i=6;i>=0;i-=2)count+=recur(6,i);
            //AB+
            for(int i=7;i>=0;i--)count+=recur(7,i);
            
            System.out.println(count);

            
            
            
        }public static int recur(int a,int b){
            int min = Math.min(people[a],avaliable[b]);
            people[a]-=min;
            avaliable[b]-=min;
            return min;
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
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
