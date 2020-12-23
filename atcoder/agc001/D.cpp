
// Problem: D - Arrays and Palindrome
// Contest: AtCoder - AtCoder Grand Contest 001
// URL: https://atcoder.jp/contests/agc001/tasks/agc001_d
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m;
  cin >> n >> m;
  int arr[m];
  int ct = 0;
  for (int i = 0; i < m; i++) {
    cin >> arr[i];
    ct += arr[i] & 1;
  }
  if (ct > 2) {
    cout << "Impossible" << endl;
  } else {
    vector<int> evn;
    vector<int> odd;
    for (int i = 0; i < m; i++) {
      if (arr[i] & 1)
        odd.push_back(arr[i]);
      else
        evn.push_back(arr[i]);
    }
    if (m == 1) {
      cout << arr[0] << endl;
      if (arr[0] == 1) {
        cout << "1\n1" << endl;
      } else {
        cout << 2 << endl;
        cout << arr[0] - 1 << " " << 1 << endl;
      }
    } else {
      if (odd.size() == 0) {
        for (int x : evn) {
          cout << x << " ";
        }
        cout << endl;
        cout << m << endl;
        evn[0]--;
        evn[evn.size() - 1]++;
        for (int x : evn) {
          cout << x << " ";
        }
        cout << endl;
      }
      if (odd.size() == 1) {
        cout << odd[0] << " ";
        for (int x : evn) {
          cout << x << " ";
        }
        cout << endl;
        cout << m - (odd[0] == 1) << endl;
        if (odd[0] > 1) cout << odd[0] - 1 << " ";
        evn[evn.size() - 1]++;
        for (int x : evn) {
          cout << x << " ";
        }
        cout << endl;
      }
      if (odd.size() == 2) {
        cout << odd[0] << " ";
        for (int x : evn) {
          cout << x << " ";
        }
        cout << odd[1];
        cout << endl;
        cout << m - (odd[0] == 1) << endl;
        if (odd[0] > 1) cout << odd[0] - 1 << " ";
        for (int x : evn) {
          cout << x << " ";
        }
        cout << odd[1] + 1;
        cout << endl;
      }
    }
  }
}