#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  queue<int> q = {};
  queue<int> q2 = {};
  queue<int> q3 = {};
  int arr[n];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  vector<ll> ans = {};
  int curry = n;
  for (int i = n - 1; i >= 0; i--) {
    if (arr[i] == 1)
      q.push(i);
    else if (arr[i] == 2) {
      if (q.empty()) {
        cout << -1 << endl;
        exit(0);
      }
      ans.push_back((i + 1) * 1000000ll + curry);
      int c = q.front();
      ans.push_back((c + 1) * 1000000ll + curry--);
      q.pop();
      q2.push(i);
    } else if (arr[i] == 3) {
      if (q.empty() && q2.empty()) {
        cout << -1 << endl;
        exit(0);
      }
      if (!q2.empty()) {
        ans.push_back((i + 1) * 1000000ll + curry);
        int c2 = q2.front();
        ans.push_back((c2 + 1) * 1000000ll + curry--);
        q2.pop();
      } else {
        ans.push_back((i + 1) * 1000000ll + curry - 1);
        int c = q.front();
        ans.push_back((c + 1) * 1000000ll + curry-- - 1);
        ans.push_back((c + 1) * 1000000ll + curry-- + 1);
        q.pop();
      }
      q2.push(i);
    }
  }
  while (!q.empty()) {
    int c = q.front();
    ans.push_back((c + 1) * 1000000ll + curry--);
    q.pop();
  }
  cout << ans.size() << endl;
  for (ll x : ans) {
    cout << x % 1000000ll << " " << x / 1000000ll << endl;
  }
}