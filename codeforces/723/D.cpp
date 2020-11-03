
// Problem: D. Lakes in Berland
// Contest: Codeforces - Codeforces Round #375 (Div. 2)
// URL: https://codeforces.com/contest/723/problem/D
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int n, m, k;
bool grid[52][52];
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};
bool vis[52][52];
int ff(int x, int y) {
  if (x < 0 || x >= n || y < 0 || y >= m || !grid[x][y] || vis[x][y]) {
    return 0;
  }
  if (x == 0 || x == n - 1 || y == 0 || y == m - 1) {
    return -800000;
  }
  vis[x][y] = true;
  int sum = 1;
  for (int i = 0; i < 4; i++) {
    int nx = x + dx[i];
    int ny = y + dy[i];
    sum += ff(nx, ny);
  }
  return sum;
}
void ff2(int x, int y) {
  if (x < 0 || x >= n || y < 0 || y >= m || !grid[x][y]) {
    return;
  }
  grid[x][y] = false;
  for (int i = 0; i < 4; i++) {
    int nx = x + dx[i];
    int ny = y + dy[i];
    ff2(nx, ny);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n >> m >> k;
  for (int i = 0; i < n; i++) {
    string str;
    cin >> str;
    for (int j = 0; j < m; j++) {
      grid[i][j] = str[j] == '.';
    }
  }
  vector<tuple<int, int, int>> v = {};
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      int d = ff(i, j);
      if (d > 0) {
        v.push_back({d, i, j});
      }
    }
  }
  sort(v.begin(), v.end());
  int sum = 0;
  for (int i = 0; i < v.size() - k; i++) {
    sum += get<0>(v[i]);
    ff2(get<1>(v[i]), get<2>(v[i]));
  }
  cout << sum << endl;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      cout << (grid[i][j] ? '.' : '*');
    }
    cout << endl;
  }
}