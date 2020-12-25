
// Problem: C. Berpizza
// Contest: Codeforces - 2020-2021 ICPC, NERC, Southern and Volga Russian
// Regional Contest (Online Mirror, ICPC Rules) URL:
// https://codeforces.com/contest/1468/problem/C Memory Limit: 512 MB Time
// Limit: 5000 ms Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int mxn = 5e5 + 2;
pair<int, int> segt1[mxn * 4];
int segt2[mxn * 4];
void update(int v, int tl, int tr, int ind, int val) {
  if (tl == tr && tl == ind) {
    segt1[v] = {val, -ind};
    segt2[v] = ind;
  } else if (tr < tl || tr < ind || tl > ind) {
    return;
  } else {
    int tm = (tl + tr) >> 1;
    update(v * 2, tl, tm, ind, val);
    update(v * 2 + 1, tm + 1, tr, ind, val);
    segt1[v] = max(segt1[v * 2], segt1[v * 2 + 1]);
    segt2[v] = min(segt2[v * 2], segt2[v * 2 + 1]);
  }
}
void reset(int v, int tl, int tr, int ind) {
  if (tl == tr && tl == ind) {
    segt1[v] = {-1, -1};
    segt2[v] = 843956839;
  } else if (tr < tl || tr < ind || tl > ind) {
    return;
  } else {
    int tm = (tl + tr) >> 1l;
    reset(v * 2, tl, tm, ind);
    reset(v * 2 + 1, tm + 1, tr, ind);
    segt1[v] = max(segt1[v * 2], segt1[v * 2 + 1]);
    segt2[v] = min(segt2[v * 2], segt2[v * 2 + 1]);
  }
}
int minInd() {
  int ret;
  reset(1, 0, mxn - 1, ret = segt2[1]);
  return ret;
}
int minVal() {
  int ret;
  reset(1, 0, mxn - 1, ret = -segt1[1].second);
  return ret;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int q;
  cin >> q;
  int ptr = 1;
  memset(segt2, 0x3f, sizeof segt2);
  for (int i = 0; i < q; i++) {
    int t;
    cin >> t;
    if (t == 1) {
      int d;
      cin >> d;
      update(1, 0, mxn - 1, ptr++, d);
    } else if (t == 2) {
      cout << minInd() << " ";
    } else {
      cout << minVal() << " ";
    }
  }
  cout << endl;
}