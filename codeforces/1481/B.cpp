
// Problem: B. New Colony
// Contest: Codeforces - Codeforces Round #699 (Div. 2)
// URL: https://codeforces.com/contest/1481/problem/B
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    int arr[n];
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
    }
    if (m > 1e4) {
      cout << -1 << endl;
      continue;
    }
    int lind = -1;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n - 1; j++) {
        if (arr[j] < arr[j + 1]) {
          arr[j]++;
          lind = j + 1;
          break;
        }
        lind = -1;
      }
    }
    cout << lind << endl;
  }
}