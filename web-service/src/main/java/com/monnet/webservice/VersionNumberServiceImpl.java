package com.monnet.webservice;

import com.monnet.versionnumber.VersionNumber;
import org.springframework.stereotype.Service;

@Service
public class VersionNumberServiceImpl implements VersionNumberService {
    public VersionNumberServiceImpl() {
    }

    @Override
    public String compareVersions(final String sourceVersionString, final String targetVersionString) {

        final String returnString;
        if (!sourceVersionString.matches("^([\\.]|[0-9])+$")) {
            returnString = "Error: Source version contains invalid characters.";
        } else if (!targetVersionString.matches("^([\\.]|[0-9])+$")) {
            returnString = "Error: Target version contains invalid characters.";
        } else {
            final VersionNumber sourceVersion = new VersionNumber(sourceVersionString);
            final VersionNumber targetVersion = new VersionNumber(targetVersionString);

            int comparisonValue = sourceVersion.compareTo(targetVersion);

            switch (comparisonValue) {
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
        }

        return returnString;
    }
}