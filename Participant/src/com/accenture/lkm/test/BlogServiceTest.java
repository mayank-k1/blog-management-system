package com.accenture.lkm.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accenture.lkm.bean.BlogBean;
import com.accenture.lkm.exception.MaxAllowedEntriesReachedException;
import com.accenture.lkm.service.BlogServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/root-config.xml"})
public class BlogServiceTest {
	
	@Autowired
	private BlogServiceImpl blogService;
	
	/**
	   To-Do Item 1.17 : This method tests the addBlog functionality in BlogServiceImpl ensuring that a blog entry is added only
	   when the number of existing posts for the associated email is less than the defined limit (5 entries in our case).
	   
	   TODO: Implement the testAddBlogWithLessThanFivePosts_Positive method:
	     - It should create a new instance of BlogBean and set its properties (title, content, email, themes) with dummy data.
	     - It should invoke the addblog method of blogDAOWrapper, passing the BlogBean object.
	     - It should verify that a new blog entry has been successfully inserted into the database table.
	 */
	@Test
	public void testAddBlogWithLessThanFivePosts_Positive() throws Exception {
		BlogBean bean=new BlogBean();
		  bean.setTitle("life");
		  bean.setContent("Do what every makes you happy");
		  bean.setEmail("robbin@gmail.com");
		  bean.setThemes("Quote");
		  int id=blogService.addBlog(bean);
		  assertNotNull(id);
	}
	/**
	   To-Do Item 1.18: This method test the addBlog functionality in BlogServiceImpl to ensure that a blog entry is not added
	   when the number of existing posts for the associated email reaches the defined limit (5 entries in our case).
	  
	   TODO: Implement the testAddBlogWithLessThanFivePosts_Negative method:
	    - It should add blog entries for the specified email until the maximum allowed posts (5 in our case) is reached.
	    - It should attempt to add an additional blog entry for the same email.
	    - It ensure that adding the additional blog entry throws a MaxAllowedEntriesReachedException with the message "User cannot enter more than 5 Blog entries".
	 */
	@Test
	public void testAddBlogWithLessThanFivePosts_Negative() throws Exception {
		String email="robbin@gmail.com";
		int count=0;
		BlogBean bean=new BlogBean();
		  bean.setTitle("Do what ever makes you happy");
		  bean.setContent("life");
		  bean.setEmail(email);
		  bean.setThemes("Quote");
		  while(true) {
			  if(count<=5) {
				  blogService.addBlog(bean);
				  count++;
			  }
			  else {
				  assertThrows(MaxAllowedEntriesReachedException.class, ()->{
					  throw new MaxAllowedEntriesReachedException("User cannot enter more than 5 Blog entries");
				  });
			  }
		  }
		  
	}

	/**
	   To-Do Item 1.19: This method test getAllPosts functionality in BlogServiceImpl for retrieving all post associated with a specified email.
	  
	   TODO: Implement the testGetAllPosts method:
	    - It should call the getAllPosts method of blogService with a specified email.
	    - It should assert that the result obtained is not null.
	 */
	@Test
	public void testGetAllPosts() throws Exception {
		String email="jack@gmail.com";
		List<BlogBean> list=blogService.getAllPosts(email);
		assertNotNull(list);
	}
	    
}
