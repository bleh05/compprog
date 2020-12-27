
// Problem: M. Similar Sets
// Contest: Codeforces - 2020-2021 ICPC, NERC, Southern and Volga Russian
// Regional Contest (Online Mirror, ICPC Rules) URL:
// https://codeforces.com/contest/1468/problem/M Memory Limit: 512 MB Time
// Limit: 1000 ms Powered by CP Editor (https://github.com/cpeditor/cpeditor)

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
    vector<int> arr[n];
    for (int i = 0; i < n; i++) {
      int l;
      cin >> l;
      for (int j = 0; j < l; j++) {
        int c;
        cin >> c;
        arr[i].push_back(c);
        s.insert(c);
      }
    }
    int d = 0;
    map<int, int> comp;
    for (int cm : s) {
      comp[cm] = d++;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < arr[i].size(); j++) {
        arr[i][j] = comp[arr[i][j]];
      }
    }
    bool hasans = false;
    vector<pair<vector<int>, int>> smals;
    for (int i = 0; i < n; i++) {
      if (arr[i].size() >= sqrt(d)) {
        int freq[d];
        memset(freq, 0, sizeof freq);
        for (int j = 0; j < arr[i].size(); j++) {
          freq[arr[i][j]] = 1;
        }
        for (int j = 0; j < n; j++) {
          if (j == i) continue;
          int sum = 0;
          for (int x : arr[j]) {
            sum += freq[x];
          }
          if (sum >= 2) {
            cout << i + 1 << " " << j + 1 << endl;
            hasans = true;
            break;
          }
        }
        if (hasans) break;
      } else {
        smals.push_back({arr[i], i + 1});
      }
    }
    if (hasans) continue;
    vector<pair<int, int>> sert[d];
    for (int i = 0; i < smals.size(); i++) {
      for (int x : smals[i].first) {
        for (int y : smals[i].first) {
          if (x < y) {
            sert[x].push_back({y, smals[i].second});
          }
        }
      }
    }
    int freq[d];
    memset(freq, 0, sizeof freq);
    for (int i = 0; i < d; i++) {
      for (auto c : sert[i]) {
        if (freq[c.first]) {
          cout << freq[c.first] << " " << c.second << endl;
          hasans = true;
          break;
        }
        freq[c.first] = c.second;
      }
      for (auto c : sert[i]) {
        freq[c.first] = 0;
      }
      if (hasans) break;
    }
    if (!hasans) cout << -1 << endl;
  }
}