package com.example.demo.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Apartment;
import com.example.demo.repositories.ApartmentRepository;

@Service
public class ApartmentDataService {

	@Autowired
	private ApartmentRepository repository;

	//	dbの情報を全取得する
	public List<? extends ApartmentDataInterface> getAll() {
		System.out.println("Service:getAll");
		return repository.findAll();
	}

	//	idに合致したデータをdbから取得する
	public ApartmentDataInterface getById(int id) {
		System.out.println("Service:getById id[" + id + "]");
		return repository.findById(id).orElse(null);
	}

	//	検索機能
	public List<? extends ApartmentDataInterface> findByNameLike(String find) {
		System.out.println("Service:getByNameLike find[" + find + "]");
		//		%を前後につけると前後のあいまい検索になる
		return repository.findByNameLike("%" + find + "%");
	}

	//	post通信によるadd機能（resufull）
	public int add(ApartmentDataInterface item) {
		System.out.println("Service:add {" + item + "]");
		//		itemの中身が入っていたら
		if (item instanceof Apartment) {
			//			dbへの保存とエンティティの保存を行う
			Apartment savedItem = repository.saveAndFlush((Apartment) item);
			//			保存したものを返す
			return savedItem.getId();
		}
		//		なんもない場合は0を返す
		return 0;
	}

	//	post通信によるdelete機能（resutfull）
	public void delete(ApartmentDataInterface item) {
		System.out.println("Sevice:delete [" + item + "]");
		if (item instanceof Apartment) {
			repository.delete((Apartment) item);
		}
	}
}
