package com.example.demo.quartz;

import com.example.demo.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Component
@Configurable
@EnableScheduling
//定时器开关
@ConditionalOnProperty(prefix = "scheduling", name = "enabled", havingValue = "true")
public class TestTask {
    private  static  final Logger logger=LogManager.getLogger(TestTask.class);
    private int i=1;
    @Autowired
    SendEmailService sendmail;

    @Scheduled(cron="*/5 * * * * * ")
    public void reportCurrentByCron(){
        sendmail.sendJunkMail("2114101028@stu.hzu.edu.cn","测试", "每5秒发送一次文件");
        logger.info("第"+i+"封邮件发送成功");
        i++;
    }
}
