package com.monnet.versionnumber;

import java.util.Arrays;
import java.util.List;

public class VersionNumber implements Comparable<VersionNumber> {

    private String versionNumberString;

    public VersionNumber(final String versionNumberString) {
        this.versionNumberString = versionNumberString;
    }

    public String getVersionNumberString(){
        return this.versionNumberString;
    }

    /**
     * Overridding the compareTo method so that the version number
     *  comparison can more easily be used for sorting and comparison.
     *
     * @param otherVersionNumber the target VersionNumber class to compare against
     * @return int   1 - The source version is greater than the target version
     *               0 - The source version is equal to the target version
     *              -1 - The source version is less than the target version
     */
    @Override
    public int compareTo(VersionNumber otherVersionNumber){ 
        int comparisonValue = 0;
        final String sourceVersionNumberString = this.versionNumberString;
        final String targetVersionNumberString = otherVersionNumber.getVersionNumberString();

        if(sourceVersionNumberString.equals(targetVersionNumberString)){
            comparisonValue = 0;
        } else {
            final List<String> sourceSplitVersionList = Arrays.asList(this.versionNumberString.split("."));
            final List<String> targetSplitVersionList = Arrays.asList(this.versionNumberString.split("."));
            final int minNumberOfDots = Math.min(sourceSplitVersionList.size(), targetSplitVersionList.size());

            for(int i = 0; i < minNumberOfDots; i++){
                
            }
        }

        return comparisonValue;
    }
}