
// Problem: D. Even-Odd Game
// Contest: Codeforces - Codeforces Round #693 (Div. 3)
// URL: https://codeforces.com/contest/1472/problem/D
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
    int n;
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
    }
    sort(arr, arr + n);
    reverse(arr, arr + n);
    ll a = 0, b = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] % 2 == 0 && i % 2 == 0) a += arr[i];
      if (arr[i] % 2 == 1 && i % 2 == 1) b += arr[i];
    }
    if (a == b) {
      cout << "Tie" << endl;
    } else if (a > b) {
      cout << "Alice" << endl;
    } else {
      cout << "Bob" << endl;
    }
  }
}