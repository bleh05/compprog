
// Problem: B. Array Reodering
// Contest: Codeforces - Educational Codeforces Round 110 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1535/problem/B
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int evcnt = 0;
    int n;
    cin >> n;
    int arr[n];
    vector<int> odds;
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
      if (arr[i] % 2 == 0)
        evcnt++;
      else
        odds.push_back(arr[i]);
    }
    ll totsum = 0;
    for (int j = n - 1, i = 0; i < evcnt; i++, j--) {
      totsum += j;
    }
    for (int i = 0; i < odds.size(); i++) {
      for (int j = i + 1; j < odds.size(); j++) {
        if (gcd(odds[i], odds[j]) > 1) totsum++;
      }
    }
    cout << totsum << endl;
  }
}