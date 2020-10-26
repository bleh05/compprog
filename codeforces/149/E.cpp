
// Problem: E. Martian Strings
// Contest: Codeforces - Codeforces Round #106 (Div. 2)
// URL: https://codeforces.com/contest/149/problem/E
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

vector<int> zfunc(string s) {
  int n = (int)s.size();
  vector<int> z(n);
  for (int i = 1, l = 0, r = 0; i < n; i++) {
    if (i <= r) z[i] = min(r - i + 1, z[i - l]);
    while (i + z[i] < n && s[z[i]] == s[i + z[i]]) ++z[i];
    if (i + z[i] - 1 > r) l = i, r = i + z[i] - 1;
  }
  return z;
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  string str;
  cin >> str;
  int q;
  int n = (int)str.size();
  cin >> q;
  int ans = 0;
  while (q--) {
    string chk;
    cin >> chk;
    int p = (int)chk.size();
    if (p == 1) continue;
    char nfnk[n + 1 + p];
    char nfnk2[n + 1 + p];
    for (int i = 0; i < p; i++) {
      nfnk[i] = chk[i];
      nfnk2[p - i - 1] = chk[i];
    }
    nfnk[p] = '1';
    nfnk2[p] = '1';
    for (int i = 0; i < n; i++) {
      nfnk[i + p + 1] = str[i];
      nfnk2[p + n - i] = str[i];
    }
    vector<int> zz = {};
    zz = zfunc(nfnk);
    vector<int> zz2 = {};
    zz2 = zfunc(nfnk2);
    int pref[p + 1];
    int suff[p + 1];
    memset(pref, 0x3f, sizeof(pref));
    memset(suff, 0x80, sizeof(suff));
    pref[0] = 0;
    suff[0] = n - 1;
    for (int i = 0; i < n; i++) {
      pref[zz[i + p + 1]] = min(pref[zz[i + p + 1]], i);
      suff[zz2[i + p + 1]] = max(suff[zz2[i + p + 1]], n - i - 1);
    }
    for (int i = p - 1; i >= 0; i--) {
      pref[i] = min(pref[i + 1], pref[i]);
      suff[i] = max(suff[i + 1], suff[i]);
    }
    for (int i = 0; i < p; i++) {
      if (suff[p - i] >= 0 && suff[p - i] >= pref[i] + p - 1) {
        ans++;
        break;
      }
    }
  }
  cout << ans << endl;
}