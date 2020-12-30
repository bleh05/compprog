
// Problem: A. Bovine Dilemma
// Contest: Codeforces - Good Bye 2020
// URL: https://codeforces.com/contest/1466/problem/0
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
  while (t--) {
    set<int> s;
    int n;
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++) cin >> arr[i];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (j == i) continue;
        s.insert(abs(arr[i] - arr[j]));
      }
    }
    cout << s.size() << endl;
  }
}