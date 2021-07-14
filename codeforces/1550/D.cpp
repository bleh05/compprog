
// Problem: D. Excellent Arrays
// Contest: Codeforces - Educational Codeforces Round 111 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1550/problem/D
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll mod = (int)1e9 + 7;
ll prec[200002];
ll inv[200002];
ll nCr(int n, int m) { return prec[n] * inv[n - m] % mod * inv[m] % mod; }
ll powr(ll a, ll b) {
  ll ans = 1;
  while (b) {
    if (b & 1) ans = ans * a % mod;
    a = a * a % mod;
    b >>= 1;
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  prec[1] = 1;
  prec[0] = 1;
  for (int i = 2; i < 200002; i++) prec[i] = prec[i - 1] * i % mod;
  for (int i = 0; i < 200002; i++) inv[i] = powr(prec[i], mod - 2);
  while (t--) {
    int n, l, r;
    cin >> n >> l >> r;
    ll ans = 0;
    ll free = min(1 - l, r - n);
    ans += free * nCr(n, n / 2);
    if (n % 2) ans *= 2;
    ans %= mod;
    int cadd = min(1 - l, r - n);
    int cchs = n / 2;
    int cfree = n;
    while (true) {
      cadd++;
      if (n + cadd > r) cfree--;
      if (1 - cadd < l) cfree--;
      if (n + cadd > r && 1 - cadd < l) cchs--;
      if (cfree < 0 || cchs < 0 || cfree < cchs) break;
      ans += nCr(cfree, cchs);
      if (n % 2 == 1) ans += nCr(cfree, cchs + 1);
      ans %= mod;
    }
    cout << ans << endl;
  }
}