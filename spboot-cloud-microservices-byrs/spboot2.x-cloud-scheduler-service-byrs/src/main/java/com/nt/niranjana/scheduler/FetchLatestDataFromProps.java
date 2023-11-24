package com.nt.niranjana.scheduler;




import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FetchLatestDataFromProps 
{

	//@Scheduled(cron="*/10 * * * * *")  //every 10 second
	@Scheduled(cron="0 */10 * * * *")  //every 10 minutes
	public void fetch()
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<String>("{}",headers);
		
		RestTemplate rt  = new RestTemplate();
		String output = rt.postForEntity("http://win10--dev01:7070/actuator/refresh", entity, String.class).getBody();
		System.out.println(output);
		
	}
}
