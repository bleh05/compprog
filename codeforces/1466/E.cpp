
// Problem: E. Apollo versus Pan
// Contest: Codeforces - Good Bye 2020
// URL: https://codeforces.com/contest/1466/problem/E
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int mod = 1e9 + 7;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    int bfrq[62];
    memset(bfrq, 0, sizeof bfrq);
    ll arr[n];
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
      for (int j = 0; j <= 61; j++) {
        bfrq[j] += (arr[i] & (1ll << j)) > 0;
      }
    }
    ll tsum = 0;
    for (int i = 0; i < n; i++) {
      ll sand = 0;
      ll sor = 0;
      for (int j = 0; j <= 61; j++) {
        if (arr[i] & (1ll << j)) {
          sand += (1ll << j) % mod * bfrq[j] % mod;
          if (sand > mod) sand -= mod;
          sor += (1ll << j) % mod * n % mod;
          if (sor > mod) sor -= mod;
        } else {
          sor += (1ll << j) % mod * bfrq[j] % mod;
          if (sor > mod) sor -= mod;
        }
      }
      tsum = tsum + sand * sor;
      tsum %= mod;
    }
    cout << tsum << endl;
  }
}