#include<iostream>
#include<algorithm>
#include<string>
using namespace std;
string s[20000];

bool sort(string a, string b) {
	if (a.size() < b.size())
		return true;
	else if (a.size() > b.size())
		return false;
	else {
		return a < b;
	}
}


int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> s[i];
	}

	sort(s, s+N, sort);

	for (int i = 0; i < N; i++) {
		cout << s[i] << endl;
	}
	cout << endl;
	return 0;
}