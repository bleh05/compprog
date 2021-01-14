
// Problem: B. String LCM
// Contest: Codeforces - Educational Codeforces Round 102 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1473/problem/B
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
    string a, b;
    cin >> a >> b;
    int n1 = a.size();
    int n2 = b.size();
    int lcm = 1;
    for (;; lcm++) {
      if (lcm % n1 == 0 && lcm % n2 == 0) break;
    }
    for (int i = 0; i < lcm; i++) {
      if (a[i % n1] != b[i % n2]) {
        cout << "-1\n";
        break;
      }
      if (i == lcm - 1) {
        for (int i = 0; i < lcm / n1; i++) cout << a;
        cout << "\n";
      }
    }
  }
}