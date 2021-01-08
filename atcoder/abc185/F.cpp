
// Problem: F - Range Xor Query
// Contest: AtCoder - AtCoder Beginner Contest 185
// URL: https://atcoder.jp/contests/abc185/tasks/abc185_f
// Memory Limit: 1024 MB
// Time Limit: 3000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int mxn = 3e5 + 2;
int segt[mxn * 4];
int arr[mxn];
void build(int v, int tl, int tr) {
  if (tl == tr)
    segt[v] = arr[tl];
  else {
    int tm = (tl + tr) >> 1;
    build(v * 2, tl, tm);
    build(v * 2 + 1, tm + 1, tr);
    segt[v] = segt[v * 2] ^ segt[v * 2 + 1];
  }
}

void update(int v, int tl, int tr, int ind, int val) {
  if (tl > tr || tr < ind || tl > ind)
    return;
  else if (tl == tr && tl == ind) {
    segt[v] ^= val;
  } else {
    int tm = (tl + tr) >> 1;
    update(v * 2, tl, tm, ind, val);
    update(v * 2 + 1, tm + 1, tr, ind, val);
    segt[v] = segt[v * 2] ^ segt[v * 2 + 1];
  }
}

int xos(int v, int tl, int tr, int l, int r) {
  if (tl > tr || tr < l || tl > r)
    return 0;
  else if (l <= tl && tr <= r) {
    return segt[v];
  } else {
    int tm = (tl + tr) >> 1;
    return xos(v * 2, tl, tm, l, r) ^ xos(v * 2 + 1, tm + 1, tr, l, r);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, q;
  cin >> n >> q;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  build(1, 0, n - 1);
  for (int i = 0; i < q; i++) {
    int t, x, y;
    cin >> t >> x >> y;
    if (t == 1)
      update(1, 0, n - 1, x - 1, y);
    else
      cout << xos(1, 0, n - 1, x - 1, y - 1) << "\n";
  }
}