
// Problem: B - Quadruple
// Contest: AtCoder - AtCoder Regular Contest 107
// URL: https://atcoder.jp/contests/arc107/tasks/arc107_b
// Memory Limit: 1024 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, k;
  cin >> n >> k;
  ll sum = 0;
  for (int i = 2; i <= 2 * n; i++) {
    int lowest = max(1, i - n);
    int highest = min(i - 1, n);
    ll nway1 = highest - lowest + 1;
    // cout << i << " " << highest << " " << lowest << endl;
    int diff = i - k;
    int lowest2 = max(1, diff - n);
    int highest2 = min(diff - 1, n);
    ll nway2 = highest2 - lowest2 + 1;
    // cout << i << " " << highest2 << " " << lowest2 << endl;
    sum += max(nway1 * nway2, 0ll);
  }
  cout << sum;
}