package com.flyonsky.drools;

import com.flyonsky.model.Account;
import com.flyonsky.model.FlowDetail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author luowengang
 * @date 2020/7/12 16:47
 */
public class AccountTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountTest.class);

    @Before
    public void setup(){
        MDC.put("traceId", UUID.randomUUID().toString());
    }

    @After
    public void clear(){
        MDC.clear();
    }

    @Test
    public void test1(){
        LOGGER.debug("开始测试");
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        System.out.println(kc.verify().getMessages().toString());

        StatelessKieSession statelessKieSession = kc.newStatelessKieSession("accountKS");

        Account account = Account.builder().accountId(1L).accountName("accountTest")
                .amount(100D).build();

        List<FlowDetail> flowDetailList = new ArrayList<>();

        FlowDetail flowDetail = FlowDetail.builder().accountId(1l).accountName("accountTest")
                .currentAmount(50D).currentTime(new Date(System.currentTimeMillis())).build();
        flowDetailList.add(flowDetail);

        flowDetail = FlowDetail.builder().accountId(1l).accountName("accountTest")
                .currentAmount(50D).currentTime(new Date(System.currentTimeMillis())).build();
        flowDetailList.add(flowDetail);

        account.setFlowDetailList(flowDetailList);
        Command command = CommandFactory.newInsert(account);
        Object data = statelessKieSession.execute(command);
//        statelessKieSession.execute(flowDetailList);
        System.out.println(account.isValid());

        LOGGER.debug("结束测试");
    }
}
