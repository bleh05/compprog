
// Problem: A. Space Navigation
// Contest: Codeforces - Codeforces Round #699 (Div. 2)
// URL: https://codeforces.com/contest/1481/problem/0
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
    int x, y;
    cin >> x >> y;
    string str;
    cin >> str;
    int dir[4];
    memset(dir, 0, sizeof dir);
    for (char d : str) {
      if (d == 'U') dir[0]++;
      if (d == 'R') dir[1]++;
      if (d == 'D') dir[2]++;
      if (d == 'L') dir[3]++;
    }
    bool good = true;
    if (x < 0) {
      if (dir[3] < -x) good = false;
    } else {
      if (dir[1] < x) good = false;
    }
    if (y < 0) {
      if (dir[2] < -y) good = false;
    } else {
      if (dir[0] < y) good = false;
    }
    cout << (good ? "YES\n" : "NO\n");
  }
}