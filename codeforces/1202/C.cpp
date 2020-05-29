#include <bits/stdc++.h>
using namespace std;
using pii=pair<int,int>;
set<pii> A,B;
char b[201010];
int main(){
	int T;scanf("%d",&T);
	while(T--){
		A.clear();B.clear();
		int x=0,y=0;
		scanf("%s",b);
		int n=strlen(b);
		A.insert({x,0});
		B.insert({y,0});
		for(int i=0;i<n;i++){
			if(b[i]=='W')y++;
			else if(b[i]=='S')y--;
			else if(b[i]=='A')x++;
			else x--;
			A.insert({x,i+1});
			B.insert({y,i+1});
		}		
		long long ans=1LL*(prev(A.end())->first-A.begin()->first+1)*(prev(B.end())->first-B.begin()->first+1);
		x=0,y=0;
		int mx=0,Mx=0,my=0,My=0;
		for(int i=0;i<n;i++){
			int a=A.begin()->first,b=prev(A.end())->first,c=B.begin()->first,d=prev(B.end())->first;
			ans=min(ans,1LL*(max(Mx,b+1)-min(mx,a+1)+1)*(max(My,d)-min(my,c)+1));
			ans=min(ans,1LL*(max(Mx,b-1)-min(mx,a-1)+1)*(max(My,d)-min(my,c)+1));
			ans=min(ans,1LL*(max(Mx,b)-min(mx,a)+1)*(max(My,d+1)-min(my,c+1)+1));
			ans=min(ans,1LL*(max(Mx,b)-min(mx,a)+1)*(max(My,d-1)-min(my,c-1)+1));
			A.erase({x,i});
			B.erase({y,i});
			if(::b[i]=='W')y++;
			else if(::b[i]=='S')y--;
			else if(::b[i]=='A')x++;
			else x--;
			Mx=max(Mx,x);
			mx=min(mx,x);
			My=max(My,y);
			my=min(my,y);
		}
		printf("%lld\n",ans);
	}
}