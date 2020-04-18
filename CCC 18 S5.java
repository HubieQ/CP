import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class test2 {
    public static class Edge implements Comparable<Edge>{
            int a,b,d,f;
            Edge(int aa,int ba,int da,int fa){
                a=aa;
                b=ba;
                d=da;
                f=fa;
            }public int compareTo(Edge e){
               return d-e.d;
            }
        
    }public static class Pair implements Comparable<Pair>{
        int a, b;
        Pair(int a0,int b0){
            a=a0;
            b=b0;
        }public int compareTo(Pair e){
            return e.b-b;
        }
    }
        
    
    static int r[],c[];
        public static void main (String[] args)throws IOException{
          int N = readInt(),M = readInt(),P=readInt(),Q = readInt();long tot = 0,ans = 0;
          ArrayList<Edge>e = new ArrayList<>();
          for(int i=0;i<P;i++){
              int a = readInt(),b = readInt(),d = readInt();
              tot+=(long)N*d;
              e.add(new Edge(a,b,d,0));
          }for(int i=0;i<Q;i++){
              int a = readInt(),b = readInt(),d = readInt();
              tot+=(long)M*d;
              e.add(new Edge(a,b,d,1));
          }Collections.sort(e);
          r = new int[N+1];c = new int[M+1];
          for(int i=0;i<=N;i++)r[i]=i;
          for(int i=0;i<=M;i++)c[i]=i;
          int cntR = N,cntC = M;
          for(Edge x:e){
            if(x.f==0){
              int pa = find(x.a,c),pb = find(x.b,c);
              if(pa!=pb){
                  c[pa]=pb;
                  ans+=(long)cntR*x.d;
                  cntC--;
              }
            }else{
              int pa = find(x.a,r),pb = find(x.b,r);
              if(pa!=pb){
                  r[pa]=pb;
                  ans+=(long)cntC*x.d;
                  cntR--;
              }
            }if(cntR==1&&cntC==1)break;
          }System.out.println(tot-ans);
           
        }public static int find(int u,int p[]){
            if(u!=p[u])return p[u] = find(p[u],p);
            else return u;
        }
        

    
        
        
	final private static int BUFFER_SIZE = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BUFFER_SIZE];
	private static int bufferPointer = 0, bytesRead = 0;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        /*static boolean next_permutation(int a[],int L,int R){
            if(L==R)return false;
            int p = R-1,q=R;
            while(p>=L && a[p]>=a[p+1])p--;
            if(p<L)return false;
            while(a[q]<=a[p])q--;
            int tmp = a[p];a[p]=a[q];a[q]=tmp;
            for(int i=p+1,j=R;i<j;i++,j--){
                tmp=a[i];a[i]=a[j];a[j]=tmp;
            }return true;
        }*/
	public static String readLine() throws IOException {
		byte[] buf = new byte[64]; // line length
		int cnt = 0, c;
		while ((c = Read()) != -1) {
			if (c == '\n')
				break;
			buf[cnt++] = (byte) c;
		}
		return new String(buf, 0, cnt);
	}
	public static String read() throws IOException{
		byte[] ret = new byte[1024];
        int idx = 0;
        byte c = Read();
        while (c <= ' ') {
            c = Read();
        }
        do {
            ret[idx++] = c;
            c = Read();
        } while (c != -1 && c != ' ' && c != '\n' && c != '\r');
        return new String(ret, 0, idx);
	}
	public static int readInt() throws IOException {
		int ret = 0;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = Read()) >= '0' && c <= '9');

		if (neg)
			return -ret;
		return ret;
	}

	public static long readLong() throws IOException {
		long ret = 0;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = Read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}

	public static double readDouble() throws IOException {
		double ret = 0, div = 1;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();

		do {
			ret = ret * 10 + c - '0';
		} while ((c = Read()) >= '0' && c <= '9');

		if (c == '.') {
			while ((c = Read()) >= '0' && c <= '9') {
				ret += (c - '0') / (div *= 10);
			}
		}

		if (neg)
			return -ret;
		return ret;
	}

	private static void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1)
			buffer[0] = -1;
	}

	private static byte Read() throws IOException {
		if (bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}

	public void close() throws IOException {
		if (din == null)
			return;
		din.close();
	}

	static void print(Object o) {
		pr.print(o);
	}

	static void println(Object o) {
		pr.println(o);
	}

	static void flush() {
		pr.flush();
	}

	static void println() {
		pr.println();
	}

	static void exit() throws IOException {
		din.close();
		pr.close();
		System.exit(0);
	}
}
