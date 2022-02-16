#include<iostream>
#include <algorithm>
#include<string>
using namespace std;
string s[50];

int getSum(string a) {
	int temp = 0;

	for (int i = 0; i < a.length(); i++) {
		if (a[i] - '0' >= 0 && a[i] - '0' <= 9)
			temp += a[i] - '0';
	}
	return temp;
}

bool compare(string a, string b) {
	if (a.length() != b.length())  // 길이가 다른 경우
		return a.length() < b.length();
	else { // 길이가 같은 경우
		int sumA = getSum(a);
		int sumB = getSum(b);
		if (sumA != sumB)
			return sumA < sumB;
		else {
			return a < b;
		}
	}
}

int main(void) {
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int N; cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> s[i];
	}

	sort(s, s + N, compare);
	for (int i = 0; i < N; i++) {
		cout << s[i] << endl;
	}

	return 0;
}