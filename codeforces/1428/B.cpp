
// Problem: B. Belted Rooms
// Contest: Codeforces - Codeforces Raif Round 1 (Div. 1 + Div. 2)
// URL: https://codeforces.com/contest/1428/problem/B
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t-- > 0) {
    int n;
    cin >> n;
    int arr[n];
    memset(arr, 0, sizeof arr);
    string s;
    cin >> s;
    bool hasa = false, hasb = false;
    for (int i = 0; i < n; i++) {
      if (s[i] == '-') {
        arr[i] += 1;
        arr[(i + 1) % n] += 1;
      }
      if (s[i] == '>') hasa = true;
      if (s[i] == '<') hasb = true;
    }
    if (!hasa || !hasb) {
      cout << n << endl;
      continue;
    }
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i] > 0;
    }
    cout << sum << endl;
  }
}