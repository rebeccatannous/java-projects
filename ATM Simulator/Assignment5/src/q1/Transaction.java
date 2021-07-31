package q1;

import java.time.*;
import java.util.Scanner;

public abstract class Transaction {
	protected LocalTime time;
	protected LocalDate date;
	protected Person person;
	protected String type;
	protected double amount;

	public Transaction(Person person,double amount) {
		this.time = LocalTime.now();
		this.date = LocalDate.now();
		this.person = person;
		this.amount=amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public DayOfWeek WeekDay()
	{
		return date.getDayOfWeek();
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	


	public abstract void makeTrans(double money, int a) ;

}
