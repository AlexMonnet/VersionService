package com.monnet.webservice;

/**
 * This service is used to abstract the logic of comparing two version strings.
 */
public interface VersionNumberService {

    /**
     * This method returns a string indicating whether the source version is before,
     * after, or equal to the provided target string.
     * 
     * @param sourceVersionString The version string that that is compared against
     *                            the target version
     * @param targetVersionString The version string that that is compared against
     *                            the source version
     * @return comparison result string as either "after", "before", or "equal"
     */
    public abstract String compareVersions(final String sourceVersionString, final String targetVersionString);
}