
// Problem: B - Reversible Cards
// Contest: AtCoder - AtCoder Regular Contest 111
// URL: https://atcoder.jp/contests/arc111/tasks/arc111_b
// Memory Limit: 1024 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
vector<int> g[400002];
int vis[400002];
pair<int, int> dfs1(int u, int v) {
  if (vis[u]) return {0, 0};
  vis[u] = true;
  int res1 = 1;
  int res2 = g[u].size();
  for (int x : g[u]) {
    if (x == v || x == u) continue;
    auto c = dfs1(x, u);
    res1 += c.first;
    res2 += c.second;
  }
  return {res1, res2};
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int a, b;
    cin >> a >> b;
    g[a].push_back(b);
    g[b].push_back(a);
  }
  int sum = 0;
  for (int i = 0; i < 400002; i++) {
    if (g[i].size() && vis[i] == 0) {
      auto c = dfs1(i, 0);
      if (c.second / 2 < c.first) {
        sum--;
      }
      sum += c.first;
    }
  }

  cout << sum << endl;
}