
// Problem: A. Mean Inequality
// Contest: Codeforces - Codeforces Round #723 (Div. 2)
// URL: https://codeforces.com/contest/1526/problem/0
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
    int arr[2 * n];
    for (int i = 0; i < 2 * n; i++) cin >> arr[i];
    sort(arr, arr + 2 * n);
    for (int i = 0; i < n; i++)
      cout << arr[i] << " " << arr[2 * n - 1 - i] << " ";
    cout << "\n";
  }
}