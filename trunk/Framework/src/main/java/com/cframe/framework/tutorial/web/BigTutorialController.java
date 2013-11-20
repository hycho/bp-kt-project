package com.cframe.framework.tutorial.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
@RequestMapping("/tutorial")
public class BigTutorialController {
	static final Logger log = LoggerFactory.getLogger(BigTutorialController.class);
	
	final Map<DeferredResult<String>, String> pushMap = new HashMap<DeferredResult<String>, String>();
	
    @RequestMapping(value = "/big", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
    	log.info("Welcome home! Tutorial Big");
    	return "/tutorial/big/big";
	}
    
    @RequestMapping(value = "/getTypeCount")
	public @ResponseBody Map<String, Object> getTypeCount(HttpSession session) throws IOException {
    	Map<String, Object> result = new HashMap<String, Object>();
    	Configuration config = HBaseConfiguration.create();
        config.set("hbase.master","192.168.56.101");
        config.set("hbase.zookeeper.quorum", "192.168.56.101");
        config.set("hbase.zookeeper.property.clientPort","2181");

        //result.put("get", ScannerProcess.getCountEqualToColumn(config, "log_table", "cf", "rqtp", ".*GET.*"));
        //result.put("post", ScannerProcess.getCountEqualToColumn(config, "log_table", "cf", "rqtp", ".*POST.*"));
        
        result.put("get", 50);
        result.put("post", 41);
        
        return result;
	}
    
    
//////////////////////////////////
    
    private final Map<DeferredResult<String>, Integer> chatRequests = new ConcurrentHashMap<DeferredResult<String>, Integer>();
    
    @RequestMapping(value = "/bigWait", method=RequestMethod.GET)
	@ResponseBody
	public DeferredResult<String> getMessages() {

		final DeferredResult<String> deferredResult = new DeferredResult<String>(null, Collections.emptyList());
		this.chatRequests.put(deferredResult, 1);

		deferredResult.onCompletion(new Runnable() {
			@Override
			public void run() {
				chatRequests.remove(deferredResult);
			}
		});

		return deferredResult;
	}

	@RequestMapping(value = "/bigRun", method=RequestMethod.GET)
	@ResponseBody
	public void postMessage() {
		for (Entry<DeferredResult<String>, Integer> entry : this.chatRequests.entrySet()) {
			entry.getKey().setResult("test1");
		}
	}
    
    /*@Scheduled(fixedRate=5000)
	public void processQueues() {
    	System.out.println("fixedRate=5000");
    	for (Entry<String, DeferredResult<String>> entry : pushMap.entrySet()) {
    		int i = (int) (Math.random()*10);
    		System.out.println("iii = "+i);
    		entry.getValue().setResult(String.valueOf(i));
    	}
	}*/
}