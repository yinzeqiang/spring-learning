package com.jojo.yin.spring.scheduler;

import com.fangjia.api.client.auth.AuthRemoteClient;
import com.fangjia.api.client.auth.query.AuthQuery;
import com.fangjia.common.base.ResponseData;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时刷新token
 *
 * @author yinjihuan
 * @create 2017-11-09 15:39
 **/
@Component
public class TokenScheduledTask {
    private static Logger logger = LoggerFactory.getLogger(TokenScheduledTask.class);

    public final static long ONE_Minute = 30 * 1000;

    @Autowired
    private AuthRemoteClient authRemoteClient;

    /**
     * 刷新Token
     */
    @Scheduled(fixedDelay = ONE_Minute)
    public void reloadApiToken() {
        System.out.println("get token loop excute");
        String token = this.getToken();
        while (StringUtils.isBlank(token)) {
            try {
                Thread.sleep(1000);
                token = this.getToken();
            } catch (InterruptedException e) {
                logger.error("get token loop  error!", e);
            }
        }
        System.setProperty("fangjia.auth.token", token);
        System.out.println("get token loop excute finish!");
    }

    public String getToken() {
        AuthQuery query = new AuthQuery();
        query.setAccessKey("123456789");
        query.setSecretKey("qazxswedcvfrtgbnhyujm");
        ResponseData response = authRemoteClient.auth(query);
        return response.getData() == null ? "" : response.getData().toString();
    }
}
