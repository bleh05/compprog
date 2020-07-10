#include <bits/stdc++.h>

#define forn(i, n) for (int i = 0; i < int(n); i++)

using namespace std;

const int N = 200 * 1000 + 13;
const int LOGN = 30;

int n;
int a[N], pr[N];
int base[LOGN];

void try_gauss(int v){
	for(int i = LOGN - 1; i >= 0; i--)
		if (base[i] != -1 && (v & (1 << i)))
			v ^= base[i];
	if (v == 0)
		return;
	for(int i = LOGN - 1; i >= 0; i--) if (v & (1 << i)){
		base[i] = v;
		return;
	}
}

int main() {
	scanf("%d", &n);
	forn(i, n)
		scanf("%d", &a[i]);
	memset(base, -1, sizeof(base));
	forn(i, n){
		pr[i + 1] = pr[i] ^ a[i];
		try_gauss(pr[i + 1]);
	}
	if (pr[n] == 0){
		puts("-1");
		return 0;
	}
	int siz = 0;
	forn(i, LOGN)
		siz += (base[i] != -1);
	printf("%d\n", siz);
}