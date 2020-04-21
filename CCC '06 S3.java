import java.io.*;
import java.util.*;
 
 public class Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
        public static class Pair implements Comparable<Pair>{
        int b,d;
        Pair(int b0,int d0){
            b=b0;
            d=d0;
        }public int compareTo(Pair e){
            if(d>e.d)return 1;
            else return -1;
        }
        }public static class Edge{
            int b,start,fin;
            Edge(int b0,int start0, int fin0){
                b=b0;
                start=start0;
                fin=fin0;
            }
        }
            
        public static void main (String[] args)throws IOException{
            int ax1=readInt(),ay1 = readInt(),ax2 = readInt(),ay2 = readInt(),cases = readInt(),count=0;
            
            for(int aaa = 0;aaa<cases;aaa++){
                int coordNum = readInt(),x[] = new int[coordNum+1],y[] = new int[coordNum+1];
                for(int i=0;i<coordNum;i++){x[i] = readInt();y[i] = readInt();}
                x[coordNum] = x[0];y[coordNum] = y[0];
                for(int i=0;i<coordNum;i++){
                    int bx1 = x[i],by1 = y[i],bx2 = x[i+1],by2 = y[i+1];
                    int numeratora = ay2-ay1,numeratorb = by2-by1;
                    int denominatora = ax1-ax2,denominatorb = bx1-bx2;
                    int ab = numeratora*ax1 +ay1*denominatora,bb = numeratorb*bx1+by1*denominatorb;
                    ab*=-1;bb*=-1;
                        if(numeratora*denominatorb==numeratorb*denominatora){
                            if(ab*denominatorb==bb*denominatora){
                                if(ax1<= bx1 && bx1 <=ax2 || ax2 <= bx1 && bx1 <= ax1 || ax1<= bx2 && bx2 <=ax2 || ax2 <= bx2 && bx2 <= ax1 ){
                                    count++;
                                    break;
                                }
                            }
                        }else{
                            double xx = (double)(denominatora*bb-denominatorb*ab)/(denominatorb*numeratora-denominatora*numeratorb);
                            double yy = (double)(numeratora*bb-numeratorb*ab)/(numeratorb*denominatora-numeratora*denominatorb);
                            if(1.0*ax1 <= xx && xx <= 1.0*ax2 || 1.0*ax2 <= xx && xx<= 1.0*ax1){
                                if(1.0*ay1<=yy && yy<=1.0*ay2 || 1.0*ay2 <= yy && yy<=1.0*ay1){
                                    if(1.0*bx1 <= xx && xx <=1.0*bx2 || 1.0*bx2 <= xx && xx<=1.0*bx1){
                                        if(1.0*by1<=yy && yy<=1.0*by2 || 1.0*by2 <= yy && yy<=1.0*by1){
                                            count++;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                }
            }System.out.println(count);
            
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
