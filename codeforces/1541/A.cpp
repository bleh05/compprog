
// Problem: A. Pretty Permutations
// Contest: Codeforces - Codeforces Round #728 (Div. 2)
// URL: https://codeforces.com/contest/1541/problem/0
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
    int arr[n];
    for (int i = 0; i < n; i++) {
      arr[i] = i + 1;
    }
    if (n % 2) {
      for (int i = 0; i < n - 3; i += 2) {
        swap(arr[i], arr[i + 1]);
      }
      swap(arr[n - 3], arr[n - 1]);
      swap(arr[n - 1], arr[n - 2]);
    } else {
      for (int i = 0; i < n; i += 2) {
        swap(arr[i], arr[i + 1]);
      }
    }

    for (int x : arr) cout << x << " ";
    cout << "\n";
  }
}