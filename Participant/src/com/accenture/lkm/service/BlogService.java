package com.accenture.lkm.service;

import java.util.List;
import java.util.Map;

import com.accenture.lkm.bean.BlogBean;

public interface BlogService {
	public int addBlog(BlogBean blog)throws Exception;
	public List<BlogBean> getAllPosts(String email)throws Exception;
	public Map<String, String> populateTheme();
}
