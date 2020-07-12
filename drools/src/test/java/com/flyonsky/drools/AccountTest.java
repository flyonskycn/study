package com.flyonsky.drools;

import com.flyonsky.model.Account;
import com.flyonsky.model.FlowDetail;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author luowengang
 * @date 2020/7/12 16:47
 */
public class AccountTest {

    @Test
    public void test1(){
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
                .currentAmount(49D).currentTime(new Date(System.currentTimeMillis())).build();
        flowDetailList.add(flowDetail);

        account.setFlowDetailList(flowDetailList);

        statelessKieSession.execute(account);
//        statelessKieSession.execute(flowDetailList);
    }
}
