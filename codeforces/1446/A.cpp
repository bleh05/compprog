
// Problem: A. Knapsack
// Contest: Codeforces - Codeforces Round #683 (Div. 1, by Meet IT)
// URL: https://codeforces.com/contest/1446/problem/0
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
  while (t-- > 0) {
    int n;
    ll c;
    cin >> n >> c;
    ll sum = 0;
    int ptr = 0;
    ll k = 0;
    pair<int, int> arr[n];
    for (int i = 0; i < n; i++) {
      int d;
      cin >> d;
      arr[i] = make_pair(d, i);
      k += d;
    }
    sort(arr, arr + n);
    bool solved = false;
    for (int i = 0; i < n; i++) {
      while (ptr != n && sum <= c) {
        if (sum >= c / 2 + (c & 1)) {
          cout << ptr - i << endl;
          for (int k = i; k < ptr; k++) {
            cout << arr[k].second + 1 << " ";
          }
          cout << endl;
          solved = true;
          break;
        }
        sum += arr[ptr].first;
        ptr++;
      }
      if (solved) break;
      if (sum >= c / 2 + (c & 1) && sum <= c) {
        cout << ptr - i << endl;
        for (int k = i; k < ptr; k++) {
          cout << arr[k].second + 1 << " ";
        }
        cout << endl;
        solved = true;
        break;
      }
      sum -= arr[i].first;
    }
    if (!solved) {
      if (k >= c / 2 + (c & 1) && k <= c) {
        cout << n << endl;
        for (int i = 0; i < n; i++) {
          cout << i + 1 << " ";
        }
        cout << endl;
      } else
        cout << -1 << endl;
    }
  }
}