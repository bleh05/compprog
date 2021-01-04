
// Problem: A - STring
// Contest: AtCoder - AtCoder Grand Contest 005
// URL: https://atcoder.jp/contests/agc005/tasks/agc005_a
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
  cin >> str;
  stack<int> s;
  for (int i = 0; i < str.size(); i++) {
    if (str[i] == 'T' && s.size() && s.top() == 'S') {
      s.pop();
    } else
      s.push(str[i]);
  }
  cout << s.size() << endl;
}