
// Problem: C. Bargain
// Contest: Codeforces - Codeforces Round #675 (Div. 2)
// URL: https://codeforces.com/contest/1422/problem/C
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int mod = 1000000007;
ll binp(ll a, ll b) {
  ll res = 1;
  while (b) {
    if (b & 1) res = (res * a) % mod;
    a = a * a % mod;
    b >>= 1;
  }
  return res;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  string s;
  cin >> s;
  int k = (int)s.size();
  ll totacf = 0;
  int ctr = 0;
  ll tot = 0;
  for (int i = k - 1; i >= 0; i--) {
    // cout << totacf << endl;
    tot = (tot + totacf * (s[i] - '0')) % mod;
    tot = tot +
          (((s[i] - '0') * (binp(10, k - 1 - i))) % mod * (i * (i + 1ll) / 2ll)) %
              mod;
    totacf = (totacf + binp(10, ctr++) * ctr) % mod;
    // cout << tot << endl;
  }
  cout << tot << endl;
}