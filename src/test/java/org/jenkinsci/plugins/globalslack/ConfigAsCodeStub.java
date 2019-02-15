package org.jenkinsci.plugins.globalslack;

import io.jenkins.plugins.casc.ConfigurationAsCode;
import junit.framework.TestCase;

public class ConfigAsCodeStub extends TestCase  {

    public static GlobalSlackNotifier.DescriptorImpl getDescriptor() throws Exception {
        String config = ConfigAsCodeTest.class.getResource("configuration-as-code.yml").toString();
        ConfigurationAsCode.get().configure(config);

        return new GlobalSlackNotifier.DescriptorImpl();
    }
}
