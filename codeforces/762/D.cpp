#include<bits/stdc++.h>
#define ll long long
using namespace std;
ll n,a[3][200001],f[4][200001];
ll get(ll x,ll l,ll r){
ll i,sum=0;
if(l>r)swap(l,r);
for(i=l;i<=r;i++)sum+=a[i][x];
return sum;
}
int main(){
ll i,j,k;
scanf("%lld",&n);
for(i=0;i<3;i++)
for(j=1;j<=n;j++)scanf("%lld",&a[i][j]);
memset(f,192,sizeof(f));
f[0][0]=0;
for(j=1;j<=n;j++){
for(i=0;i<3;i++)
for(k=0;k<3;k++)f[i][j]=max(f[i][j],f[k][j-1]+get(j,i,k));
f[0][j]=max(f[0][j],f[3][j-1]+get(j,0,2));
f[2][j]=max(f[2][j],f[3][j-1]+get(j,0,2));
f[3][j]=max(f[3][j],max(f[0][j-1],f[2][j-1])+get(j,0,2));
}
printf("%lld",f[2][n]);
}