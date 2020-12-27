
// Problem: A - Wanna go back home
// Contest: AtCoder - AtCoder Grand Contest 003
// URL: https://atcoder.jp/contests/agc003/tasks/agc003_a
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  string str;
  cin >> str;
  int arr[4];
  arr[0] = arr[1] = arr[2] = arr[3] = 0;
  for (char c : str) {
    if (c == 'S') arr[0] = 1;
    if (c == 'E') arr[1] = 1;
    if (c == 'N') arr[2] = 1;
    if (c == 'W') arr[3] = 1;
  }
  if (arr[0] ^ arr[2] || arr[1] ^ arr[3])
    cout << "No" << endl;
  else
    cout << "Yes" << endl;
}