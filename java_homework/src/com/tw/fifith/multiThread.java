package com.tw.fifith;

import java.awt.EventQueue;

import javax.swing.*;

public class multiThread {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				JFrame f=new JFrame();
				
				JScrollPane scrollPane=new JScrollPane(MyRunnable.jta);
				f.add(MyRunnable.jta);
				f.setVisible(true);
				f.setSize(400,400);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		new Thread(new MyRunnable(MyRunnable.jta,1)).start();
		new Thread(new MyRunnable(MyRunnable.jta,2)).start();
		
		
	}

}
