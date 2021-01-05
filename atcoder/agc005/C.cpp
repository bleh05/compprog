
// Problem: C - Tree Restoring
// Contest: AtCoder - AtCoder Grand Contest 005
// URL: https://atcoder.jp/contests/agc005/tasks/agc005_c
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
  int arr[n];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  sort(arr, arr + n);
  int m2 = arr[n - 1];
  multiset<int> ms;
  for (int i = 0; i < n; i++) {
    ms.insert(arr[i]);
  }
  if (m2 % 2 == 1) {
    for (int x = m2 / 2 + 1; x <= m2; x++) {
      if (ms.count(x) < 2) {
        cout << "Impossible\n";
        exit(0);
      }
      ms.erase(ms.lower_bound(x));
      ms.erase(ms.lower_bound(x));
    }
    for (int i = 0; i <= m2 / 2 + 1; i++) {
      if (ms.count(i)) {
        cout << "Impossible\n";
        exit(0);
      }
    }
    cout << "Possible\n";
  }
  if (m2 % 2 == 0) {
    for (int x = m2 / 2 + 1; x <= m2; x++) {
      if (ms.count(x) < 2) {
        cout << "Impossible\n";
        exit(0);
      }
      ms.erase(ms.lower_bound(x));
      ms.erase(ms.lower_bound(x));
    }
    if (ms.count(m2 / 2)) {
      ms.erase(ms.lower_bound(m2 / 2));
    } else {
      cout << "Impossible\n";
      exit(0);
    }
    for (int i = 0; i <= m2 / 2; i++) {
      if (ms.count(i)) {
        cout << "Impossible\n";
        exit(0);
      }
    }
    cout << "Possible\n";
  }
}