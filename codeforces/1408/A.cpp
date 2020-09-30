
// Problem : A. Circle Coloring
// Contest : Codeforces - Grakn Forces 2020
// URL : https://codeforces.com/contest/1408/problem/A
// Memory Limit : 256 MB
// Time Limit : 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t; cin >> t; 
    while(t-- > 0) {
		int n;
		cin >> n;
		int arr[3][n];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < n; j++) {
				cin >> arr[i][j];
			}
		}
		int ans[n];
		for(int i = 0; i < n; i++) {
			if(i == n - 1) {
				for(int j = 0; j < 3; j++) {
					if(arr[j][i] != ans[0] && arr[j][i] != ans[i-1]) {
						ans[i] = arr[j][i];
						break;
					}
				}
			}
			else {
				
				for(int j = 0; j < 3; j++) {
					if(arr[j][i] != ans[i-1]) {
						ans[i] = arr[j][i];
						break;
					}
				}
			}
		}
		for(int x : ans) {
			cout << x << " ";
		}
		cout << endl;
	}
}