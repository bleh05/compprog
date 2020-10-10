
// Problem: B. Chess Cheater
// Contest: Codeforces - Codeforces Global Round 11
// URL: https://codeforces.com/contest/1427/problem/B
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
  while (t-- > 0) {
    int n, m;
    cin >> n >> m;
    string str;
    cin >> str;
    int usm = 0;
    vector<int> spaces = {};
    int k = 0;
    int d = 0;
    bool has = 0;
    for (int i = 0; i < n; i++) {
      if (str[i] == 'W') {
        if (k > 0) {
          spaces.push_back(k);
          k = 0;
        }
        if (i > 0 && str[i - 1] == 'W') {
          usm += 2;
        } else {
          usm++;
        }
        has = true;
      } else if (str[i] == 'L') {
        if (has) k++;
        d++;
      }
    }
    sort(spaces.begin(), spaces.end());
    if (m >= d) {
      cout << n * 2 - 1 << endl;
      continue;
    }
    for (int x : spaces) {
      if (x <= m) {
        usm += 2 * x + 1;
        m -= x;
      } else {
        break;
      }
    }
    usm += 2 * m;
    if (d == n) usm--;
    cout << max(usm, 0) << endl;
  }
}