package com.algorithm.dynamicProgramming;

/*
 * Dr. Patel has N stacks of plates. Each stack contains K plates. Each plate has a positive beauty value, describing how beautiful it looks.
 * Dr. Patel would like to take exactly P plates to use for dinner tonight. If he would like to take a plate in a stack, he must also take all of the plates above it in that stack as well.
 * Help Dr. Patel pick the P plates that would maximize the total sum of beauty values.
*/
import java.util.*;
public class MaximumPlates {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int p = sc.nextInt();
			int k = sc.nextInt();
			int ar[][] = new int[n][p];
			for(int i = 0 ; i<n;i++) {
				for(int j=0;j<p;j++) {
					ar[i][j] = sc.nextInt();
					if(j>0) {
						ar[i][j] += ar[i][j-1];
					}
				}
			}
			int dp[][] = new int[n+1][p+1];
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=p;j++) {
					for(int x = 1;x<=Math.min(k,j);x++)
					dp[i][j] = Math.max(dp[i][j], ar[i][x]+dp[i-1][j-x]);
				}
			}
		}
	}
}
