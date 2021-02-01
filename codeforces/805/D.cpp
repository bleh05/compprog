
// Problem: D. Minimum number of steps
// Contest: Codeforces - Codeforces Round #411 (Div. 2)
// URL: https://codeforces.com/contest/805/problem/D
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  string str;
  cin >> str;
  int n = str.size();
  ll sucb = 0;
  ll sum = 0;
  int mod = 1000000007;
  for (int i = n - 1; i >= 0; i--) {
    if (str[i] == 'b')
      sucb++;
    else {
      if (sucb == 0)
        continue;
      else {
        sum += sucb;
        sucb *= 2;
        sucb %= mod;
        sum %= mod;
      }
    }
  }
  cout << sum << endl;
}