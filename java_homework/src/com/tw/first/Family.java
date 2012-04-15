package com.tw.first;

import java.util.ArrayList;

public class Family {
	public Family(Person father,Person mother,ArrayList<Person> children){
		this.father=father;
		this.mother=mother;
		this.children=children;
	}
	public String getFatherName(){
		return "father's name:"+father.getName();
	}
	public String getMatherName(){
		return "mather's name:"+mother.getName();
	}
	public String getFatherAge(){
		return "father's Age:"+father.getAge();
	}
	public String getMatherAge(){
		return "mather's Age:"+mother.getAge();
	}
	
	public String  getChildAge(int num){
		return children.get(num).getAge()+"";
	}
	public String getChildName(int num){
		return children .get(num).getName();
	}
	public void setFatherName(String name){
		if(father!=null)
		{father.setName(name);}
		else
			System.out.println("father not exist");
	}
	public void setFatherAge(int age){
		if(father!=null)
		{father.setAge(age);}
		else
			System.out.println("father not exist");
	}
	public void setMotherName(String name){
		if(mother!=null)
		{mother.setName(name);}
		else
			System.out.println("mother not exist");
	}
	public void setMotherAge(int age){
		if(mother!=null)
		{mother.setAge(age);}
		else
			System.out.println("mother not exist");
	}
	public void setChildName(int num,String name){
		if(num>children.size()){
			System.out.println("child not exist");
		}
		else
			children.get(num).setName(name);
	}
	public void setChildAge(int num,int age){
		if(num>children.size()){
			System.out.println("child not exist");
		}
		else
			{children.get(num).setAge(age);System.out.println("succeed to set");}
	}
	public boolean addChild(Person child){
		int origin_size,new_size;
		origin_size=children.size();
		children.add(child);
		new_size=children.size();
		if(origin_size+1==new_size){
			return true;
		}
		else
			return false;
	}
	public void deleteChild(int num	) throws invalidException{
		if(num>children.size())
			throw new invalidException("over size!");
		else
		{
			String child_name=children.get(num).getName();
			children.remove(num);
			System.out.println("the child  "+child_name+"  is delete!");
		}
	}
	public int  averageAge(){
		int sum=0;
		for(int i=0;i<children.size();i++){
			sum+=children.get(i).getAge();
		}
	return sum/children.size();
	}
	
	public String toString(){
		StringBuffer sb=new StringBuffer();
		sb.append("father:  ");
		sb.append(father.toString()+'\n');
		sb.append("mother:  ");
		sb.append(mother.toString()+'\n');
		for(int i=0;i<children.size();i++){
			sb.append("child "+i+"  "+children.get(i).toString());
			sb.append('\n');
		}
		return sb.toString();
	}
	private Person father;
	private Person mother;
	private ArrayList<Person> children;
	public static void main(String[]argv){
		Person father=new Person();
		Person mother=new Person();
		Person child_Fir=new Person();
		Person child_sec=new Person();
		ArrayList<Person> children=new ArrayList<Person>();
		children.add(child_Fir);
		children.add(child_sec);
		Family family=new Family(father,mother,children);
		family.setFatherAge(50);
		family.setFatherName("Father_Name");
		family.setMotherName("Mother_Name");
		family.setFatherAge(49);
		family.setChildAge(0, 20);
		family.setChildName(0, "child_Fir_Name");
		family.setChildAge(1, 11);
		family.setChildName(1,"child_Sec_Name");
		Person newChild=new Person();
		newChild.setName("newChild Name");
		newChild.setAge(7);
		family.addChild(newChild);
		//family.deleteChild(2);
		System.out.println("the average age of children is "+family.averageAge());
		System.out.println(family);
		try{
		family.deleteChild(2);
		System.out.println();
		}catch(Exception e){
			e.printStackTrace()	;
		}
		System.out.println(family);
	}
}
