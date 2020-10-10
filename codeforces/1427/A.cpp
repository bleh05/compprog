
// Problem: A. Avoiding Zero
// Contest: Codeforces - Codeforces Global Round 11
// URL: https://codeforces.com/contest/1427/problem/0
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
  while (t-- > 0) {
    int n;
    cin >> n;
    int sum = 0;
    int arr[n];
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
      sum += arr[i];
    }
    if (sum == 0) {
      cout << "NO\n";
      continue;
    }
    cout << "YES\n";
    if (sum < 0) {
      sort(arr, arr + n);
      for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
      }
      cout << "\n";
    } else {
      sort(arr, arr + n);
      reverse(arr, arr + n);
      for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
      }
      cout << "\n";
    }
  }
}