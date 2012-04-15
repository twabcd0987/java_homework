package com.tw.four;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.*;

public class myButton extends Button{
	public myButton(Shell sh,int style,String type){
		super(sh,style);
		this.setText(type);
		this.addSelectionListener(new ButtonActionListener());
	}
	//如果没有这个函数，会出现subclass not allowed的异常
	public void checkSubclass(){
		
	}
	
}
