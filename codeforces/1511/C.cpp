
// Problem: C. Yet Another Card Deck
// Contest: Codeforces - Educational Codeforces Round 107 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1511/problem/C
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int pos[51];
  memset(pos, 0x3f, sizeof pos);
  int n, q;
  cin >> n >> q;
  for (int i = 0; i < n; i++) {
    int d;
    cin >> d;
    if (pos[d] > n) pos[d] = i;
  }
  for (int i = 0; i < q; i++) {
    int r = 0;
    cin >> r;
    int ans = pos[r];
    for (int j = 0; j <= 50; j++) {
      if (pos[j] < ans) pos[j]++;
    }
    pos[r] = 0;
    cout << ans + 1 << " ";
  }
  cout << "\n";
}