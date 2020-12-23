
// Problem: C - Shorten Diameter
// Contest: AtCoder - AtCoder Grand Contest 001
// URL: https://atcoder.jp/contests/agc001/tasks/agc001_c
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 2003;
vector<int> g[N];
int dfs(int v, int p, int m) {
  int sum = m < 0;
  for (int x : g[v]) {
    if (x != p) {
      sum += dfs(x, v, m - 1);
    }
  }
  return sum;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n - 1; i++) {
    int a, b;
    cin >> a >> b;
    g[a].push_back(b);
    g[b].push_back(a);
  }
  int mn = 100000;
  if (m % 2) {
    for (int i = 0; i < n; i++) {
      for (int x : g[i]) {
        int sum = 0;
        sum += dfs(x, i, m / 2);
        sum += dfs(i, x, m / 2);
        mn = min(sum, mn);
      }
    }
  } else {
    for (int i = 1; i <= n; i++) {
      int sum = 0;
      sum += dfs(i, -1, m / 2);
      mn = min(sum, mn);
    }
  }
  cout << mn << endl;
}