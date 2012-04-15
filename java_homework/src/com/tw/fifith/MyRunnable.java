package com.tw.fifith;

import java.awt.EventQueue;

import javax.swing.JTextArea;

public class MyRunnable implements Runnable {
	public MyRunnable(JTextArea jta, int num) {
		super();
		this.num = num;
	}

	public static JTextArea jta = new JTextArea(8, 20);
	private int num;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 10;
		while (i > 0) {
			i--;
			try{
			EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					MyRunnable.jta.append("我是线程" + num + '\n');
					
						
				}
			});
			//Thread.sleep(500*num);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
