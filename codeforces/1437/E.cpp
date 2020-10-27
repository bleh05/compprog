
// Problem: E. Make It Increasing
// Contest: Codeforces - Educational Codeforces Round 97 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1437/problem/E
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int lis(vector<int>& a) {
  for (int i = 0; i < a.size(); i++) a[i] -= i;
  int n = a.size();
  const int INF = 2.1e9;
  vector<int> d(n + 1, INF);
  d[0] = -INF;

  for (int i = 0; i < n; i++) {
    int j = upper_bound(d.begin(), d.end(), a[i]) - d.begin();
    if (d[j - 1] <= a[i] && a[i] <= d[j]) d[j] = a[i];
  }

  int ans = 0;
  for (int i = 0; i <= n; i++) {
    if (d[i] < INF) ans = i;
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m;
  cin >> n >> m;
  int arr[n];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  int ill[m + 1];
  for (int j = 1; j <= m; j++) {
    cin >> ill[j];
    ill[j]--;
  }
  ill[0] = -1;
  for (int i = 2; i <= m; i++) {
    if (arr[ill[i]] < arr[ill[i - 1]] + ill[i] - ill[i - 1]) {
      cout << -1 << endl;
      exit(0);
    }
  }
  if (m == 0) {
    vector<int> v = {};
    for (int x : arr) {
      v.push_back(x);
    }
    cout << n - lis(v) << endl;
    exit(0);
  }
  int ptr = 0;
  if (0 == ill[0]) ptr++;
  for (int j = 0; j <= m; j++) {
    int ax = 0;
    vector<int> v = {};
    if (j == m) {
      for (int i = 0; i < n - ill[j]; i++) {
        v.push_back(arr[ill[j]] - n + ill[j] + i + 1);
      }
      for (int i = ill[j] + 1; i < n; i++) {
        v.push_back(arr[i]);
      }
      for (int i = 0; i < n - ill[j]; i++) {
        v.push_back(2e9 + i);
      }
      int c = lis(v) - (n - ill[j]) * 2;
      ptr += c;
    } else {
      if (j == 0) {
        for (int i = 0; i < ill[j + 1] - ill[j]; i++) {
          v.push_back(-2e9 + i);
        }
      } else {
        for (int i = 0; i < ill[j + 1] - ill[j]; i++) {
          v.push_back(arr[ill[j]] - (ill[j + 1] - ill[j] - i) + 1);
        }
      }
      for (int i = ill[j] + 1; i < ill[j + 1]; i++) {
        v.push_back(arr[i]);
      }
      for (int i = 0; i < ill[j + 1] - ill[j]; i++) {
        v.push_back(arr[ill[j + 1]] + i);
      }
      int c = lis(v) - (ill[j + 1] - ill[j]) * 2;
      ptr += c;
    }
  }
  cout << n - m - ptr << endl;
}