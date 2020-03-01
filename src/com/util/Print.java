package com.util;

import java.util.Arrays;

public class Print {
	
	public static void print(Object obj) {
		int dimension = getDimension(obj);
		print(obj,dimension);
	}
	public static void print(Object obj,int dimension) {
		if(dimension == 0) {
			System.out.println(obj);
		}
		else if(dimension == 1) {
			System.out.println(Arrays.toString((Object [])obj));
		}
		else {
			Arrays.stream((Object [])obj).forEach(x->{
				print((Object [])x,dimension-1);
			});
		}
	}
//	Returns Dimensions of a Object
	private static int getDimension(Object obj) {
		return obj.getClass().getName().lastIndexOf('[')+1;
	}
}
