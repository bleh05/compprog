
// Problem: D. Max Median
// Contest: Codeforces - Codeforces Round #703 (Div. 2)
// URL: https://codeforces.com/contest/1486/problem/D
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m;
  cin >> n >> m;
  int arr[n];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  int l = 1, r = n;
  while (r - l > 1) {
    int mid = (l + r) >> 1;
    int pr = 0;
    int sum[n];
    int pre[n + 1];
    memset(sum, 0, sizeof sum);
    int isgood = 0;
    pre[0] = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] >= mid)
        sum[i] = 1;
      else
        sum[i] = -1;
      if (i) {
        sum[i] += sum[i - 1];
      }
      pre[i + 1] = min(sum[i], pre[i]);
      if (i >= m - 1) {
        if (pre[i - m + 1] < sum[i]) isgood = 1;
      }
    }
    if (isgood)
      l = mid;
    else
      r = mid - 1;
  }
  int isgood = 0;
  int pr = 0;
  int sum[n];
  int pre[n + 1];
  pre[0] = 0;
  for (int i = 0; i < n; i++) {
    if (arr[i] >= r)
      sum[i] = 1;
    else
      sum[i] = -1;
    if (i) {
      sum[i] += sum[i - 1];
    }
    pre[i + 1] = min(sum[i], pre[i]);
    if (i >= m - 1) {
      if (pre[i - m + 1] < sum[i]) isgood = 1;
    }
  }
  if (isgood)
    cout << r << endl;
  else
    cout << l << endl;
}