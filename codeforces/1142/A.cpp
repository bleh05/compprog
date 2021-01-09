
// Problem: A. The Beatles
// Contest: Codeforces - Codeforces Round #549 (Div. 1)
// URL: https://codeforces.com/contest/1142/problem/A
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

ll gcd(ll a, ll b) { return b == 0 ? a : gcd(b, a % b); }

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, k;
  int a, b;
  cin >> n >> k >> a >> b;
  ll mn = 1e11;
  ll mx = 0;
  for (ll i = 1; i <= n + 1; i++) {
    ll kdist1 = i * k + b - a;
    ll c = 1ll * n * k;
    mn = min(mn, c / gcd(kdist1, c));
    mx = max(mx, c / gcd(kdist1, c));
    ll kdist2 = (i + 1) * (k)-b - a;
    mn = min(mn, c / gcd(kdist2, c));
    mx = max(mx, c / gcd(kdist2, c));
  }
  cout << mn << " " << mx << endl;
}