
// Problem: A. Exciting Bets
// Contest: Codeforces - Codeforces Round #730 (Div. 2)
// URL: https://codeforces.com/contest/1543/problem/0
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    ll x, y;
    cin >> x >> y;
    if (x == y)
      cout << "0 0" << endl;
    else
      cout << abs(x - y) << " "
           << min(abs(x - y) - x % abs(x - y), x % abs(x - y)) << endl;
  }
}