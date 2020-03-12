import java.util.*;
 public class Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
        public static class Edge implements Comparable<Edge>{
            int a,b,d;
            Edge(int aa,int ba,int da){
                a=aa;
                b=ba;
                d=da;
            }public int compareTo(Edge e){
               return d-e.d;
            }
        }static ArrayList<Edge>edges;
        static int ds[],M;
        
    public static void main(String[] args) throws IOException {
      M = readInt();Edge[][]e = new Edge[2000][2000];
      for(int i=0;i<M;i++){
          int q = readInt();
          int v[]=new int[q],w[]=new int[q];
          for(int j=0;j<q;j++)v[j]=readInt();
          for(int j=0;j<q;j++)w[j]=readInt();
          for(int j=0;j<q;j++){
              int a = v[j],b = v[(j+1)%q];
              if(e[a][b]!=null){
                  if(w[j]<e[a][b].d){
                      e[a][b].d=w[j];
                      e[b][a].d=w[j];
                  }e[a][b].b=i;
                   e[b][a].b=i;
              }else{
                  e[a][b]= new Edge(i,M,w[j]);
                  e[b][a]= new Edge(i,M,w[j]); 
              }
              
          }
      } edges = new ArrayList<>();
          for(int i=0;i<2000;i++){
              for(int j=0;j<2000;j++){
                  
                  if(e[i][j]!=null){
                      e[j][i]=null;
                      edges.add(e[i][j]);
                  }
              }
          }
          Collections.sort(edges);
          ds = new int[M+1];
          for(int i=1;i<=M;i++)ds[i]=i;
          System.out.println(mst());
       
    }public static int mst(){
        int w =0;
        for(Edge e: edges){
            int a = find_set(e.a),b= find_set(e.b);
            if(a!=b){
                ds[a]=b;
                w+=e.d;
            }
        }
        return w;
    }public static int find_set(int d){
        if(d!=ds[d])return ds[d]=find_set(ds[d]);
        else return d;
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
