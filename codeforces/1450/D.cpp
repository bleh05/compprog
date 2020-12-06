
// Problem: D. Rating Compression
// Contest: Codeforces - Codeforces Global Round 12
// URL: https://codeforces.com/contest/1450/problem/D
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int parent[300002];
int sizer[300002];
void make_set(int v) {
  parent[v] = v;
  sizer[v] = 1;
}

int find_set(int v) {
  if (v == parent[v]) return v;
  return parent[v] = find_set(parent[v]);
}

void union_sets(int a, int b) {
  a = find_set(a);
  b = find_set(b);
  if (a != b) {
    parent[b] = a;
    sizer[a] += sizer[b];
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    int arr[n];
    vector<pair<int, int>> prs = {};
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
      make_set(i);
      prs.push_back({-arr[i], i});
    }
    sort(prs.begin(), prs.end());
    int lsub[n + 2];
    memset(lsub, 0, sizeof lsub);
    for (pair<int, int> x : prs) {
      if (x.second > 0 && arr[x.second] <= arr[x.second - 1]) {
        union_sets(x.second, x.second - 1);
      }
      if (x.second < n - 1 && arr[x.second] <= arr[x.second + 1]) {
        union_sets(x.second, x.second + 1);
      }
      lsub[-x.first] = max(lsub[-x.first], sizer[find_set(x.second)]);
    }
    int str[n + 3];
    memset(str, 0, sizeof(str));
    for (int i = 1; i <= n; i++) {
      if (lsub[i] <= n - i) {
        str[n - i + 1] += 1000;
        str[lsub[i]] -= 1000;
      }
    }
    int psu = 0;
    for (int i = 0; i < n; i++) {
      psu += str[i];
      if (psu < 0) {
        cout << 0;
      } else {
        cout << 1;
      }
    }
    cout << endl;
  }
}