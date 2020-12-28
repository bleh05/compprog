
// Problem: D. Ceil Divisions
// Contest: Codeforces - Educational Codeforces Round 101 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1469/problem/D
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
    if (n == 3) {
      cout << "2\n3 2\n3 2\n";
      continue;
    }
    int c = 0;
    vector<int> v;
    int i;
    for (i = n; i >= 3; i = int(ceil(sqrt(i)))) {
      v.push_back(i);
    }
    v.push_back(i);
    cout << n + 5 << "\n";
    for (int i = 0; i < v.size() - 1; i++) {
      for (int j = v[i + 1] + 1; j < v[i]; j++) {
        cout << j << " " << v[i] << "\n";
        c++;
      }
      cout << v[i] << " " << v[i + 1] << "\n";
      cout << v[i] << " " << v[i + 1] << "\n";
      c++;
      c++;
    }
    for (; c < n + 5; c++) {
      cout << "1 2\n";
    }
  }
}