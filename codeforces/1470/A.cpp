
// Problem: A. Strange Birthday Party
// Contest: Codeforces - Codeforces Round #694 (Div. 1)
// URL: https://codeforces.com/contest/1470/problem/0
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
    int n, m;
    cin >> n >> m;
    int arr[n];
    int arr2[m];
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
      arr[i]--;
    }
    for (int i = 0; i < m; i++) {
      cin >> arr2[i];
    }
    sort(arr, arr + n);
    reverse(arr, arr + n);
    ll sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr2[arr[i]];
    }
    int frq[n];
    int d = n;
    int k = n - 1;
    ll mn = sum;
    for (int i = 0; i < m; i++) {
      if (k == arr[i])
        d--;
      else if (d - 1 >= arr[i]) {
        k = arr[i];
        d = arr[i];
      } else {
        d--;
      }
      if (d < 0) break;
      sum -= arr2[arr[i]];
      sum += arr2[i];
      mn = min(sum, mn);
    }
    cout << mn << endl;
  }
}