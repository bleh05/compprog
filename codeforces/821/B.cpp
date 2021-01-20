
// Problem: B. Okabe and Banana Trees
// Contest: Codeforces - Codeforces Round #420 (Div. 2)
// URL: https://codeforces.com/contest/821/problem/B
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m;
  cin >> n >> m;
  ll mx = 0;
  ll x = 0;
  for (ll i = m; i >= 0; i--) {
    ll c = (x + 1) * (x) / 2;
    ll d = (i + 1) * (i) / 2;
    mx = max(c * (i + 1) + d * (x + 1), mx);
    x += n;
  }
  cout << mx << endl;
}