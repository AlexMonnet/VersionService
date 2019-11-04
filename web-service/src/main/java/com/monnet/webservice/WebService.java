package com.monnet.webservice;

import com.monnet.versionnumber.VersionNumber;
public class WebService {
    public WebService() {}

    public String compareVersions(final String sourceVersionString, final String targetVersionString)
    {
        final VersionNumber sourceVersion = new VersionNumber(sourceVersionString);
        final VersionNumber targetVersion = new VersionNumber(targetVersionString);
        
        int comparisonValue = sourceVersion.compareTo(targetVersion);
        final String returnString;
        
        switch(comparisonValue) {
            case -1:
                returnString = "before";
                break;
            case 1:
                returnString = "after";
                break;
            case 0:
                returnString = "equal";
                break;
            default:
                returnString = "error";
                break;
        }
        
        return returnString;
    }
}