package colo.spring.cloud.feign;

import feign.RequestLine;

public interface INotificationMessageCounter {
	
    @RequestLine("GET")
    String greeting();

}
