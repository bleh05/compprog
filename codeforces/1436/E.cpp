
// Problem: E. Complicated Computations
// Contest: Codeforces - Codeforces Round #678 (Div. 2)
// URL: https://codeforces.com/contest/1436/problem/E
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

const int mx = 1e5 + 2;
int segt[mx * 4];
void update(int v, int tl, int tr, int i, int val) {
  if (i > tr || i < tl)
    return;
  else if (tr == tl && tr == i) {
    segt[v] = val;
  } else {
    int tm = (tl + tr) >> 1;
    update(v * 2, tl, tm, i, val);
    update(v * 2 + 1, tm + 1, tr, i, val);
    segt[v] = min(segt[v * 2], segt[v * 2 + 1]);
  }
}
int findFS(int v, int tl, int tr, int val) {
  if (tl == tr) {
    return tl;
  }
  int tm = (tl + tr) >> 1;
  if (segt[v * 2] < val) {
    return findFS(v * 2, tl, tm, val);
  } else {
    return findFS(v * 2 + 1, tm + 1, tr, val);
  }
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  memset(segt, -1, sizeof segt);
  int n;
  cin >> n;
  int arr[n];
  vector<int> qs[n + 1];
  for (int i = 0; i <= n; i++) {
    qs[i].push_back(-1);
  }
  int has[n + 4];
  memset(has, 0, sizeof has);
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    arr[i]--;
    if (arr[i] != 0) has[0]++;
  }
  if (arr[0] == 0)
    has[1] = 1;
  else
    has[0] = 1;
  for (int i = 0; i < n; i++) {
    update(1, 0, n, arr[i], i);
    if (i < n - 1) {
      qs[arr[i + 1]].push_back(i + 1);
      if (i == 0 || i > 0 && arr[i] != arr[i - 1]) {
        int l = qs[arr[i + 1]][qs[arr[i + 1]].size() - 2];
        has[findFS(1, 0, n, l + 1)] = 1;
      }
    }
    if (i == 0) {
      qs[arr[i]].push_back(i);
      if (i < n - 1) {
        qs[arr[i + 1]].push_back(i + 1);
      }
    }
  }
  for (int i = 0; i <= n; i++) {
    int l = qs[i][qs[i].size() - 1];
    if (l == n - 1) continue;
    has[findFS(1, 0, n, l + 1)] = 1;
  }
  for (int i = 0; i <= n; i++) {
    if (has[i] == 0) {
      cout << i + 1 << endl;
      exit(0);
    }
  }
  cout << n + 2 << endl;
}