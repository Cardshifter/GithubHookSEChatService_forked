package com.skiwi.githubhooksechatservice.mvc.beans;

import java.util.ArrayList;
import java.util.List;


public class MessageBean {

	private final List<String> messages = new ArrayList<String>();
	
	public MessageBean() {
	}
	
	public void debug(String mess) {
		messages.add(mess);
	}
	
	public List<String> retreiveDebug() {
		return new ArrayList<String>(messages);
	}
	
	public void reset() {
		messages.clear();
	}
	
}
