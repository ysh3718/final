package com.ho.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ho.springboot.MyDataMongo;
import com.ho.springboot.repositories.MyDataMongoRepository;

@Controller
public class HeloController {

	@Autowired
	MyDataMongoRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {

		mav.setViewName("index");
		mav.addObject("title", "기초대사량 계산기");
		mav.addObject("msg", "스펙을 입력해주세요.");

		Iterable<MyDataMongo> list = repository.findAll();
		mav.addObject("datalist", list);
		return mav;
	}

	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public ModelAndView insert(ModelAndView mav) {
		mav.setViewName("insert");
		return mav;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView form(
			@RequestParam("id") String id, 
			@RequestParam("code") String code,
			@RequestParam("name") String name, 
			@RequestParam("Gender") String Gender,
			@RequestParam("Age") int Age,
			@RequestParam("Height") double Height, 
			@RequestParam("Weight") double Weight,
			ModelAndView mov) 
	{

		MyDataMongo mydata = new MyDataMongo(name, code, Gender, Age, Height, Weight);
		repository.save(mydata);	//db에 값 저장
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("id") String id, ModelAndView mav) {
		mav.setViewName("detail");
		mav.addObject("title", "Detail Page");
		mav.addObject("msg", "상세 조회 및 수정 삭제");

		List<MyDataMongo> list = repository.findById(id);
		mav.addObject("datalist", list);
		return mav;
	}
}
