
// Problem: A. Peaceful Rooks
// Contest: Codeforces - Codeforces Round #692 (Div. 1, based on Technocup 2021
// Elimination Round 3) URL: https://codeforces.com/contest/1464/problem/0
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int mxn = 1e5 + 2;
int parent[mxn];
int findset(int a) {
  if (parent[a] == a)
    return a;
  else
    return parent[a] = findset(parent[a]);
}
void unionset(int a, int b) {
  a = findset(a);
  b = findset(b);
  if (b != a) {
    parent[b] = a;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    for (int i = 0; i <= n; i++) {
      parent[i] = i;
    }
    int cm = m;
    for (int i = 0; i < m; i++) {
      int a, b;
      cin >> a >> b;
      if (a == b)
        cm--;
      else if (findset(a) == findset(b))
        cm++;
      unionset(a, b);
    }
    cout << cm << "\n";
  }
}