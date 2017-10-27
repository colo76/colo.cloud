package colo.spring.cloud.feign;



import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class Client {

	public static void main(String[] args) {
       INotificationMessageCounter client = Feign.builder().client(new OkHttpClient())
    		   .encoder(new GsonEncoder())
    		   .decoder(new GsonDecoder())
    		   .logger(new Slf4jLogger(INotificationMessageCounter.class))
    		   .logLevel(Logger.Level.FULL).target(INotificationMessageCounter.class,"http://192.168.1.105:36793/greeting");
	
	
       String greetingMsg =  client.greeting();
       
       System.out.println(greetingMsg);
	
	}

}
