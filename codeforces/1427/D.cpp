
// Problem: D. Unshuffling a Deck
// Contest: Codeforces - Codeforces Global Round 11
// URL: https://codeforces.com/contest/1427/problem/D
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int arr[52];
void doOp(vector<int> v) {
  vector<vector<int>> tr = {};
  int ptr = 0;
  for (int x : v) {
    vector<int> pb = {};
    for (int i = 0; i < x; i++, ptr++) {
      pb.push_back(arr[ptr]);
    }
    tr.push_back(pb);
  }
  reverse(tr.begin(), tr.end());
  ptr = 0;
  for (vector<int> x : tr) {
    for (int c : x) {
      arr[ptr++] = c;
    }
  }
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  if (n == 1) {
    cout << 0 << endl;
    exit(0);
  }
  vector<vector<int>> vs = {};
  vector<int> v = {};
  if (arr[0] != 1) {
    for (int i = 0; i < n; i++) {
      if (arr[i] == 1) {
        v.push_back(i);
        v.push_back(n - i);
        doOp(v);
        // for (int i = 0; i < n; i++) {
        // cout << arr[i] << " ";
        // }
        // cout << endl;
        break;
      }
    }
    vs.push_back(v);
  }
  int rev = 0;
  for (int i = 1; i < n - 1; i++) {
    v.clear();
    int goal = i + 1;
    if (rev) {
      for (int j = 0; j < n; j++) {
        if (arr[j] == goal) {
          if (j > 0) v.push_back(j);
          v.push_back(n - i - j);
          for (int k = 0; k < i; k++) v.push_back(1);
          break;
        }
      }
    } else {
      for (int k = 0; k < i; k++) v.push_back(1);
      for (int j = 0; j < n; j++) {
        if (arr[j] == goal) {
          v.push_back(j + 1 - i);
          if (n > j + 1) v.push_back(n - j - 1);
          break;
        }
      }
    }
    // for (int x : v) {
    // cout << x << " ";
    // // }
    // cout << endl;
    rev ^= 1;
    vs.push_back(v);
    doOp(v);
    // for (int i = 0; i < n; i++) {
    // cout << arr[i] << "a ";
    // }
    // cout << endl;
    bool good = false;
    for (int i = 0; i < n; i++) {
      if (i != arr[i] - 1) {
        break;
      }
      if (i == n - 1) {
        good = true;
      }
    }
    if (good) break;
    for (int i = 0; i < n; i++) {
      if (i + arr[i] != n) {
        break;
      }
      if (i == n - 1) {
        vector<int> c = {};
        for (int j = 0; j < n; j++) {
          c.push_back(1);
        }
        vs.push_back(c);
        good = true;
      }
    }
    if (good) break;
  }
  cout << vs.size() << endl;
  for (vector<int> x : vs) {
    cout << x.size() << " ";
    for (int c : x) {
      cout << c << " ";
    }
    cout << endl;
  }
}