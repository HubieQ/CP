import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
Scanner input = new Scanner(System.in);
    int number = input.nextInt();
    int cases[]=new int [number];
    Stack<Integer>Lists = new Stack<>();
    Stack<Integer>Lists2 = new Stack<>();
    int results[]=new int [number];
   
    for(int z = 0;z<number;z++){
        int k =1;
        cases[z]=input.nextInt();
    for(int j =0;j<cases[z];j++){
        Lists.push(input.nextInt());   
    }
    while(!Lists.isEmpty()||!Lists2.isEmpty()){
        if(!Lists.isEmpty()){
     if(Lists.peek()==k){
         Lists.pop();
         k++;
         
     }else if(!Lists2.isEmpty() && Lists2.peek()==k){
         Lists2.pop();
         k++;
    }else{
         Lists2.push(Lists.peek());
         Lists.pop();
         }
        }
     if(Lists.isEmpty()){
          if(Lists2.isEmpty()){   
             results[z]=0;                   
         }else if (Lists2.peek()==k){
         Lists2.pop();
         k++;
         if(Lists2.isEmpty()){   
             results[z]=0;
         }
         }else if(!Lists2.isEmpty() && Lists2.peek()!=k){
         results[z]=1; 
         Lists2.clear();
         }    
         }
        }
     }
    

    for(int i = 0;i<number;i++){
        if(results[i]==0){
            System.out.println("Y");
        }else{
            System.out.println("N");
        }
    }
    }
}
