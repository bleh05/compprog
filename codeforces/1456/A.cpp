
// Problem: A. Bouncing Ball
// Contest: Codeforces - Codeforces Round #687 (Div. 1, based on Technocup 2021
// Elimination Round 2) URL: https://codeforces.com/contest/1456/problem/0
// Memory Limit: 256 MB
// Time Limit: 1000 ms
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
    int n, p, b;
    cin >> n >> p >> b;
    string str;
    cin >> str;
    int cad, crm;
    cin >> cad >> crm;
    int cnt[b];
    memset(cnt, 0, sizeof cnt);
    for (int i = p - 1; i < n; i++) {
      cnt[(i - p + 1) % b] += str[i] == '0';
    }
    ll mn = 1e18;
    ll curr = 0;
    for (int i = 0; i <= n - p; i++) {
      mn = min(curr + cnt[i % b] * cad, mn);
      cnt[i % b] -= str[i + p - 1] == '0';
      curr += crm;
    }
    cout << mn << endl;
  }
}