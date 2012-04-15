package com.tw.second;

public class MyWord {
		private String word;      //单词
		private int times;			//单词出现的次数
		public MyWord(String word){
			this.word=word;
			this.times=1;
		}
		public int getTimes() {
			return times;
		}
		public String getWord(){
			return word;
		}
		public void addTimes(){
			times++;
		}
		public String toString(){
			return word+"  "+times+'\n';
		}
}
