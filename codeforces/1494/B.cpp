
// Problem: B. Berland Crossword
// Contest: Codeforces - Educational Codeforces Round 105 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1494/problem/B
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
bool solve(int n, int u, int r, int d, int l) {
  if (u < d) swap(u, d);
  if (r < l) swap(l, r);
  if (u == n) {
    r--;
    l--;
  }
  if (u == n - 1) {
    r--;
  }
  if (r < l) swap(l, r);
  if (r < 0 || l < 0) {
    return false;
  }
  if (d == n) {
    r--;
    l--;
  } else if (d == n - 1) {
    r--;
  }
  if (r < 0 || l < 0) {
    return false;
  }
  return true;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n, u, r, d, l;
    cin >> n >> u >> r >> d >> l;
    if (solve(n, u, r, d, l) && solve(n, r, u, l, d))
      cout << "YES" << endl;
    else
      cout << "NO\n";
  }
}