package com.example.agencyservice.service;

import com.example.agencyservice.entity.Agency;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Aspect
@Component
public class LoggingAspect {
  private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
  @Before("execution(* com.example.agencyservice.controller.AgencyController.findById(..)) && args(id)")
  public void logBeforeFindById(int id) {
    logger.info("before findById, id: {}", id);
  }
  @AfterReturning(pointcut = "execution(* com.example.agencyservice.controller.AgencyController.findById(..))", returning = "agency")
  public void logAfterFindById(Optional<Agency> agency) {
    logger.info("after agency: {}", agency);
  }
  @Around("execution(* com.example.agencyservice.controller.AgencyController.findById(..))")
  public Object logAroundFindById(ProceedingJoinPoint joinPoint) throws Throwable {
    logger.info("Before findById");
    Object result = joinPoint.proceed(); // Thực thi phương thức
    logger.info("After findById");
    return result; // Trả về kết quả của phương thức
  }

  @Around("execution(* com.example.agencyservice.controller.AgencyController.findById(..))")
  public Object logAroundTimeFindById(ProceedingJoinPoint joinPoint) throws Throwable {
    long startTime = System.currentTimeMillis(); // Thời điểm bắt đầu thực hiện phương thức
    logger.info("Before findById");
    Object result = joinPoint.proceed(); // Thực thi phương thức
    long endTime = System.currentTimeMillis(); // Thời điểm kết thúc thực hiện phương thức
    logger.info("After findById");

    long executionTime = endTime - startTime; // Thời gian thực hiện phương thức
    logger.info("Execution time of findById: {} milliseconds", executionTime);

    return result; // Trả về kết quả của phương thức
  }

}
