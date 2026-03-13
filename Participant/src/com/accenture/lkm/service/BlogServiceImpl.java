package com.accenture.lkm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.bean.BlogBean;
import com.accenture.lkm.dao.BlogDAOWrapper;
import com.accenture.lkm.exception.MaxAllowedEntriesReachedException;

@Service
public class BlogServiceImpl implements BlogService {
	
    @Autowired
	private BlogDAOWrapper dao;
   
    static final int LIMIT=5;
    
    /**
	   To-Do Item 1.7: This method should add a new blog entry to the database.
	   TODO: Implement the addblog method: 
	     -It should use the BlogDAOWrapper reference to call countPostsByEmail method. 
	     -Check if the number of posts associated with the provided email address is less than LIMIT. 
	     -If yes, call the addblog method of the blogDAOWrapper to add the blog post.Store the returned blogId. 
	     -If no, throw a MaxAllowedEntriesReachedException.
	     -Create custom MaxAllowedEntriesReachedException class in package com.exception with an error message “User cannot enter more than 5 Blog entries”.
	     -Finally,method should return newly generated BlogId. 
	 */
	
	public int addBlog(BlogBean blog) throws Exception {
		long count=dao.countPostsByEmail(blog.getEmail());
		int id=0;
		if(count<LIMIT) {
			id=dao.addblog(blog);
		}
		else {
			throw new MaxAllowedEntriesReachedException("User cannot enter more than 5 Blog entries");
		}
		return id;
	}

	public List<BlogBean> getAllPosts(String email) throws Exception {
		List<BlogBean> blogBeans = dao.findPostsByEmail(email);
		return blogBeans;
	}

	@Override
	public Map<String, String> populateTheme() {
		return dao.populateTheme();
	}
	
	
}
