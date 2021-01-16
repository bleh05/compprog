
// Problem: B - Mex Boxes
// Contest: AtCoder - KEYENCE Programming Contest 2021
// URL: https://atcoder.jp/contests/keyence2021/tasks/keyence2021_b
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
  int freqs[n + 2];
  memset(freqs, 0, sizeof freqs);
  freqs[0] = k;
  for (int i = 0; i < n; i++) {
    int b;
    cin >> b;
    freqs[b + 1]++;
  }
  ll sum = 0;
  for (int i = 1; i <= n + 1; i++) {
    if (freqs[i] < freqs[i - 1]) {
      sum += (i - 1) * (freqs[i - 1] - freqs[i]);
    }
    freqs[i] = min(freqs[i], freqs[i - 1]);
  }
  cout << sum << endl;
}