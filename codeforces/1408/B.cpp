
// Problem : B. Arrays Sum
// Contest : Codeforces - Grakn Forces 2020
// URL : https://codeforces.com/contest/1408/problem/B
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
		int n, k;
		cin >> n >> k;
		set<int> s = {};
		for(int i = 0; i < n; i++) {
			int d;
			cin >> d;
			s.insert(d);
		}
		int r = s.size();
		if(k == 1 && r > 1) cout << -1 << endl;
		else if(r == 1) cout << 1 << endl;
		else cout << (r + k - 3) / (k - 1) << endl;
	}
}