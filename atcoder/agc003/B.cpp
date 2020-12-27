
// Problem: B - Simplified mahjong
// Contest: AtCoder - AtCoder Grand Contest 003
// URL: https://atcoder.jp/contests/agc003/tasks/agc003_b
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  ll sum = 0;
  ll crsn = 0;
  for (int i = 0; i < n; i++) {
    ll c;
    cin >> c;
    crsn += c;
    if (c == 0) {
      sum += crsn / 2;
      crsn = 0;
    }
  }
  cout << sum + crsn / 2 << endl;
}