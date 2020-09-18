/*
 * d.cpp
 *
 *  Created on: 2012-3-6
 *      Author: mac
 */
#include <cstdio>
#include <cstring>
#include <algorithm>
#include <iostream>
#include <climits>
#include <numeric>
#include <vector>
#define foreach(e,x) for(__typeof(x.begin()) e=x.begin();e!=x.end();++e)
#define REP(i,n) for(int i=0;i<n;++i)
using namespace std;

const int MAX_N = 100000 + 10;

int n, m;

struct Edge {
	int a, b, w;
	int id;
	void read() {
		scanf("%d%d%d", &a, &b, &w);
		--a, --b;
	}
	bool operator<(const Edge&e) const {
		return w < e.w;
	}
};

Edge es[MAX_N];

int F[MAX_N];

int fd(int x) {
	return F[x] == x ? x : F[x] = fd(F[x]);
}

string ans[MAX_N];

vector<pair<int, int> > E[MAX_N];

int ord[MAX_N], low[MAX_N];
int mark[MAX_N];
int cur, pt;

void dfs(int u, int pid) {
	ord[u] = low[u] = pt++;
	mark[u] = cur;

	for (vector<pair<int, int> >::iterator e = E[u].begin(); e != E[u].end(); ++e) {
		int t = e->first, id = e->second;
		if (id == pid)
			continue;
		if (mark[t] != cur) {
			dfs(t, id);
			low[u] = min(low[u], low[t]);
		} else {
			low[u] = min(low[u], ord[t]);
		}
	}

	if (pid != -1) {
		if (low[u] == ord[u]) {
			ans[pid] = "any";
		}
	}
}

int main() {
	cin >> n >> m;
	for (int i = 0; i < m; ++i) {
		es[i].read();
		es[i].id = i;
	}
	for (int i = 0; i < n; ++i) {
		F[i] = i;
	}

	sort(es, es + m);

	for (int i = 0, j; i < m; i = j) {
		for (j = i; j < m && es[j].w == es[i].w; ++j)
			;

		for (int k = i; k < j; ++k) {
			Edge&e = es[k];
			if (fd(e.a) == fd(e.b))
				ans[e.id] = "none";
			else
				ans[e.id] = "at least one";
			E[fd(e.a)].clear();
			E[fd(e.b)].clear();
		}

		for (int k = i; k < j; ++k) {
			Edge&e = es[k];
			int a = fd(e.a), b = fd(e.b);
			if (a != b) {
				E[a].push_back(make_pair(b, e.id));
				E[b].push_back(make_pair(a, e.id));
			}
		}

		++cur;

		pt = 0;

		for (int k = i; k < j; ++k) {
			Edge&e = es[k];
			int a = fd(e.a), b = fd(e.b);
			if (a != b) {
				if (mark[a] != cur) {
					dfs(a, -1);
				}
				if (mark[b] != cur) {
					dfs(b, -1);
				}
			}
		}

		for (int k = i; k < j; ++k) {
			Edge&e = es[k];
			int a = fd(e.a), b = fd(e.b);
			F[a] = b;
		}
	}

	for (int i = 0; i < m; ++i) {
		puts(ans[i].c_str());
	}
	return 0;
}
