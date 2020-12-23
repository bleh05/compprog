
// Problem: D - Choosing Points
// Contest: AtCoder - AtCoder Grand Contest 025
// URL: https://atcoder.jp/contests/agc025/tasks/agc025_d
// Memory Limit: 1024 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int n0 = 0;
int n1 = 0;
int n2 = 0;
int n3 = 0;

vector<int> g1[4 * 303 * 303];
vector<int> g2[4 * 303 * 303];
int visA[4 * 303 * 303];
int visB[4 * 303 * 303];

void dfs(int v, int clr) {
  if (visA[v]) return;
  visA[v] = clr;
  for (int x : g1[v]) {
    if (x < 0 || x >= 4 * 303 * 303) {
      continue;
    }
    dfs(x, clr ^ 3);
  }
}
void dfs2(int v, int clr) {
  if (visB[v]) return;
  visB[v] = clr;
  for (int x : g2[v]) {
    if (x < 0 || x >= 4 * 303 * 303) {
      continue;
    }
    dfs2(x, clr ^ 3);
  }
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, d1, d2;
  cin >> n >> d1 >> d2;
  vector<pair<int, int>> md1 = {};
  vector<pair<int, int>> md2 = {};
  for (int i = 0; i * i <= d1; i++) {
    for (int j = 0; j * j <= d1; j++) {
      if (i * i + j * j == d1) {
        md1.push_back({i, j});
      }
    }
  }
  for (int i = 0; i * i <= d2; i++) {
    for (int j = 0; j * j <= d2; j++) {
      if (i * i + j * j == d2) {
        md2.push_back({i, j});
      }
    }
  }
  for (int i = 0; i < 4 * n * n; i++) {
    for (auto x : md1) {
      int nx = i / (2 * n);
      int ny = i % (2 * n);
      if (nx + x.first >= 0 && nx + x.first < 2 * n && ny + x.second >= 0 &&
          ny + x.second < 2 * n)
        g1[i].push_back((nx + x.first) * 2 * n + ny + x.second);
      if (nx - x.first >= 0 && nx - x.first < 2 * n && ny + x.second >= 0 &&
          ny + x.second < 2 * n)
        g1[i].push_back((nx - x.first) * 2 * n + ny + x.second);
      if (nx - x.first >= 0 && nx - x.first < 2 * n && ny - x.second >= 0 &&
          ny - x.second < 2 * n)
        g1[i].push_back((nx - x.first) * 2 * n + ny - x.second);
      if (nx + x.first >= 0 && nx + x.first < 2 * n && ny - x.second >= 0 &&
          ny - x.second < 2 * n)
        g1[i].push_back((nx + x.first) * 2 * n + ny - x.second);
    }
    for (auto x : md2) {
      int nx = i / (2 * n);
      int ny = i % (2 * n);
      if (nx + x.first >= 0 && nx + x.first < 2 * n && ny + x.second >= 0 &&
          ny + x.second < 2 * n)
        g2[i].push_back((nx + x.first) * 2 * n + ny + x.second);
      if (nx - x.first >= 0 && nx - x.first < 2 * n && ny + x.second >= 0 &&
          ny + x.second < 2 * n)
        g2[i].push_back((nx - x.first) * 2 * n + ny + x.second);
      if (nx - x.first >= 0 && nx - x.first < 2 * n && ny - x.second >= 0 &&
          ny - x.second < 2 * n)
        g2[i].push_back((nx - x.first) * 2 * n + ny - x.second);
      if (nx + x.first >= 0 && nx + x.first < 2 * n && ny - x.second >= 0 &&
          ny - x.second < 2 * n)
        g2[i].push_back((nx + x.first) * 2 * n + ny - x.second);
    }
  }
  for (int i = 0; i < 4 * n * n; i++) {
    dfs(i, 1);
    dfs2(i, 1);
  }
  vector<pair<int, int>> pts[4]; 
  for(int i = 0; i < 4 * n * n; i++) {
  	pts[(visA[i] == 1) * 2 + (visB[i] == 1)].push_back({i / (2 * n), i % (2 * n)});
  }
  for(int i = 0; i < 4; i++) {
  	if(pts[i].size() >= n * n) {
  		for(int j = 0; j < n * n; j++) {
  			cout << pts[i][j].first << " " << pts[i][j].second << "\n";
  		}
  		exit(0);
  	}
  }
}