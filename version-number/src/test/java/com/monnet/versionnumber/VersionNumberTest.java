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

    @Test
    public void testVersionNumber_compareTo_lessThan_extraIntermediateSourceVersionIdentifierFields(){
        final VersionNumber sourceVersionNumber = new VersionNumber("2.0001.0");
        final VersionNumber targetVersionNumber = new VersionNumber("2.2.2");
        final int versionNumberComparison = sourceVersionNumber.compareTo(targetVersionNumber);
        Assert.assertEquals(versionNumberComparison, -1);
    }

    @Test
    public void testVersionNumber_compareTo_greaterThan_extraIntermediateSourceVersionIdentifierFields(){
        final VersionNumber sourceVersionNumber = new VersionNumber("2.2.000000.2");
        final VersionNumber targetVersionNumber = new VersionNumber("2.2.0.1");
        final int versionNumberComparison = sourceVersionNumber.compareTo(targetVersionNumber);
        Assert.assertEquals(versionNumberComparison, 1);
    }

    @Test
    public void testVersionNumber_compareTo_equalTo_extraIntermediateSourceVersionIdentifierFields(){
        final VersionNumber sourceVersionNumber = new VersionNumber("2.0002.00000000");
        final VersionNumber targetVersionNumber = new VersionNumber("2.2.0");
        final int versionNumberComparison = sourceVersionNumber.compareTo(targetVersionNumber);
        Assert.assertEquals(versionNumberComparison, 0);
    }

    @Test
    public void testVersionNumber_compareTo_lessThan_extraIntermediateTargetVersionIdentifierFields(){
        final VersionNumber sourceVersionNumber = new VersionNumber("2.1.0");
        final VersionNumber targetVersionNumber = new VersionNumber("2.0001.0000.2");
        final int versionNumberComparison = sourceVersionNumber.compareTo(targetVersionNumber);
        Assert.assertEquals(versionNumberComparison, -1);
    }

    @Test
    public void testVersionNumber_compareTo_greaterThan_extraIntermediateTargetVersionIdentifierFields(){
        final VersionNumber sourceVersionNumber = new VersionNumber("2.2.0.2");
        final VersionNumber targetVersionNumber = new VersionNumber("2.0002.00000.1");
        final int versionNumberComparison = sourceVersionNumber.compareTo(targetVersionNumber);
        Assert.assertEquals(versionNumberComparison, 1);
    }

    @Test
    public void testVersionNumber_compareTo_equalTo_extraIntermediateTargetVersionIdentifierFields(){
        final VersionNumber sourceVersionNumber = new VersionNumber("2.2.0");
        final VersionNumber targetVersionNumber = new VersionNumber("2.0002.000000000");
        final int versionNumberComparison = sourceVersionNumber.compareTo(targetVersionNumber);
        Assert.assertEquals(versionNumberComparison, 0);
    }
}