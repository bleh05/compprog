
// Problem: B. Different Divisors
// Contest: Codeforces - Codeforces Round #696 (Div. 2)
// URL: https://codeforces.com/contest/1474/problem/B
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int s[3000000];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  set<int> primes;
  for (int i = 2; i < 100000; i++) {
    if (s[i] == 0) {
      primes.insert(i);
      for (int j = 2 * i; j < 100000; j += i) {
        s[j] = 1;
      }
    }
  }
  while (t--) {
    int n;
    cin >> n;
    int k = *primes.lower_bound(n + 1);
    int m = *primes.lower_bound(k + n);
    cout << k * m << endl;
  }
}