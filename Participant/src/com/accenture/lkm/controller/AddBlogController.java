package com.accenture.lkm.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.bean.BlogBean;
import com.accenture.lkm.exception.MaxAllowedEntriesReachedException;
import com.accenture.lkm.service.BlogService;

@Controller
public class AddBlogController {

	@Autowired
	private BlogService blogService;

	@RequestMapping("/home.html")
	public ModelAndView displayHomePage() throws Exception {
		ModelAndView mView = new ModelAndView();
		mView.setViewName("Home");
		return mView;
	}

	@RequestMapping("/newBlogForm.html")
	public ModelAndView displayAddBlogForm() throws Exception {

		ModelAndView mView = new ModelAndView("NewBlog", "blog", new BlogBean());
		return mView;
	}

	/**
	   To-Do Item 1.9 : This method should be executed before any handler method of this controller and should return themes to be populated dynamically in the form.
	  
	   TODO: Implement the populateTheme method:
	    -It should invoke the populateTheme method of service class 
	  
	 */
	@ModelAttribute(value="ThemesList")
	public Map<String, String> populateTheme() {
		return blogService.populateTheme();
	}
  /**
	 To-Do Item 1.10: This method should get all details from the form and invoke appropriate service class method to save the post.

	 TODO: Implement the addblog method:
	  --It should be mapped to the URL: /addBlog.html
	  --It should bind form data to the BlogBean.
	  --It should check for any form validation errors.
	  --If validation fails,In the ModelAndView set the view name to "NewBlog" to display validation messages to the user..
	  --If validation is successful:
	   -Invoke the addBlog method of service class by passing the BlogBean
	   -Store the returned blogId.
	   -In the ModelAndView, set the view to "NewBlog" and display "Blog Added Successfully" with the blog ID.
	  --Finally, method should return ModelAndView object with appropriate data.
	*/


	@RequestMapping(value="/addBlog.html")
	public ModelAndView addBlog(@Valid @ModelAttribute("blog") BlogBean blogBean,BindingResult bindingResult) throws Exception {
		ModelAndView modelAndView=new ModelAndView();
		if(bindingResult.hasErrors()) {
			modelAndView.setViewName("NewBlog");
		}
		else {
			int id=blogService.addBlog(blogBean);
			modelAndView.setViewName("NewBlog");
			modelAndView.addObject("MESSAGE", "Blog Added Successfully:"+id);
		}
		return modelAndView;
	}

	/**
	Requirement 1.11: TThis method should handles the exception when maximum allowed number of blog entries is reached.

	TODO: Implement the handleMaxAllowedEntriesReachedException method
	  --Annotate the method with appropriate annotation to indicate it handles MaxAllowedEntriesReachedException.
	  --It should create a 'ModelAndView' object to render the view and populate data.
	  --It should set the view name to "ExceptionHandlerPage".This view will be responsible for displaying the error message to the user.
	  --It should add the exception message to the ModelAndView object with a key "MESSAGE". This message will be accessible in the view(ExceptionHandlerPage.jsp) for display.
	  --Finally,it should return the populated ModelAndView object. 
	*/

	@ExceptionHandler(value=MaxAllowedEntriesReachedException.class)
	public ModelAndView handleMaxAllowedEntriesReachedException(MaxAllowedEntriesReachedException exception) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("ExceptionHandlerPage");
		modelAndView.addObject("MESSAGE", "User cannot enter more than 5 Blog entries");
       return modelAndView;
	}
	


}
