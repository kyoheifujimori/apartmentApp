package com.example.demo.data;

import java.sql.Date;

public interface ApartmentDataInterface {

	//	dbのデータ構造を定義する(getter,setter)
	public int getId();

	public void setId(int id);

	public String getName();

	public void setName(String name);

	public String getAddress();

	public void setAddress(String address);

	public String getSalesrep();

	public void setSalesrep(String salesrep);

	public float getFloorarea();

	public void setFloorarea(float floorarea);

	//	時刻は表示のみなのでgetterのみ
	public Date getRegisterdate();

}
