
// Problem: F - Range Set Query
// Contest: AtCoder - AtCoder Beginner Contest 174
// URL: https://atcoder.jp/contests/abc174/tasks/abc174_f
// Memory Limit: 1024 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
struct query {
  int l, r, i;
};
int mapd[500003];
int sqrtsz;
bool comp(query a, query b) {
  if (a.l / sqrtsz == b.l / sqrtsz) {
    return a.r < b.r;
  }
  return a.l / sqrtsz < b.l / sqrtsz;
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m;
  cin >> n >> m;
  query q[m];
  int arr[n];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  for (int i = 0; i < m; i++) {
    int l, r;
    cin >> l >> r;
    l--;
    r--;
    q[i] = {l, r, i};
  }
  sqrtsz = (int)sqrt(n);
  int tl = 0;
  int tr = -1;
  sort(q, q + m, comp);
  int ans[m];
  int cnt = 0;
  for (int i = 0; i < m; i++) {
    while (tr < q[i].r) {
      tr++;
      if (mapd[arr[tr]] == 0) {
        cnt++;
      }
      mapd[arr[tr]]++;
    }
    while (q[i].l < tl) {
      tl--;
      if (mapd[arr[tl]] == 0) {
        cnt++;
      }
      mapd[arr[tl]]++;
    }
    while (tr > q[i].r) {
      if (mapd[arr[tr]] == 1) {
        cnt--;
      }
      mapd[arr[tr]]--;
      tr--;
    }
    while (q[i].l > tl) {
      if (mapd[arr[tl]] == 1) {
        cnt--;
      }
      mapd[arr[tl]]--;
      tl++;
    }
    ans[q[i].i] = cnt;
  }
  for (int x : ans) {
    cout << x << "\n";
  }
}