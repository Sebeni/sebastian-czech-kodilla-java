package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;
import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    
    
    @Test
    public void testDefaultSharingStrategies() {
        String millenialName = "Millennial";
        String genYName = "Y generation";
        String genZName = "Z generation";
        
        User millenial = new Millennials(millenialName);
        User genY = new YGeneration(genYName);
        User genZ = new ZGeneration(genZName);
        
        String millenialExpectedOutput = millenialName + User.ACTIVITY + FacebookPublisher.NAME;
        String genYExpectedOutput = genYName + User.ACTIVITY + TwitterPublisher.NAME;
        String genZExpectedOutput = genZName + User.ACTIVITY + SnapchatPublisher.NAME;

        Assert.assertEquals(millenialExpectedOutput, millenial.sharePost());
        Assert.assertEquals(genYExpectedOutput, genY.sharePost());
        Assert.assertEquals(genZExpectedOutput, genZ.sharePost());
        
    }
    
    @Test
    public void testIndividualSharingStrategy() {
        String millennialName = "Kyle";
        User millennial = new Millennials("Kyle");
        String initial = millennial.sharePost();
        
        millennial.setSocialPublisher(new SnapchatPublisher());
        String after = millennial.sharePost();
        
        Assert.assertNotEquals(initial, after);
        Assert.assertEquals(millennialName + User.ACTIVITY + SnapchatPublisher.NAME, after);
        
        
    }
}
