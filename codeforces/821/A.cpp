
// Problem: A. Okabe and Future Gadget Laboratory
// Contest: Codeforces - Codeforces Round #420 (Div. 2)
// URL: https://codeforces.com/contest/821/problem/A
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  int arr[n][n];
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      cin >> arr[i][j];
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (arr[i][j] == 1) continue;
      bool ok = 0;
      for (int k = 0; k < n; k++) {
        for (int m = 0; m < n; m++) {
          if (arr[i][k] + arr[m][j] == arr[i][j]) ok = 1;
        }
      }
      if (!ok) {
        cout << "No" << endl;
        exit(0);
      }
    }
  }
  cout << "Yes" << endl;
}