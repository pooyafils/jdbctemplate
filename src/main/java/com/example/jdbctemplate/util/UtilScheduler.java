package com.example.jdbctemplate.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component

public class UtilScheduler {
   // @Scheduled(fixedRate = 2000)
    public void scheduleTask(){
System.out.println("1");
    }
    //@Scheduled(cron = "0 */1 * * * ?")
    public void schedzuleTask(){
        System.out.println("1");
    }
@Scheduled(cron = "1-5 * * * * *")
public void schedzffduleTask(){
    System.out.println("1");
}
// https://techdocs.broadcom.com/us/en/symantec-security-software/endpoint-security-and-management/cloud-workload-protection-for-storage/1-0/Scan_Configuration_7/about-special-characters-in-cron-expressions-v123769576-d4995e65374.html
    // https://www.javatpoint.com/java-cron-expression
}
