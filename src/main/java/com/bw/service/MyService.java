package com.bw.service;

import java.util.List;
import java.util.Map;

import com.bw.pojo.Brand;
import com.bw.pojo.Goods;
import com.bw.pojo.Kind;

public interface MyService {
	List<Goods> queryGoods(Map<String,Object> map);

	List<Brand> queryBrand();

	List<Kind> queryKind();

	void add(Goods goods);
}
