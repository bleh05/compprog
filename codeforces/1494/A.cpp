
// Problem: A. ABC String
// Contest: Codeforces - Educational Codeforces Round 105 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1494/problem/0
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int arr[6] = {1, 2, 4, 3, 5, 6};
  int t;
  cin >> t;
  while (t--) {
    string str;
    cin >> str;
    int d = 0;
    for (int msk : arr) {
      d = 0;
      for (char x : str) {
        if (msk & (1 << (x - 'A'))) {
          d++;
        } else
          d--;
        if (d < 0) d = -10000000;
      }
      if (d == 0) {
        cout << "YES" << endl;
        break;
      }
    }
    if (d != 0) {
      cout << "NO" << endl;
    }
  }
}