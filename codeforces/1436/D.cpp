// Problem: D. Bandit in a City
// Contest: Codeforces - Codeforces Round #678 (Div. 2)
// URL: https://codeforces.com/contest/1436/problem/D
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int mx = 2e5 + 5;
ll lea[mx];
ll has[mx];
ll num[mx];
vector<int> adjl[mx];
ll msd = 0;
void dfs(int n) {
  if (adjl[n].size() == 0) {
    has[n] = num[n];
    lea[n]++;
  }
  has[n] = num[n];
  for (int x : adjl[n]) {
    dfs(x);
    lea[n] += lea[x];
    has[n] += has[x];
  }
  msd = max(msd, (has[n] + lea[n] - 1) / lea[n]);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  for (int i = 0; i < n - 1; i++) {
    int r;
    cin >> r;
    r--;
    adjl[r].push_back(i + 1);
  }
  for (int i = 0; i < n; i++) {
    cin >> num[i];
  }
  dfs(0);
  cout << msd << endl;
}