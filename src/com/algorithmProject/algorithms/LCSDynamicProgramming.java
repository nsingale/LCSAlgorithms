package com.algorithmProject.algorithms;

import com.algorithmProject.interfaces.LCSAlgorithmInterface;


public class LCSDynamicProgramming implements LCSAlgorithmInterface {
	StringBuffer sbf = new StringBuffer();

	public int computeLCS(char[] X, char[] Y) {
		int m, n;
		m = X.length;
		n = Y.length;

		// int noOfRecursiveCalls = 0;
		// Utility u = new Utility();
		int L[][] = new int[m + 1][n + 1];
		char subSequence[][] = new char[m + 1][n + 1];
		int i, j;

		/*
		 * Following steps build L[m+1][n+1] in bottom up fashion. Note that
		 * L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
		 */
		for (i = 0; i <= m; i++) {
			for (j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;

				else if (X[i - 1] == Y[j - 1]) {
					L[i][j] = L[i - 1][j - 1] + 1;
					subSequence[i][j] = 'D';
				}

				else if (L[i - 1][j] >= L[i][j - 1]) {
					L[i][j] = L[i - 1][j];
					subSequence[i][j] = 'N';
				} else {
					L[i][j] = L[i][j - 1];
					subSequence[i][j] = 'W';
				}

			}
		}

		/* L[m][n] contains length of LCS for X[0..n-1] and Y[0..m-1] */
//		String outPut = printLCS(subSequence, X, m, n);
		//System.out.println("Longest common subsequence:" + outPut);
		return L[m][n];

	}

	public String printLCS(char[][] b, char[] X, int m, int n) {

		if (m > 0 && n > 0) {
			if (b[m][n] == 'D') {
				printLCS(b, X, m - 1, n - 1);
				sbf.append(X[m - 1]);

			} else if (b[m][n] == 'N')
				printLCS(b, X, m - 1, n);
			else
				printLCS(b, X, m, n - 1);

		}
		return sbf.toString();
	}

}
