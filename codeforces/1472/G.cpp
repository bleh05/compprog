
// Problem: G. Moving to the Capital
// Contest: Codeforces - Codeforces Round #693 (Div. 3)
// URL: https://codeforces.com/contest/1472/problem/G
// Memory Limit: 256 MB
// Time Limit: 4000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

vector<int> g[200002];
vector<int> g2[200002];
int ans[200002][2];
int bfs[200002];
vector<pair<int, int>> vp;
void dfs(int v, int cannt, int val) {
  if (ans[v][cannt] <= val) return;
  ans[v][cannt] = val;
  if (cannt == 0) ans[v][1] = min(ans[v][1], val);
  for (int x : g2[v]) {
    if (bfs[x] >= bfs[v]) {
      if (cannt == 0) dfs(x, 1, val);
    } else {
      dfs(x, cannt, val);
    }
  }
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
      g[i].clear();
      g2[i].clear();
      bfs[i] = 1e9;
      ans[i][0] = ans[i][1] = 1e9;
    }
    for (int i = 0; i < m; i++) {
      int a, b;
      cin >> a >> b;
      g[a].push_back(b);
      g2[b].push_back(a);
    }
    queue<int> q;
    q.push(1);
    bfs[1] = 0;
    while (q.size()) {
      int t = q.front();
      q.pop();
      for (int x : g[t]) {
        if (bfs[x] > bfs[t] + 1) {
          bfs[x] = bfs[t] + 1;
          q.push(x);
        }
      }
    }
    vp.clear();
    for (int i = 1; i <= n; i++) {
      vp.push_back({bfs[i], i});
    }
    sort(vp.begin(), vp.end());
    for (int i = 0; i < n; i++) {
      dfs(vp[i].second, 0, vp[i].first);
    }
    for (int i = 1; i <= n; i++) {
      cout << min(min(ans[i][0], ans[i][1]), bfs[i]) << " ";
    }
    cout << endl;
  }
}