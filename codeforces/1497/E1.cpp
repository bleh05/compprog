
// Problem: E1. Square-free division (easy version)
// Contest: Codeforces - Codeforces Round #708 (Div. 2)
// URL: https://codeforces.com/contest/1497/problem/E1
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int sieve[10000004];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  vector<int> psqr;
  for (int i = 2; i < 10000; i++) {
    if (i * i < 10000004) psqr.push_back(i * i);
  }
  for (int i = 1; i < 10000004; i++) {
    if (sieve[i] == 0) {
      sieve[i] = i;
      for (int x : psqr) {
        if (x * i >= 10000004) break;
        sieve[x * i] = i;
      }
    }
  }
  int t;
  cin >> t;
  for (int i = 0; i < t; i++) {
    int n;
    cin >> n;
    int d;
    cin >> d;
    vector<int> v;
    for (int i = 0; i < n; i++) {
      int k;
      cin >> k;
      v.push_back(sieve[k]);
    }
    set<int> s;
    int z = 1;
    for (int i = 0; i < n; i++) {
      if (s.count(v[i])) {
        s.clear();
        z++;
      }
      s.insert(v[i]);
    }
    cout << z << endl;
  }
}