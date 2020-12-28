
// Problem: B. Red and Blue
// Contest: Codeforces - Educational Codeforces Round 101 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1469/problem/B
// Memory Limit: 512 MB
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
    int max1 = 0;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      int k;
      cin >> k;
      sum += k;
      max1 = max(max1, sum);
    }
    cin >> n;
    int max2 = 0;
    int sum2 = 0;
    for (int i = 0; i < n; i++) {
      int k;
      cin >> k;
      sum2 += k;
      max2 = max(max2, sum2);
    }
    cout << max1 + max2 << '\n';
  }
}