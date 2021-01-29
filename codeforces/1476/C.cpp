
// Problem: C. Longest Simple Cycle
// Contest: Codeforces - Educational Codeforces Round 103 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1476/problem/C
// Memory Limit: 256 MB
// Time Limit: 2000 ms
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
    int n;
    cin >> n;
    bool breaking[n];
    memset(breaking, 0, sizeof breaking);
    ll len[n];
    for (int i = 0; i < n; i++) {
      cin >> len[i];
    }
    ll up[n];
    for (int i = 0; i < n; i++) {
      cin >> up[i];
    }
    ll down[n];
    for (int j = 0; j < n; j++) {
      cin >> down[j];
      if (down[j] < up[j]) swap(down[j], up[j]);
      if (down[j] == up[j]) breaking[j] = 1;
    }
    ll cumu = 0;
    ll mx = 0;
    for (int i = 0; i < n - 1; i++) {
      if (breaking[i + 1]) cumu = 0;
      cumu += 2;
      if (i && i < n - 1 && !breaking[i + 1]) {
        cumu += len[i] - down[i + 1];
        cumu += up[i + 1] - 1;
      }
      if (cumu < down[i + 1] - up[i + 1] + 2) {
        cumu = down[i + 1] - up[i + 1] + 2;
      }
      if (i < n - 1) mx = max(mx, cumu + len[i + 1] - 1);
    }
    cout << mx << endl;
  }
}