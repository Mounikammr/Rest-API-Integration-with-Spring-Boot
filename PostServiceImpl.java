package com.boot.thirdpartyapi.service;

import java.awt.PageAttributes.MediaType;
import java.net.http.HttpHeaders;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.val;

@Service
public class PostServiceImpl implements PostService {

	String baseurl="https://jsonplaceholder.typicode.com/";
	StringBuilder sb=new StringBuilder(baseurl);
	@Autowired
	private RestTemplate resttemplate;
	
	String post="posts";
	@Override
	public List<Map<String, Object>> getPosts() {
		HttpEntity<Void> httpentity=HttpEntity<>(gethttpHeaders());
		String url=sb.append(post).toString();
		val response= resttemplate.exchange(url,HttpMethod.GET,httpentity,List.class);
		return  response.getBody();
	}
	private HttpHeaders gethttpHeaders()
	{
		HttpHeaders hh=new HttpHeaders();
		hh.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		hh.setContentType(MediaType.APPLICATION_JSON);
		
		return hh;
		
	}

}
