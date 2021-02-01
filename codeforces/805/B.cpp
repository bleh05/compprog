
// Problem: B. 3-palindrome
// Contest: Codeforces - Codeforces Round #411 (Div. 2)
// URL: https://codeforces.com/contest/805/problem/B
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  string str = "aabb";
  for (int i = 0; i < n; i++) {
    cout << str[i % 4];
  }
  cout << "\n";
}