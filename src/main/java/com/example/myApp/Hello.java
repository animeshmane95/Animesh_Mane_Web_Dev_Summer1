package com.example.myApp;
import javax.persistence.*;
@Entity
public class Hello {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column()
	private String message;
	public int getId() 					{	return id;          }
	public void setId(int id)				{	this.id = id;       }
	public String getMessage()			{	return message;     }
	public void setMessage(String msg)	{	this.message = msg; }

}
