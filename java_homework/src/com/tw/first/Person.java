package com.tw.first;

public class Person {
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name){
		this.name=name;
	}
	public String toString(){
		return "name:  "+name+"    age:  "+age;
	}
}
