
// Problem: A - Range Product
// Contest: AtCoder - AtCoder Grand Contest 002
// URL: https://atcoder.jp/contests/agc002/tasks/agc002_a
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int a, b;
  cin >> a >> b;
  if(a <= 0 && b >= 0) {
  	cout << "Zero" << endl;
  	exit(0);
  }
  if(b < 0 && (b - a + 1) & 1) {
  	cout << "Negative" << endl;
  }
  else {
  	cout << "Positive" << endl;
  }
}