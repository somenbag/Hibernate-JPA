package org.jsp.foodorder.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class FoodOrder 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private double cost;
	private String food_items;
	@CreationTimestamp
	private LocalDateTime ordered_id;
	@UpdateTimestamp
	private LocalDateTime del_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getFood_items() {
		return food_items;
	}
	public void setFood_items(String food_items) {
		this.food_items = food_items;
	}
	public LocalDateTime getOrdered_id() {
		return ordered_id;
	}
	public void setOrdered_id(LocalDateTime ordered_id) {
		this.ordered_id = ordered_id;
	}
	public LocalDateTime getDel_time() {
		return del_time;
	}
	public void setDel_time(LocalDateTime del_time) {
		this.del_time = del_time;
	}
	
}
