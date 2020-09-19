
// Problem : B. Stairs
// Contest : Codeforces - Codeforces Round #671 (Div. 2)
// URL : https://codeforces.com/contest/1419/problem/B
// Memory Limit : 256 MB
// Time Limit : 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
	int t;
	cin >> t;
	while(t-- > 0) {
		ll d;
		cin >> d;
		int ans = 0;
		ll curr = 1;
		while(d >= curr * (curr + 1) / 2) {
			d -= curr * (curr + 1) / 2;
			curr <<= 1;
			curr++;
			ans++;
		}
		cout << ans << endl;
	}
}