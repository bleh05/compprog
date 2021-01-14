
// Problem: D. Program
// Contest: Codeforces - Educational Codeforces Round 102 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1473/problem/D
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int mxn = 2e5 + 2;
int segtMin[mxn * 4];
int segtMax[mxn * 4];
int psum[mxn];
void build(int v, int tl, int tr) {
  if (tl == tr) {
    segtMin[v] = psum[tl];
    segtMax[v] = psum[tl];
  } else {
    int tm = (tl + tr) >> 1;
    build(v * 2, tl, tm);
    build(v * 2 + 1, tm + 1, tr);
    segtMin[v] = min(segtMin[2 * v], segtMin[2 * v + 1]);
    segtMax[v] = max(segtMax[2 * v], segtMax[2 * v + 1]);
  }
}
int qMin(int v, int tl, int tr, int l, int r) {
  if (l > r || tl > r || tr < l)
    return 1 << 20;
  else if (tl >= l && tr <= r) {
    return segtMin[v];
  } else {
    int tm = (tl + tr) >> 1;
    return min(qMin(v * 2, tl, tm, l, r), qMin(v * 2 + 1, tm + 1, tr, l, r));
  }
}
int qMax(int v, int tl, int tr, int l, int r) {
  if (l > r || tl > r || tr < l)
    return -1 * (1 << 20);
  else if (tl >= l && tr <= r) {
    return segtMax[v];
  } else {
    int tm = (tl + tr) >> 1;
    return max(qMax(v * 2, tl, tm, l, r), qMax(v * 2 + 1, tm + 1, tr, l, r));
  }
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n, q;
    cin >> n >> q;
    string str;
    cin >> str;
    for (int i = 0; i < n; i++) {
      psum[i + 1] = 0;
      if (str[i] == '+')
        psum[i + 1]++;
      else
        psum[i + 1]--;
      if (i) psum[i + 1] += psum[i];
    }
    build(1, 1, n);
    for (int i = 0; i < q; i++) {
      int l, r;
      cin >> l >> r;
      int min1 = qMin(1, 1, n, 0, l - 1);
      if (min1 > 1000000) min1 = 0;
      int max1 = qMax(1, 1, n, 0, l - 1);
      if (max1 < 0) max1 = 0;
      int min2 = qMin(1, 1, n, r + 1, n) - psum[r] + psum[l - 1];
      if (min2 > 1000000) min2 = 0;
      int max2 = qMax(1, 1, n, r + 1, n) - psum[r] + psum[l - 1];
      if (max2 < 0) max2 = 0;
      max1 = max(max1, max2);
      min1 = min(min1, min2);
      min1 = min(min1, 0);
      // cout << min1 << " " << max1 << " " << i << endl;
      cout << max1 - min1 + 1 << "\n";
    }
  }
}