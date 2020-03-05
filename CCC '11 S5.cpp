//very annoying as space constraints are low
#include <bits/stdc++.h>

using namespace std;
typedef pair<int,int>pii;
const int MM = 1e7;
int K,start,mask,mask2,cur,idx;
bool dp[4*MM];
queue<pii>q;
    
        int main(){
          scanf("%d",&K);
           
           
           for(int i=0,n;i<K;i++){
               scanf("%d",&n);
               if(n==1)start|=(1<<i);
           }
           
           dp[start]=1;
           
           q.push(make_pair(start,0));
           while(!q.empty()){
             pii temp = q.front();
               mask = temp.first;
               q.pop();
               
               if(mask==0){
                 printf("%d\n",temp.second);
                 return 0;
               }
               for(int i=0;i<K;i++){
                   if(!(mask&(1<<i))){
                       
                       mask2=mask|(1<<i);cur=0;idx=-1;
                    
                       for(int j=0;j<K;j++){
                           for(int k = j;k<K;k++){
                               if((mask2&(1<<k))==0)break;
                               if(k-j+1>cur){
                                   cur=k-j+1;
                                   idx = j;
                               }
                           }
                       }if(cur>=4){
                        for(int j = idx;j<idx+cur;j++){
                           mask2-=(1<<j);
                        }   
                       }
                       
                       if(!dp[mask2]){
                           dp[mask2]=1;
                           q.push(make_pair(mask2,temp.second+1));
                       }
                   }
               }
           }
        }
        





