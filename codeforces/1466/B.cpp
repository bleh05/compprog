
// Problem: B. Last minute enhancements
// Contest: Codeforces - Good Bye 2020
// URL: https://codeforces.com/contest/1466/problem/B
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
      cin >> arr[i];
    }
    set<int> s;
    sort(arr, arr + n);
    for (int i = 0; i < n; i++) {
      if (!s.count(arr[i])) {
        s.insert(arr[i]);
      } else
        s.insert(arr[i] + 1);
    }
    cout << s.size() << endl;
  }
}