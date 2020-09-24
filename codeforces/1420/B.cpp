
// Problem : B. Rock and Lever
// Contest : Codeforces - Codeforces Round #672 (Div. 2)
// URL : https://codeforces.com/contest/1420/problem/B
// Memory Limit : 256 MB
// Time Limit : 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int frq[35];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t;
    cin >> t;
    while(t-- > 0) {
		int n;
		cin >> n;
		memset(frq, 0, sizeof frq);
		for(int i = 0; i < n; i++) {
			int k; cin >> k;
			for(int j = 30; j >= 0; j--) {
				if((1<<j) & k) {
					frq[j]++;
					break;
				}
			}
		}
		ll sum = 0;
		for(int x : frq) {
			sum += x * (x - 1ll) / 2;
		}
		cout << sum << "\n";
	}
}