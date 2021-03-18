
// Problem: D. The Number of Pairs
// Contest: Codeforces - Educational Codeforces Round 106 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1499/problem/D
// Memory Limit: 512 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int sieve[20000001];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  for (int i = 2; i < 20000001; i++) {
    if (sieve[i] == 0) {
      sieve[i] = 1;
      for (int j = i + i; j < 20000001; j += i) {
        sieve[j]++;
      }
    }
  }
  int t;
  cin >> t;
  while (t--) {
    int c, d, x;
    cin >> c >> d >> x;
    ll sum = 0;
    int mx = 0;
    for (ll i = 1; i * i <= x; i++) {
      if (x % i == 0) {
        if ((x + d * i) % (c * i) == 0) {
          int nfac = sieve[(x + d * i) / c / i];
          sum += (1 << nfac);
        }
        if (i * i != x && (i + d) % (c) == 0) {
          int nfac = sieve[(i + d) / c];
          sum += (1 << nfac);
        }
      }
    }
    cout << sum << endl;
  }
}