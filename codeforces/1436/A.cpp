#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    int sum = 0;
    for(int i = 0; i < n; i++) {
    	int c; cin >> c;
    	sum += c;
    }
    if(sum == m) {
    	cout << "YES" << endl;
    }
    else {
    	cout <<"NO" << endl;
    }
  }
}