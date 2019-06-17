package com.ho.springboot;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class MyDataMongo {
	@Id

	private String id;
	
	private String name;
	private String code;
	private String Gender;
	private Date date;

	private int Age;
	private double Height;
	private double Weight;
	private double Basicmetabolic;

	public MyDataMongo(String name, String code, String Gender, int Age, double Height, double Weight) {

		super();
		this.name = name;
		this.code = code;
		this.Gender = Gender;
		this.date = new Date();
		this.Age = Age;
		this.Height = Height;
		this.Weight = Weight;
		if("남자".equals(Gender)) {
			this.Basicmetabolic = 66.47+(13.75*Weight)+(5*Height)-(6.76*Age);
		   }
		else if("여자".equals(Gender)){
			this.Basicmetabolic = 665.1+(9.56*Weight)+(1.85*Height)-(4.68*Age);
		      }
		else {
			System.out.printf("오류입니다.");
		   }
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public double getHeight() {
		return Height;
	}

	public void setHeight(double height) {
		Height = height;
	}

	public double getWeight() {
		return Weight;
	}

	public void setWeight(double weight) {
		Weight = weight;
	}

	public double getBasicmetabolic() {
		return Basicmetabolic;
	}

	public void setBasicmetabolic(double basicmetabolic) {
		Basicmetabolic = basicmetabolic;
	}
}
