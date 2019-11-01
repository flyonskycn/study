package com.flyonsky;

import java.io.IOException;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.jmx.ConfigJMXManager;

/**
 * archaius与jmx结合的样例
 * @author luowengang
 */
public class SimpleApp extends Thread{

    public SimpleApp() {
        setDaemon(false);
        start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
	public static void main(String[] args) throws IOException {
		new SimpleApp();

		ConfigurationManager.loadPropertiesFromResources("myconfig2.properties");
		ConfigurationManager.loadPropertiesFromResources("myconfig.properties");

        ConfigJMXManager.registerConfigMbean(ConfigurationManager.getConfigInstance());
        
        System.out.println("Started SimpleApp. Launch JConsole to inspect and update properties");
        System.out.println("To see how callback work, update property com.flyonsky.SampleApp.SimpleConfig.name、age、flag from BaseConfigBean in JConsole");
        
        SimpleConfig sampleBean = new SimpleConfig();
        System.out.println("SimpleConfig:" + sampleBean);
	}
}
