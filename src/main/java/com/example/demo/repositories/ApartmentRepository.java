package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Apartment;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {

	//	検索機能のクエリの設定
	//	idからデータを検索する
	public Optional<Apartment> findById(int id);

	//	名前からデータを検索する
	public List<Apartment> findByName(String key);

	//	名前の曖昧検索機能
	public List<Apartment> findByNameLike(String key);

	//	全検索
	public List<Apartment> findAll();

}
