package com.monnet.versionnumber;

import org.testng.Assert;
import org.testng.annotations.*;

public class VersionNumberTest {
    @Test
    public void testVersionNumber_compareTo_lessThan(){
        final VersionNumber sourceVersionNumber = new VersionNumber("2.1");
        final VersionNumber targetVersionNumber = new VersionNumber("2.2");
        final int versionNumberComparison = sourceVersionNumber.compareTo(targetVersionNumber);
        Assert.assertEquals(-1, versionNumberComparison);
    }

    @Test
    public void testVersionNumber_compareTo_greaterThan(){
        final VersionNumber sourceVersionNumber = new VersionNumber("2.2");
        final VersionNumber targetVersionNumber = new VersionNumber("2.1");
        final int versionNumberComparison = sourceVersionNumber.compareTo(targetVersionNumber);
        Assert.assertEquals(1, versionNumberComparison);
    }

    @Test
    public void testVersionNumber_compareTo_equalTo(){
        final VersionNumber sourceVersionNumber = new VersionNumber("2.2");
        final VersionNumber targetVersionNumber = new VersionNumber("2.2");
        final int versionNumberComparison = sourceVersionNumber.compareTo(targetVersionNumber);
        Assert.assertEquals(0, versionNumberComparison);
    }
}