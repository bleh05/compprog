
// Problem: B. Minimal Cost
// Contest: Codeforces - Codeforces Global Round 13
// URL: https://codeforces.com/contest/1491/problem/B
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
    int vert, horz;
    cin >> vert >> horz;
    set<int> s;
    int arr[n];
    for (int i = 0; i < n; i++) {
      int d;
      cin >> d;
      s.insert(d);
      arr[i] = d;
      if (i && abs(d - arr[i - 1]) > 1) vert = horz = 0;
    }
    if (s.size() != 1)
      cout << min(vert, horz) << endl;
    else
      cout << min(vert + horz, horz + horz) << endl;
  }
}