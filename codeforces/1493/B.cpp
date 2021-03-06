
// Problem: B. Planet Lapituletti
// Contest: Codeforces - Codeforces Round #705 (Div. 2)
// URL: https://codeforces.com/contest/1493/problem/B
// Memory Limit: 256 MB
// Time Limit: 2000 ms
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
    int h, m;
    cin >> h >> m;
    string str;
    cin >> str;
    int st1 = 0;
    int st2 = 0;
    st1 = (str[0] - '0') * 10 + (str[1] - '0');
    st2 = (str[3] - '0') * 10 + (str[4] - '0');
    int a = 0;
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < m; j++) {
        int nst1 = (st1 + i);
        int nst2 = (st2 + j);
        if (nst2 >= m) nst1++, nst2 -= m;
        if (nst1 >= h) nst1 -= h;
        int nnst1 = 0;
        int nnst2 = 0;
        if (nst1 % 10 == 2)
          nnst2 += 50;
        else if (nst1 % 10 == 5)
          nnst2 += 20;
        else if (nst1 % 10 == 1)
          nnst2 += 10;
        else if (nst1 % 10 == 8)
          nnst2 += 80;
        else if (nst1 % 10 == 0)
          ;
        else
          continue;
        if (nst1 / 10 == 2)
          nnst2 += 5;
        else if (nst1 / 10 == 5)
          nnst2 += 2;
        else if (nst1 / 10 == 1)
          nnst2 += 1;
        else if (nst1 / 10 == 8)
          nnst2 += 8;
        else if (nst1 / 10 == 0)
          ;
        else
          continue;
        if (nst2 % 10 == 2)
          nnst1 += 50;
        else if (nst2 % 10 == 5)
          nnst1 += 20;
        else if (nst2 % 10 == 1)
          nnst1 += 10;
        else if (nst2 % 10 == 8)
          nnst1 += 80;
        else if (nst2 % 10 == 0)
          ;
        else
          continue;
        if (nst2 / 10 == 2)
          nnst1 += 5;
        else if (nst2 / 10 == 5)
          nnst1 += 2;
        else if (nst2 / 10 == 1)
          nnst1 += 1;
        else if (nst2 / 10 == 8)
          nnst1 += 8;
        else if (nst2 / 10 == 0)
          ;
        else
          continue;
        if (nnst1 < h && nnst2 < m) {
          cout << (nst1 < 10 ? "0" : "") << nst1 << ":"
               << (nst2 < 10 ? "0" : "") << nst2 << "\n";
          j = m;
          i = h;
          a = 1;
        }
      }
    }
    if (a == 0) cout << "00:00\n";
  }
}