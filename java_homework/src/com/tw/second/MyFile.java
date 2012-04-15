package com.tw.second;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MyFile {
	private static ArrayList<MyWord> wordList = new ArrayList<MyWord>();
	private Scanner in;
	private static int sum=0;
	public MyFile(Scanner in ){
		this.in=in;
	}
	//逐个单词的读入，首先排除掉非英文单词，
	//然后对英文单词进行比较，
	//如果wordlist中已经存在了，则times++，否则在wordlist中新增一项
	public void compareWord(){
		System.out.println("start");
		while (this.in.hasNext()) {
			String tmp = in.next();
			String regex = "[[a-z]|[A-Z]]+";
			sum++;
			if (!tmp.matches(regex))
				continue;
			int i = 0;
			for (; i < wordList.size(); i++) {
				if (wordList.get(i).getWord().equalsIgnoreCase(tmp)) {
					wordList.get(i).addTimes();
					break;
				}
			}
			if (i == wordList.size()) {
				MyWord mw = new MyWord(tmp);
				wordList.add(mw);
			}
		}
	}
	
	//测试函数
	public static void main(String[] args) {
		ArrayList<MyWord> wordList = MyFile.wordList;
		try {
			Scanner in = new Scanner(new File("2.txt"));
			MyFile mf=new MyFile(in);
			mf.compareWord();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("sum == "+sum);
			for (MyWord e : wordList)
				System.out.print(e);
		}
	}
}