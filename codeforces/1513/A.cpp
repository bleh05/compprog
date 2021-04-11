
// Problem: A. Array and Peaks
// Contest: Codeforces - Divide by Zero 2021 and Codeforces Round #714 (Div. 2)
// URL: https://codeforces.com/contest/1513/problem/0
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
    int n, k;
    cin >> n >> k;
    int arr[n];
    memset(arr, 0, sizeof arr);
    if (k * 2 + 1 > n) {
      cout << -1 << endl;
      continue;
    }
    int d = n;
    for (int i = 0; i < k; i++) {
      int c = 1 + 2 * i;
      arr[c] = d--;
    }
    for (int i = 0; i < n; i++) {
      if (arr[i] == 0) arr[i] = d--;
    }
    for (int x : arr) cout << x << " ";
    cout << "\n";
  }
}