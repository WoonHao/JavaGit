package com.woon.zhijiepaixu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 闻增豪
 * @time 2017年1月12日 下午9:46:26
 * @version 
 * 类说明：
 */
public class SelectSort {
	public static void main(String[] args) {
		SelectSort ss = new SelectSort();
		/*ss.selectSort();
		System.out.println();*/
		Integer a[] = new  Integer[]{12,13,14,12};
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i = ss.binarySearch(list, 15);
		System.out.println(i);
		
	}
	//简单选择排序
	public void selectSort(){
		int a[] = {1,54,6,78,34,12,45};
		int position = 0;
		for(int i=0;i<a.length;i++){
			int j = i+1;
			position = i;
			int temp = a[i];
			for(;j<a.length;j++){
				if(a[j]<temp){
					temp = a[j];
					position = j;
				}
			}
			a[position] = a[i];
			a[i] = temp;
		}
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"\t");
		}
	}
	
	//二分查抄
	public int binarySearch(ArrayList<Integer> a,int value){
		int size = a.size();
		int low = 0,high = size - 1;
		int mid ;
		while(low<high){
			mid = (low+high)/2;
			if(a.get(mid)<value){
				low = low + 1;
			}
			else if(a.get(mid)>value){
				high = high -1;
			}
			else{
				return mid ;
			}
		}
		return -1;
	}
}
