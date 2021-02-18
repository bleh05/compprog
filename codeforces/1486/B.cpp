
// Problem: B. Eastern Exhibition
// Contest: Codeforces - Codeforces Round #703 (Div. 2)
// URL: https://codeforces.com/contest/1486/problem/B
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
    vector<pair<int, int>> q1 = {};
    vector<pair<int, int>> q2 = {};
    for (int i = 0; i < n; i++) {
      int a, b;
      cin >> a >> b;
      q1.push_back({a, b});
      q2.push_back({b, a});
    }
    sort(q1.begin(), q1.end());
    sort(q2.begin(), q2.end());
    if (n % 2 == 1)
      cout << 1 << endl;
    else {
      ll r1 = q1[n / 2 - 1].first - q1[n / 2].first - 1;
      ll r2 = q2[n / 2 - 1].first - q2[n / 2].first - 1;
      cout << r1 * r2 << endl;
    }
  }
}