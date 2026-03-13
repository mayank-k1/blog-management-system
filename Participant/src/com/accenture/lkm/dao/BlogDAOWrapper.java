package com.accenture.lkm.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.bean.BlogBean;
import com.accenture.lkm.entity.BlogEntity;

@Repository
@Transactional("txManager")
public class BlogDAOWrapper {
	
@Autowired	
private BlogDAO  blogDAO;
	
	/** 
	  To-Do Item 1.3: This method should add a new blog entry to the database.
	
	  TODO: Implement the addblog method:
	   -It should convert the BlogBean object to a BlogEntity.
	   -It should save the BlogEntity to the database.
	   -It should return the blogId(unique identifier) of the newly added blog entry.
	*/
	public int addblog(BlogBean blog) throws Exception {
		BlogEntity bEntity=convertBeanToEntity(blog);
		bEntity=blogDAO.save(bEntity);
		BlogBean bBean=convertEntityToBean(bEntity);
		return bBean.getBlogId();
	}

	/**
	   To-Do Item 1.4: This method should retrieve a list of blog posts for the entered email address.Posts should be retrieved in alphabetical order of Title.
	   
	   TODO: Implement the findPostsByEmail method:
	     - It should use the blogDAO reference to call its findPostsByEmail method, retrieving blog posts based on the provided email address.
	     - It should convert each retrieved BlogEntity object to a BlogBean object.
	     - It should add the converted BlogBean objects to a list.
	     - It should return a list of BlogBean objects representing the blog posts.
     */

	public List<BlogBean> findPostsByEmail(String email) throws Exception {
		List<BlogBean> listBean=new ArrayList<BlogBean>();
		List<BlogEntity> list=blogDAO.findPostsByEmail(email);
		for(BlogEntity b:list) {
			BlogBean bean=new BlogBean();
			bean=convertEntityToBean(b);
			listBean.add(bean);
		}
		return listBean;
	}

   /** 
      To-Do Item 1.5: This method retrieve the count of blog posts associated with the provided email address.

      TODO: Implement the countPostsByEmail method:
        - It should use the blogDAO reference to call its countPostsByEmail method to retrieve the count of blog posts for the provided email.
        - It should return the count of blog posts as a long value.
   
  */
	public long countPostsByEmail(String email) {
		long count=blogDAO.countPostsByEmail(email);
		return count;
	}
   
  
   /**
      To-Do Item 1.6: This method should return map of below mentioned themes.
     
      TODO:	
       -Populate  the map with below key-value entries:
		1.Key: Daily Journal  Value: Daily Journal
		2.Key: Cheer Up       Value: Cheer Up
		3.Key: Goal           Value: Goal

    */
	public Map<String, String> populateTheme() {
		List<BlogEntity> list=(List<BlogEntity>) blogDAO.findAll();
		Map<String, String> map=new HashMap<String,String>();
		for(BlogEntity b:list) {
			map.put(b.getThemes(), b.getThemes());
		}
		return map;
	}

   public static BlogEntity convertBeanToEntity(BlogBean bean){
		BlogEntity blogEntityBean = new BlogEntity();
		BeanUtils.copyProperties(bean,blogEntityBean);
		return blogEntityBean;
	}
	
   public static BlogBean convertEntityToBean(BlogEntity entity){
		BlogBean blogBean = new BlogBean();
		BeanUtils.copyProperties(entity, blogBean);
		return blogBean;
	}

}
