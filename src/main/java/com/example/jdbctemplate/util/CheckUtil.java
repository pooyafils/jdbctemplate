package com.example.jdbctemplate.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class CheckUtil {
    @Before(value = "execution(* com.example.jdbctemplate..*(..))")
    public void tests() {
        System.out.println("scanning all packages");
    }

    @Before(value =" execution(* com.example.jdbctemplate.contoller.TableInfoController..*(..))")
            public void scanningContoller(){
System.out.println("scanning controller");
            }
      @Before(value = "execution (* com.example.jdbctemplate.contoller.TableInfoController.findById(..))")
    public void tes(){
        System.out.println("scanning the specific method in controller with all parameter");
      }

    @Before(value = "execution (* com.example.jdbctemplate.contoller.TableInfoController.findById(..)))")
    public void tes(JoinPoint joinPoint){
   Object[] info=     joinPoint.getArgs();
   for(int i=0;i<info.length;i++){
       System.out.println("scanning the specific method in controller with  parameter");
       System.out.println(info[i].toString());
   }
    }
    @Before(value = "execution (* com.example.jdbctemplate.JdbctemplateApplication..*(..))")
    public void aroundMethod(){
System.out.println("using around in aop");
    }
}
