#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int grid[101][101];
int dp[101][101][101][101];

int sum(int x1, int y1, int x2, int y2) {
  if (x1 > x2) return 0;
  if (y1 > y2) return 0;
  return grid[x2][y2] - grid[x1 - 1][y2] - grid[x2][y1 - 1] +
         grid[x1 - 1][y1 - 1];
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m;
  cin >> n >> m;
  int sx, sy;
  for (int i = 1; i <= n; i++) {
    string str;
    cin >> str;
    for (int j = 1; j <= m; j++) {
      grid[i][j] = str[j - 1] == 'o';
      if (str[j - 1] == 'E') sx = i, sy = j;
      grid[i][j] =
          grid[i][j] + grid[i - 1][j] + grid[i][j - 1] - grid[i - 1][j - 1];
    }
  }
  int ans = 0;
  for (int i = 0; i < sx; i++) {
    for (int j = 0; j < sy; j++) {
      for (int k = 0; k <= n - sx; k++) {
        for (int l = 0; l <= m - sy; l++) {
          ans = max(dp[i][j][k][l], ans);
          if (k < sx - i - 1)
            dp[i + 1][j][k][l] =
                max(dp[i + 1][j][k][l],
                    dp[i][j][k][l] + sum(sx - i - 1, max(sy - j, l + 1),
                                         sx - i - 1, min(sy + l, m - j)));
          if (l < sy - j - 1)
            dp[i][j + 1][k][l] =
                max(dp[i][j + 1][k][l],
                    dp[i][j][k][l] + sum(max(sx - i, k + 1), sy - j - 1,
                                         min(sx + k, n - i), sy - j - 1));
          if (sx + i + 1 < n + 1 - k)
            dp[i][j][k + 1][l] =
                max(dp[i][j][k + 1][l],
                    dp[i][j][k][l] + sum(sx + k + 1, max(sy - j, l + 1),
                                         sx + k + 1, min(sy + l, m - j)));
          if (sy + j + 1 < m + 1 - l)
            dp[i][j][k][l + 1] =
                max(dp[i][j][k][l + 1],
                    dp[i][j][k][l] + sum(max(sx - i, k + 1), sy + l + 1,
                                         min(sx + k, n - i), sy + l + 1));
        }
      }
    }
  }
  cout << ans << endl;
}