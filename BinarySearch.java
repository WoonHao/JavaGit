package woon.Hao;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.plaf.synth.SynthSpinnerUI;

/**
 * @author 闻增豪
 * @time 2017年2月19日 下午8:45:06
 * @version 
 * 类说明：
 */
public class BinarySearch {
	public static void main(String[] args) {
		ArrayList<Integer> a = new  ArrayList<Integer>();
		addIntegerInSequence(a, 1, 10);
		print(a);
		int pos = binarySearch(a, 10);
		if(pos!=-1){
			System.out.println("Element found:"+pos);
		}else{
		    System.out.println("Element not found");
		}
	}
   /**
    * 
    * @param a
    * @param value 代查找的元素
    * @return
    */
	public static int binarySearch(ArrayList<Integer> a,int value){
		int size = a.size();
		int low = 0,high=size-1;
		int mid;
		while(low<=high){
			mid = (low+high)/2;
			if(a.get(mid)<value){
				low  = low +1;
			}else if(a.get(mid)>value){
				high = high - 1;
			}else{
				return mid;
			}
		}
		return -1;
	}
	/**
	 * 填充顺序元素到数组
	 * @param a
	 * @param begin 开始元素
	 * @param size
	 */
	public static void addIntegerInSequence(ArrayList<Integer> a,int begin,int size){
		   for(int i=begin;i<begin+size;i++){
			   a.add(i);
		   }
	   }
	/**
	 * 打印数组
	 * @param a
	 */
	public static void print(ArrayList<Integer>a){
		Iterator<Integer> i= a.iterator();
		while(i.hasNext()){
			System.out.print(i.next()+" ");
		}
		System.out.println("");
	}
}
   
