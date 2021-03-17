
// Problem: C1. k-LCM (easy version)
// Contest: Codeforces - Codeforces Round #708 (Div. 2)
// URL: https://codeforces.com/contest/1497/problem/C1
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
    int n, k;
    cin >> n >> k;
    if (n & 1) {
      cout << n / 2 << " " << n / 2 << " 1\n";
    } else if (n % 4 == 0) {
      cout << n / 2 << " " << n / 4 << " " << n / 4 << "\n";
    } else {
      cout << (n - 2) / 2 << " " << (n - 2) / 2 << " " << 2 << "\n";
    }
  }
}