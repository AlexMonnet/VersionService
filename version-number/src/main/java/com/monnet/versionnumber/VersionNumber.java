package com.monnet.versionnumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VersionNumber implements Comparable<VersionNumber> 
{

    private String versionNumberString;

    public VersionNumber(final String versionNumberString) 
    {
        this.versionNumberString = versionNumberString;
    }

    public String getVersionNumberString()
    {
        return this.versionNumberString;
    }

    /**
     * Overridding the compareTo method so that the version number
     *  comparison can more easily be used for sorting and comparison.
     *
     * @param otherVersionNumber the target VersionNumber class to compare against
     * @return Integer   1 - The source version is greater than the target version
     *               0 - The source version is equal to the target version
     *              -1 - The source version is less than the target version
     */
    @Override
    public int compareTo(VersionNumber otherVersionNumber)
    { 
        int comparisonValue = 0;
        final String sourceVersionNumberString = this.versionNumberString;
        final String targetVersionNumberString = otherVersionNumber.getVersionNumberString();

        if(!sourceVersionNumberString.equals(targetVersionNumberString))
        {
            final List<String> sourceSplitVersionList = removeTrailingZeroVersionIdentifiers(Arrays.asList(sourceVersionNumberString.split("\\.")));
            final List<String> targetSplitVersionList = removeTrailingZeroVersionIdentifiers(Arrays.asList(targetVersionNumberString.split("\\.")));

            final int minNumberOfDots = Math.min(sourceSplitVersionList.size(), targetSplitVersionList.size());

            for(int i = 0; i < minNumberOfDots; i++){
                Integer sourceNumber = Integer.parseInt(sourceSplitVersionList.get(i));
                Integer targetNumber = Integer.parseInt(targetSplitVersionList.get(i));
                if(sourceNumber > targetNumber)
                {
                    comparisonValue = 1;
                    break;
                } 
                else if (sourceNumber < targetNumber)
                {
                    comparisonValue = -1;
                    break;
                } 
            }

            int sourceSplitSize = sourceSplitVersionList.size();
            int targetSplitSize = targetSplitVersionList.size();
            if(comparisonValue == 0 && sourceSplitSize != targetSplitSize){
                comparisonValue = sourceSplitSize > targetSplitSize ? 1 : -1;
            }
        }

        return comparisonValue;
    }

    /**
     * Removes zeros from the end of a list of integers. This ensures the last element of 
     *  a list is a non-zero value.
     * 
     * @param splitVersionStringList A list of integers as strings.
     * @return A list of integers as strings where the last element is a non-zero value.
     */
    private List<String> removeTrailingZeroVersionIdentifiers(List<String> splitVersionStringList)
    {
        final List<String> cleanedSplitVersionStringList = new ArrayList<>(splitVersionStringList);
        final List<String> reversedSplitVersionStringList = new ArrayList<>(splitVersionStringList);
        Collections.reverse(reversedSplitVersionStringList);
        for (String versionIdenfierString : reversedSplitVersionStringList) 
        {
            Integer versionIdenfier = Integer.parseInt(versionIdenfierString);
            if(versionIdenfier == 0)
            {
                cleanedSplitVersionStringList.remove(versionIdenfierString);
            } 
            else
            {
                break;
            }
        }
        
        return cleanedSplitVersionStringList;
    }
}