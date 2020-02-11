import java.util.*;
import java.io.*;
public class test2 {

static int count;
static int g;
static int t;
	public static void main(String[] args) throws IOException {
            t = readInt();g=readInt();int score[][]=new int[5][g+1],a[]=new int[5];
            boolean [][]game = new boolean[5][5];
            count=0;
            for(int i=1;i<=g;i++){
                int o=readInt(),p=readInt(),q=readInt(),r=readInt();
                if(q>r)a[o]+=3;
                else if(q==r){
                    a[o]++;a[p]++;
                }else{
                    a[p]+=3;
                }game[o][p]=true;game[p][o]=true;
                
            }recur(a,game);
            System.out.println(count);
        }public static void recur(int a[],boolean[][]game){
            boolean aa=true;
            for(int i=1;i<5&&aa;i++){
                for(int j=1;j<5&&aa;j++){
                    if(i!=j&&!game[i][j]&&!game[j][i]){
                    game[i][j]=true;
                    game[j][i]=true;
                    a[i]+=3;
                    recur(a,game);
                    a[i]-=3;
                    a[j]+=3;
                    recur(a,game);
                    a[j]-=3;
                    a[i]++;a[j]++;
                    recur(a,game);
                    a[i]--;a[j]--;
                    game[i][j]=false;
                    game[j][i]=false;
                    aa=false;
                    }
                }
            }boolean all= true;
            for(int i=1;i<5&&all;i++){
                for(int j=1;j<5&&all;j++){
                    if(i!=j&&!game[i][j])all=false;
                }
            }if(all){
                boolean tt=true;
                for(int i=1;i<5;i++){
                    if(i!=t&&a[i]>=a[t])tt=false;
                }if(tt)count++;
            }
        }

