
// Problem: B. Grime Zoo
// Contest: Codeforces - Codeforces Round #692 (Div. 1, based on Technocup 2021
// Elimination Round 3) URL: https://codeforces.com/contest/1464/problem/B
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
  int n = str.size();
  ll x, y;
  cin >> x >> y;
  int pfix[n][2];
  int sfix[n][2];
  pfix[0][0] = str[0] == '0';
  pfix[0][1] = str[0] == '1';
  for (int i = 1; i < n; i++) {
    pfix[i][0] = pfix[i - 1][0] + (str[i] == '0');
    pfix[i][1] = pfix[i - 1][1] + (str[i] == '1');
  }
  sfix[n - 1][0] = str[n - 1] == '0';
  sfix[n - 1][1] = str[n - 1] == '1';
  for (int i = n - 2; i >= 0; i--) {
    sfix[i][0] = sfix[i + 1][0] + (str[i] == '0');
    sfix[i][1] = sfix[i + 1][1] + (str[i] == '1');
  }
  ll sum = 0;
  ll osum = 0;
  int curx = 0;
  ll amin = 1e18;
  for (int i = 0; i < n; i++) {
    if (str[i] == '1') {
      sum += x * pfix[i][0] + y * sfix[i][0];
    } else if (str[i] == '0') {
      sum += y * pfix[i][1] + x * sfix[i][1];
    } else {
      curx++;
      osum += x * pfix[i][0] + y * sfix[i][0];
    }
  }
  amin = osum;
  int c = 0;
  for (int i = n - 1; i >= 0; i--) {
    if (str[i] == '?') {
      osum -= x * pfix[i][0] + y * sfix[i][0];
      osum += y * pfix[i][1] + x * sfix[i][1] + (curx - 1) * y - c * y;
      c++;
      curx--;
    }
    amin = min(amin, osum);
  }
  c = 0;
  osum = 0;
  for (int i = 0; i < n; i++) {
    if (str[i] == '?') {
      osum += y * pfix[i][1] + x * sfix[i][1];
      curx++;
    }
  }
  amin = min(amin, osum);
  for (int i = n - 1; i >= 0; i--) {
    if (str[i] == '?') {
      osum -= y * pfix[i][1] + x * sfix[i][1];
      osum += x * pfix[i][0] + y * sfix[i][0] + (curx - 1) * x - c * x;
      c++;
      curx--;
    }
    amin = min(amin, osum);
  }
  cout << sum / 2 + amin << endl;
}