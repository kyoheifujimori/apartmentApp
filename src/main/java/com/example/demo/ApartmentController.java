package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.ApartmentDataInterface;
import com.example.demo.data.ApartmentDataService;
import com.example.demo.model.Apartment;

@RestController
public class ApartmentController {

	@Autowired
	ApartmentDataService service;

	//	dbの内容を全取得し、json形式で返している
	@GetMapping("/")
	@CrossOrigin
	public List<? extends ApartmentDataInterface> index() {
		System.out.println("/index");
		return service.getAll();
	}

	//	dbの内容を全取得し、json形式で返している
	@GetMapping("/apartment")
	@CrossOrigin
	public List<? extends ApartmentDataInterface> apartment() {
		System.out.println("apartment/index");
		return service.getAll();
	}

	//	urlにidが渡されたら、そのidに一致するデータをjson形式で返している
	@GetMapping("/apartment/{id}")
	@CrossOrigin
	public ApartmentDataInterface apratmentById(@PathVariable int id) {
		System.out.println("aprtment/findById");
		return service.getById(id);
	}

	//	フロントエンドからpost通信でadd処理が来たら対応する
	@PostMapping("/apartment/add")
	@CrossOrigin
	public int add(@RequestBody Apartment apartment) {
		System.out.println("apartment/update(post)");
		//		serviceのadd機能を参照し、dbへの追加を行う
		return service.add(apartment);
	}

	//	フロントエンドからpost通信でupdate処理が来たら対応する
	@PostMapping("/apartment/update")
	@CrossOrigin
	public int update(@RequestBody Apartment apartment) {
		System.out.println("apartment/update(post)");
		//		serviceのadd機能を参照し、dbへの追加を行う
		return service.add(apartment);
	}

	//	フロントエンドからのpost通信でdelete処理が来たら対応する
	@PostMapping("/apartment/delete")
	@CrossOrigin
	public void delete(@RequestBody Apartment apartment) {
		System.out.println("apartment/delete(post)");
		//		serviceのdelete機能を参照し、dbのデータの削除を行う
		service.delete(apartment);
	}

	//	フロントエンドからのpost通信でfind処理が来たら対応する
	@PostMapping("/apartment/find")
	@CrossOrigin
	public List<? extends ApartmentDataInterface> find(@RequestParam("find") String find) {
		System.out.println("apartment/find(post)");
		//		serviceのfind機能を参照し、dbからのデータの検索を行う
		return service.findByNameLike(find);
	}
}
