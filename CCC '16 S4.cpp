#include <bits/stdc++.h>
using namespace std;
int n,a[401],dp[401][401],ans;

int main() {
  scanf("%d",&n);
  for(int i=1;i<=n;i++){
    scanf("%d",&a[i]);
    dp[i][i]=a[i];
    ans=max(a[i],ans);
    a[i]+=a[i-1];  
  }for(int x=1;x<n;x++){
    for(int i=1;i+x<=n;i++){
      int lft = i,rit = i+x,j=i+x;
      while(lft<rit){
        if(dp[i][lft]&&dp[rit][j]&&dp[i][lft]==dp[rit][j]){

          if(lft+1==rit)dp[i][j]=max(dp[i][j],dp[i][lft]+dp[rit][j]);

          if(lft+1<=rit-1&&dp[lft+1][rit-1])
          dp[i][j]=max(dp[i][j],dp[i][lft]+dp[lft+1][rit-1]+dp[rit][j]);

          ans=max(ans,dp[i][j]);
        }
      if(a[lft]-a[i-1]==a[j]-a[rit-1]){
        lft++;
        rit--;
      }else if(a[lft]-a[i-1]>a[j]-a[rit-1])
        rit--;
      else lft++;
      }
      
    }
  }printf("%d\n",ans);
  
}
