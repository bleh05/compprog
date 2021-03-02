
// Problem: C. 1D Sokoban
// Contest: Codeforces - Educational Codeforces Round 105 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1494/problem/C
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
vector<int> bsP;
vector<int> bsN;
int bs1(int tr) {
  int l = 0, r = bsP.size() - 1;
  while (r - l > 1) {
    int m = (l + r) >> 1;
    if (bsP[m] == tr)
      l = r = m;
    else if (bsP[m] < tr)
      l = m;
    else
      r = m;
  }
  if (bsP[l] >= tr) return l;
  return r;
}
int bs2(int tr) {
  int l = 0, r = bsN.size() - 1;
  while (r - l > 1) {
    int m = (l + r) >> 1;
    if (bsN[m] == tr)
      l = r = m;
    else if (bsN[m] < tr)
      l = m;
    else
      r = m;
  }
  if (bsN[l] >= tr) return l;
  return r;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    int arr1[n];
    int arr2[m];
    vector<pair<int, int>> evntPos;
    vector<pair<int, int>> evntNeg;
    set<int> s;
    for (int i = 0; i < n; i++) {
      cin >> arr1[i];
      s.insert(arr1[i]);
      if (arr1[i] < 0) {
        evntNeg.push_back({-arr1[i], 1});
      } else {
        evntPos.push_back({arr1[i], 1});
      }
    }
    int ansL = 0;
    int mxL = 0;
    int tL = 0;
    int ansR = 0;
    int mxR = 0;
    int tR = 0;
    bsN.clear();
    bsP.clear();
    for (int i = 0; i < m; i++) {
      cin >> arr2[i];
      if (arr2[i] < 0) {
        bsN.push_back(-arr2[i]);
        evntNeg.push_back({-arr2[i], 2});
      } else {
        bsP.push_back(arr2[i]);
        evntPos.push_back({arr2[i], 2});
      }
      if (s.count(arr2[i])) {
        if (arr2[i] < 0) {
          ansL++;
          evntNeg.push_back({-arr2[i], -1});
        } else {
          ansR++;
          evntPos.push_back({arr2[i], -1});
        }
      }
    }
    reverse(bsN.begin(), bsN.end());
    mxL = max(ansL, mxL);
    mxR = max(ansR, mxR);
    sort(evntPos.begin(), evntPos.end());
    sort(evntNeg.begin(), evntNeg.end());
    for (auto t : evntNeg) {
      if (t.second == -1)
        ansL--;
      else if (t.second == 1)
        tL++;
      else {
        if (tL == 0) continue;
        int ind1 = bs2(t.first - tL + 1);
        int ind2 = bs2(t.first);
        int d = ind2 - ind1 + 1;
        mxL = max(ansL + d, mxL);
      }
    }
    for (auto t : evntPos) {
      if (t.second == -1)
        ansR--;
      else if (t.second == 1)
        tR++;
      else {
        if (tR == 0) continue;
        int ind1 = bs1(t.first - tR + 1);
        int ind2 = bs1(t.first);
        int d = ind2 - ind1 + 1;
        mxR = max(ansR + d, mxR);
      }
    }
    cout << mxL + mxR << "\n";
  }
}