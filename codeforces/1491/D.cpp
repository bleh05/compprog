
// Problem: D. Zookeeper and The Infinite Zoo
// Contest: Codeforces - Codeforces Global Round 13
// URL: https://codeforces.com/contest/1491/problem/D
// Memory Limit: 256 MB
// Time Limit: 3000 ms
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
    int a, b;
    cin >> a >> b;
    if (a > b) {
      cout << "NO\n";
      continue;
    }
    int suff1[32];
    int suff2[32];
    memset(suff1, 0, sizeof suff1);
    memset(suff2, 0, sizeof suff2);
    bool good = true;
    for (int i = 0; i <= 30; i++) {
      if (b & (1 << i)) suff1[i]++;
      if (a & (1 << i)) suff2[i]++;
      suff1[i + 1] += suff1[i];
      suff2[i + 1] += suff2[i];
      if (suff1[i] > suff2[i] && good) {
        cout << "NO" << endl;
        good = false;
      }
    }
    if (good) cout << "YES" << endl;
  }
}