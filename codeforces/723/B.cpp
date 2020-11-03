
// Problem: B. Text Document Analysis
// Contest: Codeforces - Codeforces Round #375 (Div. 2)
// URL: https://codeforces.com/contest/723/problem/B
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
  cin >> n;
  cin >> str;
  int a = 0;
  int b = 0;
  int curra = 0;
  int has = 0;
  for (int i = 0; i < str.size(); i++) {
    if (str[i] == '_') {
      if (has > 0 && curra > 0) a++;
      curra = 0;
    } else if (str[i] == '(') {
      if (has > 0 && curra > 0) a++;
      curra = 0;
      has++;
    } else if (str[i] == ')') {
      if (has > 0 && curra > 0) a++;
      curra = 0;
      has--;
    } else {
      curra++;
      if (has) {
      } else {
        b = max(b, curra);
      }
    }
  }
  cout << b << " " << a << endl;
}