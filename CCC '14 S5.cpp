#include <bits/stdc++.h>
using namespace std;
struct edge{int a,b,dis;};
bool cmp(edge e,edge ee){
  return e.dis<ee.dis;
}
typedef long long ll;
typedef pair<int,int> pii;
int N,dp[2011],dp2[2011],best[2011];
vector<int>x,y;
vector<edge>e;
int main(){
  ios_base::sync_with_stdio(0); cin.tie(0);cout.tie(0);
  cin>>N;
  for(int i = 0,a,b;i < N;i++){
    cin>>a>>b;
    x.push_back(a);
    y.push_back(b);
  }for(int i=0;i<N;i++){
    e.push_back(edge{N,i,x[i]*x[i]+y[i]*y[i]});
  }for(int i=0;i<N;i++){
    for(int j=i+1;j<N;j++){
      e.push_back(edge{i,j,(x[j]-x[i])*(x[j]-x[i])+(y[j]-y[i])*(y[j]-y[i])});
    }
  }sort(e.begin(),e.end(),cmp);
  for(int i=0;i<e.size();i++){
    edge edges = e[i];
    if(edges.dis>dp[edges.a]){
      dp[edges.a]=edges.dis;
      dp2[edges.a]=best[edges.a];
    }if(edges.dis>dp[edges.b]){
      dp[edges.b]=edges.dis;
      dp2[edges.b]=best[edges.b];
    }
      if(edges.a==N){
        best[N]=max(best[N],dp2[edges.b]);
      }else if(edges.b==N){
        best[N]=max(best[N],dp2[edges.a]);
      }else{
        best[edges.a]=max(best[edges.a],dp2[edges.b]+1);
        best[edges.b]=max(best[edges.b],dp2[edges.a]+1);
      }
    
  }cout<<best[N]+1<<'\n';
  
}
