package com.accenture.lkm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.bean.BlogBean;
import com.accenture.lkm.exception.NoBlogPostsForEmailException;
import com.accenture.lkm.service.BlogService;

@Controller
public class ListBlogController {

	@Autowired
	private BlogService blogService;

	@RequestMapping("/listPostsForm.html")
	public ModelAndView displaylistPostsForm() throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ListPosts");
		return modelAndView;
	}

	/**
	   To-Do Item 1.12: This method should get the email from the form and invoke appropriate service class method to retrieve posts.
	
	   TODO: Implement the listPosts method:
	     --It should be mapped to the URL: /listBlog.html
	     --It should fetch the user's email address from the form element in NewBlog.jsp page.
	     --It should invoke the getAllPosts method of the blogService to fetch a list of BlogBean objects associated with the provided email.
	     --If the retrieved list of posts is empty, it throws a custom exception (NoBlogPostsForEmailException) to indicate the absence of posts for the given email.
	     --It should create a ModelAndView object to render the view and populate data.
	     --It should Add the list of retrieved posts to the ModelAndView with a key "blogList".
	     --It should Set the view name to "Report" for rendering the list.
	     --Finally,it should return the populated ModelAndView object. 
	*/
	@RequestMapping(value="/listBlog.html")
	public ModelAndView listPosts(@RequestParam("email") String email) throws Exception {
		List<BlogBean> list=blogService.getAllPosts(email);
		ModelAndView modelAndView=new ModelAndView();
		if(list.isEmpty()) {
			throw new NoBlogPostsForEmailException();
		}
		else {
			modelAndView.addObject("blogList", list);
			modelAndView.setViewName("Report");
		}
		return modelAndView;
	}
	
	/**
	   To-Do Item 1.13 : This method should handle the exception when no blog posts are found for the specified email.

	   TODO: Implement the handleNoBlogPostsForEmailException method
	     --Annotate the method with appropriate annotation to indicate it handles NoBlogPostsForEmailException.
	     --It should create a 'ModelAndView' object to render the view and populate data.
	     --It should set the view name to "ExceptionHandlerPage".This view will be responsible for displaying the error message to the user.
	     --It should add the exception message to the ModelAndView object with a key "MESSAGE". This message will be accessible in the view(ExceptionHandlerPage.jsp) for display.
	     --Finally,it should return the populated ModelAndView object. 
	*/

	@ExceptionHandler(value = NoBlogPostsForEmailException.class)
	public ModelAndView handleNoBlogPostsForEmailException(NoBlogPostsForEmailException exception) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("ExceptionHandlerPage");
		modelAndView.addObject("MESSAGE", "Posts does not exists for the entered email");
		return modelAndView;
	}
}
