
// Problem: D. Playoff Tournament
// Contest: Codeforces - Educational Codeforces Round 110 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1535/problem/D
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
 int segt[1500000]; //UNCOMMENT THIS DFASHGKASDNFD
//int segt[1000];  // COMMENT THIS SDBKJIAGNBKFNS
string str;
int n;
void setr(int v, int ind, int val, int dir) {
  if (dir == 1) {
    if (ind > str.size() / 2)
      segt[v] = max(1, val);
    else {
      if (val == 0) {
        segt[v] = segt[2 * v + 1];
      } else if (val == 1) {
        segt[v] = segt[2 * v];
      } else {
        segt[v] = segt[2 * v] + segt[2 * v + 1];
      }
    }
  } else {
    if ((dir & 1) == 0)
      setr(v * 2, ind, val, dir >> 1);
    else
      setr(v * 2 + 1, ind, val, dir >> 1);
    if (str[n - v] == '0') {
      segt[v] = segt[2 * v + 1];
    } else if (str[n - v] == '1') {
      segt[v] = segt[2 * v];
    } else {
      segt[v] = segt[2 * v] + segt[2 * v + 1];
    }
  }
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int k;
  cin >> k;
  n = 1 << k;
  n--;
  cin >> str;
  int q;
  cin >> q;
  for (int i = 0; i < (n + 1) / 2; i++) {
    int dir = 1;
    int asd = n - i;
    while (asd > 1) dir *= 2, dir += asd % 2, asd /= 2;
    int trs = 0;
    if (str[i] == '1') trs = 1;
    if (str[i] == '?') trs = 2;
    setr(1, n - i, trs, dir);
  }
  for (int i = 0; i < q; i++) {
    int in;
    char c;
    cin >> in >> c;
    str[in - 1] = c;
    int trs = 0;
    if (c == '1') trs = 1;
    if (c == '?') trs = 2;
    int indd = n + 1 - in;
    int dir = 1;
    int asd = indd;
    while (asd > 1) dir *= 2, dir += asd % 2, asd /= 2;
    setr(1, indd, trs, dir);
    cout << segt[1] << '\n';
  }
}