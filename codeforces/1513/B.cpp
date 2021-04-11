
// Problem: B. AND Sequences
// Contest: Codeforces - Divide by Zero 2021 and Codeforces Round #714 (Div. 2)
// URL: https://codeforces.com/contest/1513/problem/B
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ll fac[200002];
  fac[0] = 1;
  int mod = 1000000007;
  for (int i = 1; i < 200002; i++) {
    fac[i] = fac[i - 1] * i % mod;
  }
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    int arr[n];
    int nd = 0x7fffffff;
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
      nd &= arr[i];
    }
    ll zr = 0;
    for (int i = 0; i < n; i++) {
      arr[i] -= nd;
      if (arr[i] == 0) zr++;
    }
    ll comb = 1;
    comb *= zr * (zr - 1);
    comb %= mod;
    comb *= fac[n - 2];
    comb %= mod;
    cout << comb << endl;
  }
}