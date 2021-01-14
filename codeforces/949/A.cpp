
// Problem: A. Zebras
// Contest: Codeforces - Codeforces Round #469 (Div. 1)
// URL: https://codeforces.com/contest/949/problem/A
// Memory Limit: 512 MB
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
  vector<pair<int, int>> comp;
  pair<int, int> curr = {str[0] - '0', 1};
  for (int i = 1; i < n; i++) {
    if (str[i] == str[i - 1])
      curr.second++;
    else {
      comp.push_back(curr);
      curr = {str[i] - '0', 1};
    }
  }
  vector<int> rc[500000];
  comp.push_back(curr);
  stack<int> ans0;
  stack<int> ans1;
  int king = 0;
  int cind = 1;
  for (auto t : comp) {
    for (int i = 0; i < t.second; i++) {
      if (t.first == 0) {
        if (ans0.size() == 0) {
          rc[king].push_back(cind++);
          ans1.push(king++);
        } else {
          int c = ans0.top();
          ans0.pop();
          rc[c].push_back(cind++);
          ans1.push(c);
        }
      } else {
        if (ans1.size() == 0) {
          cout << -1 << "\n";
          exit(0);
        } else {
          int c = ans1.top();
          ans1.pop();
          rc[c].push_back(cind++);
          ans0.push(c);
        }
      }
    }
  }
  if (ans0.size()) {
    cout << -1 << "\n";
    exit(0);
  }
  cout << ans1.size() << "\n";
  for (auto cr = ans1.top(); ans1.size() >= 1;) {
    if (rc[cr].size()) {
      cr = ans1.top();
      ans1.pop();
    }
    cout << rc[cr].size() << " ";
    for (int x : rc[cr]) {
      cout << x << " ";
    }
    cout << "\n";
  }
}