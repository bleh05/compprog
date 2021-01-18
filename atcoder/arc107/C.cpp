
// Problem: C - Shuffle Permutation
// Contest: AtCoder - AtCoder Regular Contest 107
// URL: https://atcoder.jp/contests/arc107/tasks/arc107_c
// Memory Limit: 1024 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int vis[104];
vector<int> g[104];
int dfs(int v) {
  if (vis[v]) return 0;
  int sum = 1;
  vis[v] = 1;
  for (int x : g[v]) {
    sum += dfs(x);
  }
  return sum;
}
ll fact[52];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, K;
  cin >> n >> K;
  int mat[n][n];
  for (int i = 0; i < 52; i++) {
    fact[i] = max(1ll, fact[i - 1] * i) % 998244353;
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      cin >> mat[i][j];
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
      for (int k = 0; k < n; k++) {
        if (mat[i][k] + mat[j][k] > K) break;
        if (k == n - 1) {
          g[i].push_back(j), g[j].push_back(i);
        }
      }
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
      for (int k = 0; k < n; k++) {
        if (mat[k][i] + mat[k][j] > K) break;
        if (k == n - 1) {
          g[i + 50].push_back(j + 50);
          g[j + 50].push_back(i + 50);
        }
      }
    }
  }
  ll prod = 1;
  for (int i = 0; i < 104; i++) {
    prod *= fact[dfs(i)];
    prod %= 998244353;
  }
  cout << prod << endl;
}