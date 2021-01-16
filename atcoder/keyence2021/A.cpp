
// Problem: A - Two Sequences 2
// Contest: AtCoder - KEYENCE Programming Contest 2021
// URL: https://atcoder.jp/contests/keyence2021/tasks/keyence2021_a
// Memory Limit: 1024 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  ll a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  ll b[n];
  for (int i = 0; i < n; i++) {
    cin >> b[i];
  }
  ll pmax[n];
  memset(pmax, 0, sizeof pmax);
  for (int i = 0; i < n; i++) {
    pmax[i] = a[i];
    if (i) pmax[i] = max(pmax[i], pmax[i - 1]);
  }
  ll maxprod = 0;
  for (int i = 0; i < n; i++) {
    if (b[i] * pmax[i] > maxprod) {
      maxprod = b[i] * pmax[i];
    }
    cout << maxprod << endl;
  }
}