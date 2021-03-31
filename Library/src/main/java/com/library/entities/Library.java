package com.library.entities;

public class Library {
	private int student_id;
	private String name_of_the_student;
	private String book_issued;
	private String email_id;
	private int phone_number;
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getName_of_the_student() {
		return name_of_the_student;
	}
	public void setName_of_the_student(String name_of_the_student) {
		this.name_of_the_student = name_of_the_student;
	}
	public String getBook_issued() {
		return book_issued;
	}
	public void setBook_issued(String book_issued) {
		this.book_issued = book_issued;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public int getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}
	@Override
	public String toString() {
		return "Library [student_id=" + student_id + ", name_of_the_student=" + name_of_the_student + ", book_issued="
				+ book_issued + ", email_id=" + email_id + ", phone_number=" + phone_number + "]";
	}
	public Library(int student_id, String name_of_the_student, String book_issued, String email_id, int phone_number) {
		super();
		this.student_id = student_id;
		this.name_of_the_student = name_of_the_student;
		this.book_issued = book_issued;
		this.email_id = email_id;
		this.phone_number = phone_number;
	}
	public Library() {
		super();
	}
	
	

}
