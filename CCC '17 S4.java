import java.util.*;
import java.io.*;
public class Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
        
        public static int ds[],r[];
        public static Edge e[];
        public static int find(int x){
            if(ds[x]==x)return x;
            else return find(ds[x]);
        }
	public static void main(String[]args)throws IOException{    
            int n=readInt(),m=readInt(),d=readInt();e = new Edge[m];
            ds = new int[n+1];r=new int[n+1];
            for(int i=1;i<=n;i++){
                ds[i]=i;
            }for(int i=0;i<m;i++){
                int start = readInt(),fin=readInt(),c=readInt();
                if(i<n-1){
                    e[i]=new Edge(start,fin,c,0);
                }else{
                    e[i]=new Edge(start,fin,c,1);
                }
            }Arrays.sort(e);
            int days=0,curMST=0,maxCost=0,largeACT=0;
            for(Edge edge:e){
                if(curMST==n-1)break;
                int a=edge.a,b=edge.b,cost=edge.cost,using=edge.using,h1=find(a),h2=find(b);
                if(h1!=h2){
                     if(r[h1]>r[h2]){
                                ds[h2]=h1;
                            }else if(r[h2]>r[h1]){
                                ds[h1]=h2;
                            }else{
                                ds[h1]=h2;
                                r[h2]++;
                        }maxCost=cost;
                    days+=using;
                    largeACT=using;
                    curMST++;
                }
               
            }if(largeACT==1){
                for(int i=0;i<=n;i++)ds[i]=i;
                r=new int[n+1];
                for(Edge edge:e){
                    int a=edge.a,b=edge.b,cost=edge.cost,h1=find(a),h2=find(b);
                    if(h1!=h2){
                        if(cost<maxCost||cost==maxCost && edge.using==0){
                            if(r[h1]>r[h2]){
                                ds[h2]=h1;
                            }else if(r[h2]>r[h1]){
                                ds[h1]=h2;
                            }else{
                                ds[h1]=h2;
                                r[h2]++;
                        }
                    }else if(edge.using==0&&cost-d<=0){
                            System.out.println(days-1);
                            return;
                        }
                    }
                }
            }
          
            System.out.println(days);
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
        public static class Edge implements Comparable<Edge>{
            int a,b,cost,using;
            public Edge(int a,int b,int cost,int using){
                this.a=a;
                this.b=b;
                this.cost=cost;
                this.using=using;
            }public int compareTo(Edge e) {
                if(cost!=e.cost)return cost-e.cost;
                return using-e.using;
		}
        }
}
