
// Problem: A. Mike and Cellphone
// Contest: Codeforces - Codeforces Round #361 (Div. 2)
// URL: https://codeforces.com/contest/689/problem/A
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
  int n;
  cin >> n >> str;
  int a = 0;
  bool c0 = false;
  bool c13 = false;
  for (int i = 0; i < n; i++) {
    if (str[i] == '0') c0 = true;
    if (str[i] == '1' || str[i] == '2' || str[i] == 3) c13 = true;
    if (str[i] == '0' || str[i] == '9' || str[i] == '7') a |= 1;
    if (str[i] == '1' || str[i] == '4' || str[i] == '7') a |= 2;
    if (str[i] == '1' || str[i] == '2' || str[i] == '3') a |= 4;
    if (str[i] == '9' || str[i] == '6' || str[i] == '3') a |= 8;
  }
  if (a == 15 || c0 && c13)
    cout << "YES" << endl;
  else
    cout << "NO\n";
}