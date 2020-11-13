
// Problem: B. Valerii Against Everyone
// Contest: Codeforces - Codeforces Round #682 (Div. 2)
// URL: https://codeforces.com/contest/1438/problem/B
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll bpow(ll a, ll b, ll m) {
  int res = 1;
  while (b) {
    if (b & 1) res = res * a % m;
    a = a * a % m;
    b >>= 1;
  }
  return res;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  int mod = 1e9 + 7;
  int mod2 = 1e9 + 9;
  while (t--) {
    int n;
    cin >> n;
    int a1[n];
    for (int i = 0; i < n; i++) {
      cin >> a1[i];
    }
    sort(a1, a1 + n);
    for (int i = 0; i < n - 1; i++) {
      if (a1[i] == a1[i + 1]) {
        cout << "YES" << endl;
        break;
      }
      if (i == n - 2) {
        cout << "NO" << endl;
      }
    }
  }
}