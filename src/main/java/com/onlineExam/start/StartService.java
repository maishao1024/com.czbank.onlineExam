package com.onlineExam.start;

import com.onlineExam.common.Common;
import com.onlineExam.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class StartService implements CommandLineRunner {

    @Autowired
    private RedisUtil redisUtil;

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    public void run(String... strings) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Common.startTime = (String) redisUtil.hget("sign_Configure", "startTime");
                    Common.endTime = (String) redisUtil.hget("sign_Configure", "endTime");
                }catch (Exception e){
                    Common.initialize();
                }
            }
        });
    }
}
