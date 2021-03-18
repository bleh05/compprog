
// Problem: A. Domino on Windowsill
// Contest: Codeforces - Educational Codeforces Round 106 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1499/problem/0
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
    int n, k1, k2, w, b;
    cin >> n >> k1 >> k2 >> w >> b;
    if (min(k1, k2) + (max(k1, k2) - min(k1, k2)) / 2 < w)
      cout << "NO\n";
    else if (min(n - k1, n - k2) +
                 (max(n - k1, n - k2) - min(n - k1, n - k2)) / 2 <
             b)
      cout << "NO\n";
    else
      cout << "YES\n";
  }
}