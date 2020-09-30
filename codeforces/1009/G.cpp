#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int ch[100005][7];
int freq[6];
int frqmsk[64];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    string s; cin >> s;
	int n; cin >> n;
	int c = (int) s.size();
	for(int i = 0; i < n; i++) {
		int ind; cin >> ind;
		ind--;
		string s; cin >> s; 
		int cd = (int)s.size();
		ch[ind][6]++;
		for(int j = 0; j < cd; j++) {
			ch[ind][s[j] - 'a']++;
		}
		for(int k = 1; k < 64; k++) {
			for(int j = 0; j < 6; j++) {
				if(ch[ind][j] && (k & (1<<j)) == 0) {
					break;
				} 
				if(j == 5) 
					frqmsk[k]++;
			}
		}
	}
	for(int i = 0; i < c; i++) {
		freq[s[i]-'a']++;
	}
	char ans[c];
	for(int i = 0; i < c; i++) {
		if(ch[i][6]) {
			for(int k = 1; k < 64; k++) {
				for(int l = 0; l < 6; l++) {
					if(ch[i][l] && (k & (1<<l)) == 0) {
						break;
					} 
					if(l == 5) 
						frqmsk[k]--;
				}
			}
		}
		for(int tryc = 0; tryc < 6; tryc++) {
			if((ch[i][6] && !ch[i][tryc]) || freq[tryc] == 0) { 
				if(tryc == 5) {
					cout << "Impossible" << endl;
					return 0;
				}
				continue;
			}
			bool flag = true;
			for(int msk = 1; msk < 64; msk++) {
				int sum = 0;
				for(int l = 0; l < 6; l++) {
					if(msk & (1<<l)) {
						sum += freq[l];
						if(l == tryc) sum--;
					}
				}
				if(sum < frqmsk[msk]) {
					flag = false;
				}
			}
			if(flag) {
				freq[tryc]--;
				ans[i] = 'a' + tryc;
				break;
			}
			else if(tryc == 5) {
				cout << "Impossible" << endl;
				return 0;
			}
		}
	}
	for(char x : ans) {
		cout << x;
	}
	cout << endl;
}