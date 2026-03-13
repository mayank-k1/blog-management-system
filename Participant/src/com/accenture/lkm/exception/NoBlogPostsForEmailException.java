package com.accenture.lkm.exception;

public class NoBlogPostsForEmailException extends Exception {
	public NoBlogPostsForEmailException(){
		super("No Post exists for entered email");
	}
}
