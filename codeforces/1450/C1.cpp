
// Problem: C2. Errich-Tac-Toe (Hard Version)
// Contest: Codeforces - Codeforces Global Round 12
// URL: https://codeforces.com/contest/1450/problem/C2
// Memory Limit: 256 MB
// Time Limit: 1000 ms
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
    int n;
    cin >> n;
    char arr[n][n];
    int c[3];
    c[0] = 0; c[1] = 0; c[2] = 0;
    for (int i = 0; i < n; i++) {
      string str;
      cin >> str;
      for (int j = 0; j < n; j++) {
        arr[i][j] = str[j];
        if (arr[i][j] != '.') c[(i + j) % 3]++;
      }
    }
    int ind = 0;
    if (c[1] <= c[0] && c[1] <= c[2]) {
      ind = 1;
    }
    if (c[2] <= c[0] && c[2] <= c[1]) {
      ind = 2;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if ((i + j) % 3 == ind && arr[i][j] != '.') {
          arr[i][j] = 'O';
        }
        cout << arr[i][j];
      }
      cout << endl;
    }
  }
}