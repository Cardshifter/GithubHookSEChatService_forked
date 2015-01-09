
package com.skiwi.githubhooksechatservice.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skiwi.githubhooksechatservice.chatbot.ChatBot;
import com.skiwi.githubhooksechatservice.mvc.beans.MessageBean;

/**
 *
 * @author Frank van Heeswijk
 */
@Controller
@RequestMapping("/bot")
public class BotController {
	@Autowired
	private ChatBot chatBot;
	
	@Autowired
	private MessageBean debug;
	
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        System.out.println("test");
        return "Hello World!";
    }

    @RequestMapping(value = "/debug", method = RequestMethod.GET)
    @ResponseBody
    public String debug() {
    	return String.join("<br>\n", debug.retreiveDebug());
    }

    @RequestMapping(value = "/debugclear", method = RequestMethod.GET)
    @ResponseBody
    public String debugClear() {
    	debug.reset();
    	return "Cleared";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public void test(WebhookParameters params) {
        chatBot.postMessage(params, "test");
    }

    @RequestMapping(value = "/say/{text}", method = RequestMethod.GET)
    @ResponseBody
    public void say(WebhookParameters params, final @PathVariable("text") String text) {
        chatBot.postMessage(params, text);
    }
}
