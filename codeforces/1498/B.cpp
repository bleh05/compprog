
// Problem: B. Box Fitting
// Contest: Codeforces - CodeCraft-21 and Codeforces Round #711 (Div. 2)
// URL: https://codeforces.com/contest/1498/problem/B
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
    multiset<int> ms;
    int arr[n];
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
    }
    sort(arr, arr + n);
    reverse(arr, arr + n);
    for (int i = 0; i < n; i++) {
      if (ms.size() == 0) {
        ms.insert(arr[i]);
        continue;
      }
      auto x = ms.upper_bound(m - arr[i]);
      if (x == ms.begin()) {
        ms.insert(arr[i]);
      } else {
        x--;
        ms.erase(x);
        int c = *x;
        ms.insert(arr[i] + c);
      }
    }
    cout << ms.size() << endl;
  }
}