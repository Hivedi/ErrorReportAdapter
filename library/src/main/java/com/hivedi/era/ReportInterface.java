package com.hivedi.era;

/**
 * Created by Kenumir on 2015-10-28.
 *
 */
public abstract class ReportInterface {

	public abstract void logException(Throwable e, Object... metaParams);
    public abstract void log(String s, Object... extraParams);
    public abstract void breadcrumb(String s, Object... extraParams);

}
