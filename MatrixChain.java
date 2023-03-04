// Given the dimension of a sequence of matrices in an array arr[], where the 
// dimension of the ith matrix is (arr[i-1] * arr[i]), the task is to find the 
// most efficient way to multiply these matrices together such that the total 
// number of element multiplications is minimum.

// Input: arr[] = {40, 20, 30, 10, 30}
// Output: 26000

// Explanation:There are 4 matrices of dimensions 40×20, 20×30, 30×10, 10×30.
// Let the input 4 matrices be A, B, C and D.
// The minimum number of  multiplications are obtained by 
// putting parenthesis in following way (A(BC))D.
// The minimum is 20*30*10 + 40*20*10 + 40*10*30

// Input: arr[] = {1, 2, 3, 4, 3}
// Output: 30


import java.util.*;

class MatrixChain {

	static int MatrixChainOrder(int p[], int i, int j)	{
		if (i == j)
			return 0;

		int min = Integer.MAX_VALUE;

		for (int k = i; k < j; k++) {
			int count = MatrixChainOrder(p, i, k) + MatrixChainOrder(p, k + 1, j) + p[i - 1] * p[k] * p[j];

			if (count < min)
				min = count;
		}
		return min;
	}
	public static void main(String args[]) {
		int arr[] = new int[] { 1, 2, 3, 4, 3 };
		int N = arr.length;
		System.out.println( "Minimum number of multiplications is " + MatrixChainOrder(arr, 1, N - 1));
	}
}
