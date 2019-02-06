package org.jenkinsci.plugins.globalslack;

import hudson.model.Result;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;
import org.junit.Assert;

public class ConfigAsCodeTest {

    @Rule
    public JenkinsRule rule = new JenkinsRule();

    @Test
    public void testSuccessSlackMessage() throws Exception {
        SlackMessage mes = ConfigAsCodeStub.getDescriptor().getSlackMessage(Result.SUCCESS);

        Assert.assertEquals(mes.getMessage(),  "successMessage");
        Assert.assertEquals(mes.getRoom(),  "successRoom");
        Assert.assertEquals(mes.getEnable(),  true);
    }


    @Test
    public void testFailureSlackMessage() throws Exception {
        SlackMessage mes = ConfigAsCodeStub.getDescriptor().getSlackMessage(Result.FAILURE);

        Assert.assertEquals(mes.getRoom(), "failureRoom");
        Assert.assertEquals(mes.getMessage(), "failureMessage");
        Assert.assertEquals(mes.getEnable(), true);
    }

    @Test
    public void testUnstableSlackMessage() throws Exception {
        SlackMessage mes = ConfigAsCodeStub.getDescriptor().getSlackMessage(Result.UNSTABLE);

        Assert.assertEquals(mes.getRoom(), "unstableRoom");
        Assert.assertEquals(mes.getMessage(), "unstableMessage");
        Assert.assertEquals(mes.getEnable(), false);
    }


    @Test
    public void testNotBuiltSlackMessage() throws Exception {
        SlackMessage mes = ConfigAsCodeStub.getDescriptor().getSlackMessage(Result.NOT_BUILT);

        Assert.assertEquals(mes.getRoom(), "notBuiltRoom");
        Assert.assertEquals(mes.getMessage(), "notBuiltMessage");
        Assert.assertEquals(mes.getEnable(), true);
    }

    @Test
    public void testAbortedSlackMessage() throws Exception {
        SlackMessage mes = ConfigAsCodeStub.getDescriptor().getSlackMessage(Result.ABORTED);

        Assert.assertEquals(mes.getRoom(), "abortedRoom");
        Assert.assertEquals(mes.getMessage(), "abortedMessage");
        Assert.assertEquals(mes.getEnable(), false);
    }
}
