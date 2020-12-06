
// Problem: B. Balls of Steel
// Contest: Codeforces - Codeforces Global Round 12
// URL: https://codeforces.com/contest/1450/problem/B
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 102;
vector<int> g[N];
int vis[N];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    int par[n][2];
    for (int i = 0; i < n; i++) {
      cin >> par[i][0] >> par[i][1];
    }
    for (int i = 0; i < n; i++) {
      g[i].clear();
    }
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (abs(par[i][0] - par[j][0]) + abs(par[i][1] - par[j][1]) <= m) {
          g[i].push_back(j);
          g[j].push_back(i);
        }
      }
    }
    int d = -1;
    for (int i = 0; i < n; i++) {
      memset(vis, 0, sizeof vis);
      if (g[i].size() == n - 1) {
        d = 1;
      }
    }
    cout << d << "\n";
  }
}