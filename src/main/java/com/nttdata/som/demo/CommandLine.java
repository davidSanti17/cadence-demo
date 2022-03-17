package com.nttdata.som.demo;

import com.nttdata.som.demo.service.impl.ActivityManageFileImpl;
import com.nttdata.som.demo.service.impl.WorkflowDemoImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.uber.cadence.worker.Worker;

@Slf4j
@Component
public class CommandLine implements CommandLineRunner {

    @Value("${com.nttdata.cadence.domain}")
    private String cadenceDomain;
    @Value("${com.nttdata.cadence.host}")
    private String cadenceHost;
    @Value("${com.nttdata.cadence.tasklist}")
    private String cadenceTaskList;
    @Value("${com.nttdata.cadence.port}")
    private int cadencePort;

    /*
    @Bean
    public BeanUtil beanUtil() {
        return new BeanUtil();
    }

     */
    /**
     *
     */
    @Override
    public void run(String... args) throws Exception {
        log.info("Runing Worker Load flow..... ");
        Worker.Factory factory = new Worker.Factory(cadenceHost, cadencePort,cadenceDomain);
        Worker worker = factory.newWorker(cadenceTaskList);
        worker.registerWorkflowImplementationTypes(WorkflowDemoImpl.class);
        worker.registerActivitiesImplementations(new ActivityManageFileImpl());
        factory.start();
        log.info("Worker started success");
    }
//  @Bean
//  OkHttpClient client = new OkHttpClient.Builder()
//  .connectTimeout(160, TimeUnit.SECONDS)
//  .readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS)
//  .authenticator(new AuthRequestInterceptor())
//  .build();


}
