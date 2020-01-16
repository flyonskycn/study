package com.flyonsky.jmx;

import com.flyonsky.jmx.imp.Hello;
import com.flyonsky.jmx.imp.SecondHello;

import javax.management.JMException;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * @author luowengang
 * @date 2020/1/14 23:09
 */
public class JmxApplication {

    public static void main(String[] args) throws IOException, JMException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("com.flyonsky:name=firstHello");

        HelloMXBean helloMXBean = new Hello();
        mBeanServer.registerMBean(helloMXBean, objectName);

        ObjectName secondObjectName = new ObjectName("com.flyonsky:name=secondHello");

        SecondHello secondHello = new SecondHello();
        secondHello.addNotificationListener(new HelloListener(),null,helloMXBean);
        mBeanServer.registerMBean(secondHello, secondObjectName);

        System.in.read();
    }
}
