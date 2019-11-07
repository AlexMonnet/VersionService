package com.monnet.webservice;

import com.monnet.webservice.VersionNumberService;
import com.monnet.webservice.VersionNumberServiceImpl;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VersionNumberServiceTest {

    // TODO use the spring boot @autowire annotation. Couldn't resolve null pointer
    // while using the @autowire in a reasonable time.
    private VersionNumberService service = new VersionNumberServiceImpl();

    @Test
    public void testVersionNumberServiceImpl_compareVersions_before() {
        final String comparisonString = service.compareVersions("2.1", "2.2");
        Assert.assertEquals(comparisonString, "before");
    }

    @Test
    public void testVersionNumberServiceImpl_compareVersions_after() {
        final String comparisonString = service.compareVersions("2.2", "2.1");
        Assert.assertEquals(comparisonString, "after");
    }

    @Test
    public void testVersionNumberServiceImpl_compareVersions_equal() {
        final String comparisonString = service.compareVersions("2.2", "2.2");
        Assert.assertEquals(comparisonString, "equal");
    }

    @Test
    public void testVersionNumberServiceImpl_compareVersions_invalidSourceCharacters() {
        final String comparisonString = service.compareVersions("2.2a", "2.2");
        Assert.assertTrue(comparisonString.contains("Error"));
        Assert.assertTrue(comparisonString.contains("Source"));
    }

    @Test
    public void testVersionNumberServiceImpl_compareVersions_invalidTargetCharacters() {
        final String comparisonString = service.compareVersions("2.2", "2.2a");
        Assert.assertTrue(comparisonString.contains("Error"));
        Assert.assertTrue(comparisonString.contains("Target"));
    }
}