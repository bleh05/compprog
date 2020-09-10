
// Problem : E. Strange Calculation and Cats
// Contest : Codeforces - Codeforces Round #329 (Div. 2)
// URL : https://codeforces.com/contest/593/problem/E
// Memory Limit : 256 MB
// Time Limit : 4000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int mxn = 20;
int adjl[20][20];
ll res[20][20];
ll ansm[20][20];
ll prod[20][20];
int n, m, k;
int mod = 1e9+7;

struct event {
	int ty, x, y, time, ind;
};

bool compare(event a, event b) {
	return a.time == b.time ? a.ty < b.ty : a.time < b.time;
}

void mul(ll a[][mxn], ll b[][mxn]) {
	memset(res, 0, sizeof res);
	for(int i = 0; i < n * m; i++) {
		for(int j = 0; j < n * m; j++) {
			for(int k = 0; k < n * m; k++) {
				res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % mod;
			}
		}
	}
}
void mult(ll a[][mxn], int t) {
	memset(prod, 0, sizeof prod);
	for(int i = 0; i < n * m; i++) {
		prod[i][i] = 1;
	}
	while(t > 0) {
		if((t & 1) == 0) {
			mul(a, a);
			for(int i = 0; i < n*m; i++) {
				for(int j = 0; j < n*m; j++) {
					a[i][j] = res[i][j];
				}
			}
			t >>= 1;
		}
		else {
			mul(prod, a);
			for(int i = 0; i < n*m; i++) {
				for(int j = 0; j < n*m; j++) {
					prod[i][j] = res[i][j];
				}
			}
			t--;
		}
	}
}

event evnts[10001];
int main() {
	cin >> n >> m >> k;
	int red = 0;
	for(int i = 0; i < k; i++) {
		int ty, x, y, time;
		cin >> ty >> x >> y >> time;
		if(ty == 1) red++;
		evnts[i] = {ty, x-1, y-1, time, red-1};
	}
	int c[n][m];
	int r = 0;
	for(int i = 0; i < n; i++) {
		for(int j = 0; j < m; j++) {
			c[i][j] = r++;
		}
	}
	int dx[5] = {-1, 1, 0, 0, 0};
	int dy[5] = {0, 0, -1, 1, 0};
	for(int i = 0; i < n; i++) {
		for(int j = 0; j < m; j++) {
			for(int d = 0; d < 5; d++) {
				if(i + dx[d] >= 0 && i + dx[d] < n && j + dy[d] >= 0 && j + dy[d] < m) {
					adjl[c[i][j]][c[i+dx[d]][j+dy[d]]]++;
				}
			}
		}
	}
	ll ans[red];
	for(int i = 0; i < n * m; i++) {
		ansm[i][i] = 1;
	}
	int lasttime = 1;
	bool free[20];
	for(int i = 0; i < 20; i++) {
		free[i] = 1;
	}
	for(int i = 0; i < k; i++) {
		event ev = evnts[i];
		if(ev.ty == 1) {
			ll cpy[mxn][mxn];
			for(int i = 0; i < n*m; i++) {
				for(int j = 0; j < n*m; j++) {
					cpy[i][j] = adjl[i][j];
				}
			}
			mult(cpy, ev.time - lasttime);
			for(int i = 0; i < n*m; i++) {
				for(int j = 0; j < n*m; j++) {
					cpy[i][j] = res[i][j];
				}
			}
			mul(ansm, cpy);
			for(int i = 0; i < n*m; i++) {
				for(int j = 0; j < n*m; j++) {
					ansm[i][j] = res[i][j];
				}
			}
			ans[ev.ind] = ansm[0][c[ev.x][ev.y]];
			lasttime = ev.time;
		}
		else if(ev.ty == 3) {
			ll cpy[mxn][mxn];
			for(int i = 0; i < n*m; i++) {
				for(int j = 0; j < n*m; j++) {
					cpy[i][j] = adjl[i][j];
				}
			}
			mult(cpy, ev.time - lasttime);
			for(int i = 0; i < n*m; i++) {
				for(int j = 0; j < n*m; j++) {
					cpy[i][j] = res[i][j];
				}
			}
			mul(ansm, cpy);
			for(int i = 0; i < n*m; i++) {
				for(int j = 0; j < n*m; j++) {
					ansm[i][j] = res[i][j];
				}
			}
			free[c[ev.x][ev.y]] = true;
			for(int d = 0; d < 5; d++) {
				if(ev.x + dx[d] >= 0 && ev.x + dx[d] < n && ev.y + dy[d] >= 0 && ev.y + dy[d] < m) {
					if(free[c[ev.x+dx[d]][ev.y+dy[d]]]) {
						adjl[c[ev.x][ev.y]][c[ev.x+dx[d]][ev.y+dy[d]]]=1;
						adjl[c[ev.x+dx[d]][ev.y+dy[d]]][c[ev.x][ev.y]]=1;
					}
				}
			}
			lasttime = ev.time;
		}
		else {
			ll cpy[mxn][mxn];
			for(int i = 0; i < n*m; i++) {
				for(int j = 0; j < n*m; j++) {
					cpy[i][j] = adjl[i][j];
				}
			}
			mult(cpy, ev.time - lasttime);
			for(int i = 0; i < n*m; i++) {
				for(int j = 0; j < n*m; j++) {
					cpy[i][j] = res[i][j];
				}
			}
			mul(ansm, cpy);
			for(int i = 0; i < n*m; i++) {
				for(int j = 0; j < n*m; j++) {
					ansm[i][j] = res[i][j];
				}
			}
			free[c[ev.x][ev.y]] = false;
			for(int d = 0; d < 5; d++) {
				if(ev.x + dx[d] >= 0 && ev.x + dx[d] < n && ev.y + dy[d] >= 0 && ev.y + dy[d] < m) {
					adjl[c[ev.x][ev.y]][c[ev.x+dx[d]][ev.y+dy[d]]]=0;
					adjl[c[ev.x+dx[d]][ev.y+dy[d]]][c[ev.x][ev.y]]=0;
				}
			}
			lasttime = ev.time;
		}
	}
	
	for(int i = 0; i < red; i++) {
		cout << ans[i] << endl;
	}
}