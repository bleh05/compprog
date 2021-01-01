
// Problem: D - Teleporter
// Contest: AtCoder - AtCoder Grand Contest 004
// URL: https://atcoder.jp/contests/agc004/tasks/agc004_d
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int ans = 0;
int k;
vector<int> g[100002];
int dfs(int u, int p) {
  int d = 0;
  for (int x : g[u]) {
    if (x == p || x == 1) continue;
    d = max(dfs(x, u) + 1, d);
  }
  if (u != 1 && p != 1 && d >= k - 1) {
    ans++;
  }
  return d >= k - 1 ? -1 : d;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n >> k;
  int arr[n + 1];
  for (int i = 1; i <= n; i++) {
    cin >> arr[i];
  }
  if (arr[1] != 1) {
    ans++;
    arr[1] = 1;
  }
  for (int i = 2; i <= n; i++) {
    g[arr[i]].push_back(i);
    g[i].push_back(arr[i]);
  }
  dfs(1, 0);
  cout << ans << endl;
}