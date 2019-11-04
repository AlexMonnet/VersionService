package com.monnet.versionnumber;

import org.testng.Assert;
import org.testng.annotations.*;

public class VersionNumberTest {
    @Test
    public void testVersionNumber_compareTo_lessThan_equalVersionIdentifierFields(){
        final VersionNumber sourceVersionNumber = new VersionNumber("2.1");
        final VersionNumber targetVersionNumber = new VersionNumber("2.2");
        final int versionNumberComparison = sourceVersionNumber.compareTo(targetVersionNumber);
        Assert.assertEquals(versionNumberComparison, -1);
    }

    @Test
    public void testVersionNumber_compareTo_greaterThan_equalVersionIdentifierFields(){
        final VersionNumber sourceVersionNumber = new VersionNumber("2.2");
        final VersionNumber targetVersionNumber = new VersionNumber("2.1");
        final int versionNumberComparison = sourceVersionNumber.compareTo(targetVersionNumber);
        Assert.assertEquals(versionNumberComparison, 1);
    }

    @Test
    public void testVersionNumber_compareTo_equalTo_equalVersionIdentifierFields(){
        final VersionNumber sourceVersionNumber = new VersionNumber("2.2");
        final VersionNumber targetVersionNumber = new VersionNumber("2.2");
        final int versionNumberComparison = sourceVersionNumber.compareTo(targetVersionNumber);
        Assert.assertEquals(versionNumberComparison, 0);
    }

    @Test
    public void testVersionNumber_compareTo_lessThan_moreSourceVersionIdentifierFields(){
        final VersionNumber sourceVersionNumber = new VersionNumber("2.1.1");
        final VersionNumber targetVersionNumber = new VersionNumber("2.2");
        final int versionNumberComparison = sourceVersionNumber.compareTo(targetVersionNumber);
        Assert.assertEquals(versionNumberComparison, -1);
    }

    @Test
    public void testVersionNumber_compareTo_greaterThan_moreSourceVersionIdentifierFields(){
        final VersionNumber sourceVersionNumber = new VersionNumber("2.2.2");
        final VersionNumber targetVersionNumber = new VersionNumber("2.1");
        final int versionNumberComparison = sourceVersionNumber.compareTo(targetVersionNumber);
        Assert.assertEquals(versionNumberComparison, 1);
    }

    @Test
    public void testVersionNumber_compareTo_equalTo_moreSourceVersionIdentifierFields(){
        final VersionNumber sourceVersionNumber = new VersionNumber("2.2.0");
        final VersionNumber targetVersionNumber = new VersionNumber("2.2");
        final int versionNumberComparison = sourceVersionNumber.compareTo(targetVersionNumber);
        Assert.assertEquals(versionNumberComparison, 0);
    }

    @Test
    public void testVersionNumber_compareTo_lessThan_lessSourceVersionIdentifierFields(){
        final VersionNumber sourceVersionNumber = new VersionNumber("2.1");
        final VersionNumber targetVersionNumber = new VersionNumber("2.2.2");
        final int versionNumberComparison = sourceVersionNumber.compareTo(targetVersionNumber);
        Assert.assertEquals(versionNumberComparison, -1);
    }

    @Test
    public void testVersionNumber_compareTo_greaterThan_lessSourceVersionIdentifierFields(){
        final VersionNumber sourceVersionNumber = new VersionNumber("2.2");
        final VersionNumber targetVersionNumber = new VersionNumber("2.1.1");
        final int versionNumberComparison = sourceVersionNumber.compareTo(targetVersionNumber);
        Assert.assertEquals(versionNumberComparison, 1);
    }

    @Test
    public void testVersionNumber_compareTo_equalTo_lessSourceVersionIdentifierFields(){
        final VersionNumber sourceVersionNumber = new VersionNumber("2.2");
        final VersionNumber targetVersionNumber = new VersionNumber("2.2.0");
        final int versionNumberComparison = sourceVersionNumber.compareTo(targetVersionNumber);
        Assert.assertEquals(versionNumberComparison, 0);
    }
}