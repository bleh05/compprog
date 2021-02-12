
// Problem: D. Multiples and Power Differences
// Contest: Codeforces - Codeforces Round #701 (Div. 2)
// URL: https://codeforces.com/contest/1485/problem/D
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
  int arr[n][m];
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) cin >> arr[i][j];
  }
  int nc[n][m];
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      nc[i][j] = 720720;
      if ((i + j) & 1) {
        for (int k = 1; k < 30; k++) {
          int c = k * k * k * k;
          if ((720720 - c) % arr[i][j] == 0) {
            nc[i][j] -= c;
            break;
          }
        }
      }
      cout << nc[i][j] << " ";
    }
    cout << endl;
  }
}