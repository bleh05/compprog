
// Problem : D. Rescue Nibel!
// Contest : Codeforces - Codeforces Round #672 (Div. 2)
// URL : https://codeforces.com/contest/1420/problem/D
// Memory Limit : 256 MB
// Time Limit : 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int mx = 3e5+4;
int n;
int k;
priority_queue<int, vector<int>, greater<int>> pq = {};
int mod = 998244353;
ll fact[mx];
ll inv[mx];
ll bpw(ll a, ll b) {
	ll res = 1;
	while(b > 0) {
		if(b & 1) res = res * a % mod;
		a = a * a % mod;
		b >>= 1;
	}
	return res;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
	cin >> n;
	cin >> k;
	fact[0] = 1;
	inv[0] = 1;
	for(int i = 1; i < mx; i++) {
		fact[i] = fact[i - 1] * i % mod;
		inv[i] = bpw(fact[i], mod - 2);
	}
	for(int i = 0; i < n; i++) {
		int l, r;
		cin >> l >> r;
		pq.push(l * 2);
		pq.push(r * 2 + 1);
	}
	if(k == 1) {
		cout << n;
		return 0;
	}
	int curr = 0;
	ll sum = 0;
	for(int i = 0; i < 2 * n; i++) {
		int c = pq.top(); pq.pop();
		if(c % 2) {
			curr--;
		}
		else {
			if(curr >= k - 1) {
				sum += fact[curr] * inv[k - 1] % mod * inv[curr - k + 1] % mod;
				sum %= mod;
			}
			curr++;
		}
	}
	cout << sum << endl;
}