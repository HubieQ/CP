#include <bits/stdc++.h>
using namespace std;
int n;long long t;string s;
int x[100001],y[100001];
int main() {
  cin.sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
  cin>>n>>t>>s;
  for(int i=0;i<n;i++)x[i]=s[i]-'0';
  for(int i=50;i>=0;i--){
    if((t>>i)&1){
      long long cur = (1LL<<i)%n;
      for(int j=0;j<n;j++){
        y[j]=x[(j+cur)%n]^x[(j-cur+n)%n];
      }memcpy(x,y,sizeof(x));
    }
  }for(int i=0;i<n;i++)cout<<x[i];
  printf("\n");

}
