package com.bw.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.mapper.MyMapper;
import com.bw.pojo.Brand;
import com.bw.pojo.Goods;
import com.bw.pojo.Kind;
@Service
public class MyServiceImpl implements MyService {
	@Resource
	private MyMapper myMapper;
	
	public List<Goods> queryGoods(Map<String,Object> map) {
		return myMapper.queryGoods(map);
	}

	public List<Brand> queryBrand() {
		return myMapper.queryBrand();
	}

	public List<Kind> queryKind() {
		return myMapper.queryKind();
	}

	public void add(Goods goods) {
		myMapper.add(goods);
	}

}
