
// Problem: D. AB Graph
// Contest: Codeforces - Codeforces Round #699 (Div. 2)
// URL: https://codeforces.com/contest/1481/problem/D
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
    char arr[n][n];
    for (int i = 0; i < n; i++) {
      string str;
      cin >> str;
      for (int j = 0; j < n; j++) {
        arr[i][j] = str[j];
      }
    }
    if (m & 1) {
      cout << "YES\n";
      for (int i = 0; i <= m; i++) {
        cout << (i & 1) + 1 << " ";
      }
      cout << "\n";
      continue;
    }
    bool ans = false;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (arr[i][j] == arr[j][i] && i != j) {
          cout << "YES\n";
          for (int k = 0; k < m; k += 2) {
            cout << i + 1 << " " << j + 1 << " ";
          }
          cout << i + 1;
          cout << "\n";
          ans = true;
          i = j = n;
        }
      }
    }
    if (!ans)
      for (int i = 0; i < n; i++) {
        int l1 = 0;
        int l2 = 0;
        for (int j = 0; j < n; j++) {
          if (arr[i][j] == 'a' && arr[j][i] == 'b' && j != i)
            l1 = j + 1;
          else if (j != i)
            l2 = j + 1;
        }
        if (l1 == 0 || l2 == 0) {
          continue;
        }
        cout << "YES\n";
        if (m % 4 == 2) {
          cout << l2 << " " << i + 1 << " ";
        } else {
          cout << i + 1 << " ";
        }
        for (int j = 0; j < m - m % 4; j += 4) {
          cout << l1 << " " << i + 1 << " " << l2 << " " << i + 1 << " ";
        }
        if (m % 4 == 2) {
          cout << l1 << " ";
        }
        cout << "\n";
        ans = true;
        i = n;
      }
    if (!ans) cout << "NO\n";
  }
}