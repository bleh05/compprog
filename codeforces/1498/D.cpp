
// Problem: D. Bananas in a Microwave
// Contest: Codeforces - CodeCraft-21 and Codeforces Round #711 (Div. 2)
// URL: https://codeforces.com/contest/1498/problem/D
// Memory Limit: 256 MB
// Time Limit: 3000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m;
  cin >> n >> m;
  int ans[m + 1][2];
  for (int i = 0; i <= m; i++) ans[i][0] = -1, ans[i][1] = 100000000;
  ans[0][0] = 0;
  ans[0][1] = 0;
  for (int i = 1; i <= n; i++) {
    ll a, b, c;
    cin >> a >> b >> c;
    for (int j = 0; j <= m; j++) {
      if (a == 1) {
        if (ans[j][0] == -1 || ans[j][0] == i && ans[j][1] == c) continue;
        ll nind = j + (b + 99999) / 100000;
        if (nind > m || ans[nind][0] >= 0 && ans[nind][0] < i ||
            ans[nind][1] < ans[j][1] + 1)
          continue;
        if (ans[j][0] != i)
          ans[nind][0] = i, ans[nind][1] = 1;
        else if (ans[j][0] == i && ans[j][1] < c)
          ans[nind][0] = i, ans[nind][1] = min(ans[nind][1], ans[j][1] + 1);
      } else if (a == 2) {
        if (ans[j][0] == -1 || ans[j][0] == i && ans[j][1] == c) continue;
        ll nind = (j * b + 99999) / 100000;
        if (nind > m || ans[nind][0] >= 0 && ans[nind][0] < i ||
            ans[nind][1] < ans[j][1] + 1)
          continue;
        if (ans[j][0] != i)
          ans[nind][0] = i, ans[nind][1] = 1;
        else if (ans[j][0] == i && ans[j][1] < c)
          ans[nind][0] = i, ans[nind][1] = min(ans[nind][1], ans[j][1] + 1);
      }
    }
  }
  for (int i = 1; i <= m; i++) {
    cout << ans[i][0] << " ";
  }
  cout << "\n";
}