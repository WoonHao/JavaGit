package com.woon.zhijiepaixu;
/**
 * @author 闻增豪
 * @time 2017年1月11日 下午10:23:42
 * @version 
 * 类说明：
 */
public class Sort {
	public static void main(String[] args) {
		Sort sort = new Sort();
		sort.insertSort();// 直接排序
		System.out.println();
		double d = 5;
		double ceil = Math.ceil(d / 2);
		System.out.println(ceil);
	}

	// 插入排序--直接排序
	public void insertSort() {
		int a[] = { 45, 34, 36, 67, 54, 78, 43, 77 };
		int temp = 0;
		for (int i = 1; i < a.length; i++) {
			int j = i - 1;
			temp = a[i];
			for (; j >= 0 && temp < a[j]; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = temp;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}

	// 希尔排序
	public void shellSort() {
		int a[] = { 1, 54, 6, 3, 78, 34, 12, 45, 56, 100 };
		double d1 = a.length;
		int temp = 0;
		while (true) {
			d1 = Math.ceil(d1 / 2);
			int d = (int) d1;
			for (int x = 0; x < d; x++) {

				for (int i = x + d; i < a.length; i += d) {
					int j = i - d;
					temp = a[i];
					for (; j >= 0 && temp < a[j]; j--) {
						a[j + d] = a[j];
					}
					a[j + d] = temp;
				}
			}
			if (d == 1) {
				break;
			}
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + "\t");
			}
		}
	}
}
