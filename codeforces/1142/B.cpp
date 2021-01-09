
// Problem: B. Lynyrd Skynyrd
// Contest: Codeforces - Codeforces Round #549 (Div. 1)
// URL: https://codeforces.com/contest/1142/problem/B
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int mxn = 2e5 + 2;
int segt[mxn * 4];
int maxx[mxn];
set<pair<int, int>> s[mxn];
void build(int v, int tl, int tr) {
  if (tl == tr)
    segt[v] = maxx[tl];
  else {
    int tm = (tl + tr) >> 1;
    build(v * 2, tl, tm);
    build(v * 2 + 1, tm + 1, tr);
    segt[v] = max(segt[v * 2], segt[v * 2 + 1]);
  }
}
int qu(int v, int tl, int tr, int l, int r) {
  if (tl > r || l > r || tr < l)
    return -1;
  else if (tl >= l && tr <= r)
    return segt[v];
  else {
    int tm = (tl + tr) >> 1;
    return max(qu(v * 2, tl, tm, l, r), qu(v * 2 + 1, tm + 1, tr, l, r));
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m, q;
  cin >> n >> m >> q;
  int arr1[n];
  for (int i = 0; i < n; i++) {
    cin >> arr1[i];
  }
  int prev[n + 1];
  for (int i = 0; i < n; i++) {
    prev[arr1[i]] = arr1[(i - 1 + n) % n];
  }
  int arr2[m + 1];
  int bldp[m + 1][20];
  memset(bldp, 0, sizeof bldp);
  int last[n + 2];
  memset(last, 0, sizeof last);
  for (int i = 1; i <= m; i++) {
    cin >> arr2[i];
    bldp[i][0] = last[prev[arr2[i]]];
    for (int j = 1; j < 20; j++) {
      bldp[i][j] = bldp[bldp[i][j - 1]][j - 1];
    }
    last[arr2[i]] = i;
  }
  memset(maxx, 0xff, sizeof maxx);
  for (int i = n - 2; i <= m; i++) {
    int dist = n;
    int c = i;
    for (int j = 19; j >= 0; j--) {
      if ((1 << j) < dist) {
        dist -= (1 << j);
        c = bldp[c][j];
      }
    }
    maxx[i] = c;
  }
  build(1, 1, m);
  for (int i = 0; i < q; i++) {
    int l, r;
    cin >> l >> r;
    int mind = qu(1, 1, m, l, r);
    if (mind >= l)
      cout << 1;
    else
      cout << 0;
  }
  cout << "\n";
}