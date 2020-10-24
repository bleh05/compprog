
// Problem: B. Prime Square
// Contest: Codeforces - Codeforces Round #678 (Div. 2)
// URL: https://codeforces.com/contest/1436/problem/B
// Memory Limit: 256 MB
// Time Limit: 1500 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

bool isP(int n) {
  if (n < 2) return false;
  for (int i = 2; i * i <= n; i++) {
    if (n % i == 0) return false;
  }
  return true;
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t-- > 0) {
    int n;
    cin >> n;
    for (int j = n; j < 3000; j++) {
      if (isP(j) && !isP(j - n + 1)) {
        for (int i = 0; i < n; i++) {
          for (int k = 0; k < n; k++) {
            if (i == k) {
              cout << j - n + 1 << " ";
            } else {
              cout << 1 << " ";
            }
          }
          cout << endl;
        }
        break;
      }
    }
  }
}