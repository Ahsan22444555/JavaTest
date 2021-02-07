package com.template.beans;

public class Person {
   private String email;
   private String name;
   private double fee;

public Person(String email, String name, String string) {
	super();
	this.email = email;
	this.name = name;
	this.fee = Double.parseDouble(string);
}

public String getName() {
	return name;
}

public double getFee() {
	return fee;
}

public Person(String email) {
	super();
	this.email = email;
}

public String getEmail() {
	return email;
}
   
}
