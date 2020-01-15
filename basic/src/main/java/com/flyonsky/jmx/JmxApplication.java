package com.flyonsky.jmx;

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
        ObjectName objectName = new ObjectName("jmxBean:name=hello");

        mBeanServer.registerMBean(new Hello(), objectName);

        System.in.read();
    }
}
