package com.tw.four;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Calculator {
	public static StringBuffer sb=new StringBuffer();
	public static Text exp;
	public static Text res;
	public Calculator(){
		dis=new Display();
		sh=new Shell(dis);
		sh.setSize(400, 400);
		GridLayout grid=new GridLayout();
		grid.makeColumnsEqualWidth=true;
		grid.numColumns=4;
		sh.setLayout(grid);
		exp=new Text(sh,SWT.LEFT);
		GridData expData=new GridData();
		expData.horizontalSpan=4;
		exp.setLayoutData(expData);
		res=new Text(sh,SWT.RIGHT);
		GridData resData=new GridData();
		resData.horizontalSpan=3;
		res.setLayoutData(resData);
		Button equal=new Button(sh,SWT.PUSH);
		equal.setText("=");
		equal.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				
				res.setText(Double.toString(C.cacComplex(sb.toString())));
			}
		});
		Button b1=new myButton(sh,SWT.PUSH," 1 ");		
		Button b2=new myButton(sh,SWT.PUSH," 2 ");
		Button b3=new myButton(sh,SWT.PUSH," 3 ");
		Button b0=new myButton(sh,SWT.PUSH," 0 ");
		Button b4=new myButton(sh,SWT.PUSH," 4 ");
		Button b5=new myButton(sh,SWT.PUSH," 5 ");
		Button b6=new myButton(sh,SWT.PUSH," 6 ");
		Button clear=new Button (sh,SWT.PUSH);
		clear.setText("clear");
		clear.addSelectionListener(new SelectionAdapter(){
		public void widgetSelected(SelectionEvent e){ 
			sb.delete(0, sb.length());
			exp.setText("");
			res.setText("");
		}
		});
		Button b7=new myButton(sh,SWT.PUSH," 7 ");
		Button b8=new myButton(sh,SWT.PUSH," 8 ");
		Button b9=new myButton(sh,SWT.PUSH," 9 ");
		Button exit=new Button(sh,SWT.PUSH);
		exit.setText("exit");
		exit.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				calculatorClose();
			}
		});
		Button add=new myButton(sh,SWT.PUSH," + ");
		Button sub=new myButton(sh,SWT.PUSH," - ");
		Button mul=new myButton(sh,SWT.PUSH," * ");
		Button div=new myButton(sh,SWT.PUSH," / ");
		sh.pack();
		sh.open();
		while(!sh.isDisposed()){
			if(!dis.readAndDispatch()){
				dis.sleep();
			}
		}
	}
	
	public  void calculatorClose(){
		dis.close();
	}

	private Display dis;
	private Shell sh;
	
}
