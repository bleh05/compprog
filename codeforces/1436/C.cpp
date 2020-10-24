
// Problem: C. Binary Search
// Contest: Codeforces - Codeforces Round #678 (Div. 2)
// URL: https://codeforces.com/contest/1436/problem/C
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

const int mod = 1e9 + 7;

ll bpow(ll a, ll b) {
  int res = 1;
  while (b) {
    if (b & 1) res = (res * a) % mod;
    a = (a * a) % mod;
    b >>= 1;
  }
  return res;
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m, p;
  cin >> n >> m >> p;
  int l = 0, r = n;
  int a1 = m - 1;
  int a2 = n - m;
  int a3 = n - 1;
  int k[n];
  int c = 0;
  int d = 0;
  int e = n - 1;
  memset(k, 0, sizeof k);
  while (l < r) {
    int mid = (l + r) / 2;
    if (mid > p) {
      r = mid;
      k[mid] = 1;
      if (mid != p) {
        d++;
        e--;
      }
    } else {
      l = mid + 1;
      k[mid] = 1;
      if (mid != p) {
        c++;
        e--;
      }
    }
  }
  ll prod = 1;
  ll fct[n + 1];
  fct[0] = 1;
  for (int i = 1; i <= n; i++) {
    fct[i] = fct[i - 1] * i % mod;
  }
  if (a1 < c || a2 < d) {
    cout << 0 << endl;
    exit(0);
  }
  prod *= fct[a1] * bpow(fct[a1 - c], mod - 2) % mod;
  prod %= mod;
  prod *= fct[a2] * bpow(fct[a2 - d], mod - 2) % mod;
  prod %= mod;
  prod *= fct[e];
  prod %= mod;
  cout << prod << endl;
}