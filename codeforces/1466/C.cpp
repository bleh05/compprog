
// Problem: C. Canine poetry
// Contest: Codeforces - Good Bye 2020
// URL: https://codeforces.com/contest/1466/problem/C
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
    string str;
    cin >> str;
    int n = str.size();
    int cnt = 0;
    for (int i = 0; i < n - 1; i++) {
      if (str[i] == ' ') continue;
      if (str[i] == str[i + 1]) {
        int c = 1;
        while (i < n - 1 && str[i] == str[i + 1]) {
          c++;
          i++;
        }
        if (c % 3 == 1) i--;
        cnt += c * 2 / 3;
      } else if (i < n - 2 && str[i] == str[i + 2]) {
        cnt++;
        str[i + 2] = ' ';
      }
    }
    cout << cnt << endl;
  }
}