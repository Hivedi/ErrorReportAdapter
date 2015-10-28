package com.hivedi.era;

/**
 * Created by Kenumir on 2015-10-28.
 *
 */
public abstract class ReportInterface {

    public abstract void logException(Throwable e);

    public void logException(String key, String value, Exception e) {}
    public void logException(String key, String value, Throwable e) {}

    public void setUserIdentifier (String userIdentifier) {}

}