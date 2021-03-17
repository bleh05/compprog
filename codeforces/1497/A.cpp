
// Problem: A. Meximization
// Contest: Codeforces - Codeforces Round #708 (Div. 2)
// URL: https://codeforces.com/contest/1497/problem/0
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  set<int> s;
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    s.clear();
    vector<int> arr;
    for (int i = 0; i < n; i++) {
      int d;
      cin >> d;
      if (s.count(d)) arr.push_back(d);
      s.insert(d);
    }
    for (int x : s) cout << x << " ";
    for (int x : arr) cout << x << " ";
    cout << endl;
  }
}