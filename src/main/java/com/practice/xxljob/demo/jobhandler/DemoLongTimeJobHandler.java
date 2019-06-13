package com.practice.xxljob.demo.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.bouncycastle.util.Times;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@JobHandler(value = "DemoLongTimeJobHandler")
@Component
public class DemoLongTimeJobHandler extends IJobHandler {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public ReturnT<String> execute(String param) throws Exception {

        String log = ">>>>>>>>>>>>>DemoLongTimeJobHandler = [" + param + "]:" + count.incrementAndGet();
        System.out.println(log);
        XxlJobLogger.log(log);

        int sleep;
        if (param == null || param.equals("")) {
            sleep = 3;
        } else {
            sleep = Integer.parseInt(param);
        }
        System.out.println("sleep....");
        TimeUnit.SECONDS.sleep(sleep);
        System.out.println("end sleep");

        return SUCCESS;
    }

    @Override
    public void destroy() {
        System.out.println("**********destroy.....");
    }
}