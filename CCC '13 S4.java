import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class test3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
        static ArrayList<Integer>graph[];
  
    public static void main(String[] args) throws IOException {
            
           int students =readInt();int n = readInt();
     graph = new ArrayList[students+1];
     for(int i=1;i<=students;i++)graph[i]=new ArrayList<>();
     for(int i=0;i<n;i++){
     graph[readInt()].add(readInt());
     }
     
     int P =readInt(),Q=readInt();
     if(bfs(P,Q)){
         System.out.println("yes");
     }else if(bfs(Q,P)){
         System.out.println("no");
     }else{
     
         System.out.println("unknown");
     }
        }public static boolean bfs(int P,int Q){
          Queue<Integer>q = new LinkedList<>();
          boolean visited[]=new boolean[1000001];
          q.add(P);visited[P]=true;
          while(!q.isEmpty()){
         int temp = q.poll();
         for(int i=0;i<graph[temp].size();i++){
             
             if(!visited[graph[temp].get(i)]){
             visited[graph[temp].get(i)]=true;
             q.add(graph[temp].get(i));
             }
         }if(visited[Q])return true;
     }return false;
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
