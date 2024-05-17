package com.example.demo.model;

import java.sql.Date;

import com.example.demo.data.ApartmentDataInterface;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//mysqlとのテーブル連携
@Table(name = "apartment")
public class Apartment implements ApartmentDataInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	//	アパート名
	@Column(nullable = false)
	private String name;

	//	住所
	@Column(nullable = false)
	private String address;

	//	販売員
	@Column(nullable = true)
	private String salesrep;

	//	間取り
	@Column(nullable = true)
	private float floorarea;

	//	登録日
	@Column(nullable = true)
	private Date registerdate;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String getSalesrep() {
		return salesrep;
	}

	@Override
	public void setSalesrep(String salesrep) {
		this.salesrep = salesrep;
	}

	@Override
	public float getFloorarea() {
		return floorarea;
	}

	@Override
	public void setFloorarea(float floorarea) {
		this.floorarea = floorarea;
	}

	@Override
	public Date getRegisterdate() {
		return registerdate;
	}
}