        /*public static void rr(boolean[][]game,int score[][],int a[],int games){
            if(games<=g){
                if(!game[1][2]&&!game[2][1]){
                    game[1][2]=true;game[2][1]=true;
                    if(score[1][games]>score[2][games]){
                    a[1]+=3;
                    recur(game,score,a,games+1);
                    a[1]-=3;
                }else if(score[1][games]==score[2][games]){
                    a[1]++;a[2]--;
                    recur(game,score,a,games+1);
                    a[1]--;a[2]--;
                }else{
                    a[2]+=3;
                    recur(game,score,a,games+1);
                    a[2]-=3;    
                }game[1][2]=false;game[2][1]=false;
                }else if(!game[1][3]&&!game[3][1]){
                    game[1][3]=true;game[3][1]=true;
                    if(score[1][games]>score[3][games]){
                    a[1]+=3;
                    recur(game,score,a,games+1);
                    a[1]-=3;
                }else if(score[1][games]==score[3][games]){
                    a[1]++;a[3]--;
                    recur(game,score,a,games+1);
                    a[1]--;a[3]--;
                }else{
                       a[3]+=3;
                    recur(game,score,a,games+1);
                    a[3]-=3; 
                }game[1][3]=false;game[3][1]=false;
                }else if(!game[1][4]&&!game[4][1]){
                    game[1][4]=true;game[4][1]=true;
                    if(score[1][games]>score[4][games]){
                    a[1]+=3;
                    recur(game,score,a,games+1);
                    a[1]-=3;
                }
                    else if(score[4][games]==score[1][games]){
                    a[1]++;a[4]--;
                    recur(game,score,a,games+1);
                    a[1]--;a[4]--;
                }else{
                        a[4]+=3;
                    recur(game,score,a,games+1);
                    a[4]-=3;
                }game[1][4]=false;game[4][1]=false;
                }else if(!game[2][3]&&!game[3][2]){
                    game[2][3]=true;game[3][2]=true;
                    if(score[2][games]>score[3][games]){
                    a[2]+=3;
                    recur(game,score,a,games+1);
                    a[2]-=3;
                }else if(score[2][games]==score[3][games]){
                    a[2]++;a[3]--;
                    recur(game,score,a,games+1);
                    a[2]--;a[3]--;
                }else{
                       a[3]+=3;
                    recur(game,score,a,games+1);
                    a[3]-=3; 
                }game[2][3]=true;game[3][2]=true;
                }else if(!game[2][4]&&!game[4][2]){
                    game[2][4]=true;game[4][2]=true;
                    if(score[2][games]>score[4][games]){
                    a[2]+=3;
                    recur(game,score,a,games+1);
                    a[2]-=3;
                }else if(score[2][games]==score[4][games]){
                    a[2]++;a[4]--;
                    recur(game,score,a,games+1);
                    a[2]--;a[4]--;
                }else{
                       a[4]+=3;
                    recur(game,score,a,games+1);
                    a[4]-=3; 
                }game[2][4]=false;game[4][2]=false;
                }else if(!game[3][4]&&!game[4][3]){
                    game[3][4]=true;game[4][3]=true;
                    if(score[3][games]>score[4][games]){
                    a[3]+=3;
                    recur(game,score,a,games+1);
                    a[3]-=3;
                }else if(score[3][games]==score[4][games]){
                    a[3]++;a[4]--;
                    recur(game,score,a,games+1);
                    a[3]--;a[4]--;
                }else{
                    a[4]+=3;
                    recur(game,score,a,games+1);
                    a[4]-=3;
                }game[3][4]=false;game[4][3]=false;
                }
            }else if(games==6){
                boolean ans = true;
                for(int i=1;i<=4;i++){
                   if(i!=t&&a[i]>=a[t]){
                       ans = false;
                       break;
                   }
                }if(ans)count++;
            }else{
                if(!game[1][2]&&!game[2][1]){
                    game[1][2]=true;
                    game[2][1]=true;
                    a[1]+=3;
                    recur(game,score,a,games+1);
                    a[1]-=3;
                    a[2]+=3;
                    recur(game,score,a,games+1);
                    a[2]-=3;
                    a[1]++;a[2]++;
                    recur(game,score,a,games+1);
                    a[1]--;a[2]--;
                    game[1][2]=false;
                    game[1][2]=false;
                }else if(!game[1][3]&&!game[3][1]){
                    game[1][3]=true;
                    game[3][1]=true;
                    a[1]+=3;
                    recur(game,score,a,games+1);
                    a[1]-=3;
                    a[3]+=3;
                    recur(game,score,a,games+1);
                    a[3]-=3;
                    a[1]++;a[3]++;
                    recur(game,score,a,games+1);
                    a[1]--;a[3]--;
                    game[1][3]=false;
                    game[3][1]=false;
                }else if(!game[1][4]&&!game[4][1]){
                    game[1][4]=true;
                    game[4][1]=true;
                    a[1]+=3;
                    recur(game,score,a,games+1);
                    a[1]-=3;
                    a[4]+=3;
                    recur(game,score,a,games+1);
                    a[4]-=3;
                    a[1]++;a[4]++;
                    recur(game,score,a,games+1);
                    a[1]--;a[4]--;
                    game[1][4]=false;
                    game[4][1]=false;
                }else if(!game[2][3]&&!game[3][2]){
                    game[2][3]=true;
                    game[3][2]=true;
                    a[2]+=3;
                    recur(game,score,a,games+1);
                    a[2]-=3;
                    a[3]+=3;
                    recur(game,score,a,games+1);
                    a[3]-=3;
                    a[2]++;a[3]++;
                    recur(game,score,a,games+1);
                    a[2]--;a[3]--;
                    game[2][3]=false;
                    game[3][2]=false;
                }else if(!game[2][4]&&!game[4][2]){
                    game[2][4]=true;
                    game[4][2]=true;
                    a[2]+=3;
                    recur(game,score,a,games+1);
                    a[2]-=3;
                    a[4]+=3;
                    recur(game,score,a,games+1);
                    a[4]-=3;
                    a[2]++;a[4]++;
                    recur(game,score,a,games+1);
                    a[2]--;a[4]--;
                    game[2][4]=false;
                    game[4][2]=false;
                }else if(!game[3][4]&&!game[4][3]){
                    game[3][4]=true;
                    game[4][3]=true;
                    a[3]+=3;
                    recur(game,score,a,games+1);
                    a[3]-=3;
                    a[4]+=3;
                    recur(game,score,a,games+1);
                    a[4]-=3;
                    a[3]++;a[4]++;
                    recur(game,score,a,games+1);
                    a[3]--;a[4]--;
                    game[3][4]=false;
                    game[4][3]=false;
                }
            }*/
        
        
	final private static int BUFFER_SIZE = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BUFFER_SIZE];
	private static int bufferPointer = 0, bytesRead = 0;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        static boolean next_permutation(int a[],int L,int R){
            if(L==R)return false;
            int p = R-1,q=R;
            while(p>=L && a[p]>=a[p+1])p--;
            if(p<L)return false;
            while(a[q]<=a[p])q--;
            int tmp = a[p];a[p]=a[q];a[q]=tmp;
            for(int i=p+1,j=R;i<j;i++,j--){
                tmp=a[i];a[i]=a[j];a[j]=tmp;
            }return true;
        }
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
