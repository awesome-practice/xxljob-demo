package com.practice.xxljob.demo.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

@JobHandler(value = "DemoExceptionJobHandler")
@Component
public class DemoExceptionJobHandler extends IJobHandler {

    @Override
    public ReturnT<String> execute(String param) throws Exception {

        String log = "DemoExceptionJobHandler = [" + param + "]";
        System.out.println(log);
        XxlJobLogger.log(log);

        if (true) {
            throw new RuntimeException("a manual exception");
        }

        return SUCCESS;
    }

    @Override
    public void destroy() {
        System.out.println("**********destroy.....");
    }
}