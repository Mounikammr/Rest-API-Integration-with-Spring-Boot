package com.boot.thirdpartyapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.thirdpartyapi.service.PostService;

@RestController
@RequestMapping("/api")
public class PostController {
	
	@Autowired
	private PostService postservice;
	
	@GetMapping("/getposts")
	public List<Map<String,Object> > getAllPosts()
	{
		return postservice.getPosts();
	}
	
	

}
