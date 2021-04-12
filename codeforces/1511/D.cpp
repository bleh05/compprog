
// Problem: D. Min Cost String
// Contest: Codeforces - Educational Codeforces Round 107 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1511/problem/D
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  vector<char> vc;
  int n, k;
  cin >> n >> k;
  if (k == 1) {
    for (int i = 0; i < n; i++) {
      cout << 'a';
    }
    exit(0);
  }
  char arr[k * k];
  arr[0] = 'a' + k - 1;
  int ptr = 1;
  for (int i = 0; i < k; i++) {
    for (int j = i; j < k; j++) {
      arr[ptr++] = 'a' + j;
      if (j != k - 1) arr[ptr++] = 'a' + i;
    }
  }
  for (int i = 0; i < n; i++) {
    cout << arr[i % (k * k)];
  }
  cout << "\n";
}