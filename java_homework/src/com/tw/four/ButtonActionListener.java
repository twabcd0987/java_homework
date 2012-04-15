package com.tw.four;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;

public class ButtonActionListener extends SelectionAdapter{

	@Override
	public void widgetSelected(SelectionEvent e) {
		try{
		// TODO Auto-generated method stub
		
		Button bt=(Button) e.widget;
		String tmp=bt.getText().trim();
		Calculator.sb.append(tmp);
		Calculator.exp.setText(Calculator.sb.toString());
	}catch(Exception e1){
		e1.printStackTrace();
	}
	}
	
}
