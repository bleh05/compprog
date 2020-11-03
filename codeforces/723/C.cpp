
// Problem: C. Polycarp at the Radio
// Contest: Codeforces - Codeforces Round #375 (Div. 2)
// URL: https://codeforces.com/contest/723/problem/C
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
  int nval = n / m;
  int needed[m + 1];
  for (int i = 1; i <= m; i++) {
    needed[i] = nval;
  }
  for (int i = 0; i < n; i++) {
    if (arr[i] <= m) {
      needed[arr[i]]--;
    }
  }
  int nc = 0;
  for (int i = 0; i < n; i++) {
    if (arr[i] > m || needed[arr[i]] < 0) {
      int c = -1;
      for (int j = 1; j <= m; j++) {
        if (needed[j] > 0) {
          c = j;
          break;
        }
      }
      if (c == -1) break;
      nc++;
      if (arr[i] <= m && needed[arr[i]] < 0) {
        needed[arr[i]]++;
      }
      arr[i] = c;
      needed[c]--;
    }
  }
  cout << nval << " " << nc << endl;
  for (int x : arr) {
    cout << x << " ";
  }
  cout << endl;
}