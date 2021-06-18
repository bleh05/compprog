
// Problem: D. Deleting Divisors
// Contest: Codeforces - Codeforces Round #726 (Div. 2)
// URL: https://codeforces.com/contest/1537/problem/D
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
  set<int> s;
  for (ll i = 2; i < 1000000000; i *= 4) s.insert(i);
  while (t--) {
    int t;
    cin >> t;
    if (t % 2 || s.count(t))
      cout << "Bob";
    else
      cout << "Alice";
    cout << endl;
  }
}