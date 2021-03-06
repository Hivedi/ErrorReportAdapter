package com.hivedi.era;

import java.util.ArrayList;

/**
 * Created by Kenumir on 2015-10-28.
 *
 */
public class ERA {

    private volatile static ArrayList<Object> adapters = new ArrayList<>();

    public static synchronized void registerAdapter(ReportInterface ri) {
        adapters.add(ri);
    }

    public static synchronized void unregisterAdapter(ReportInterface ri) {
        adapters.remove(ri);
    }

    public static synchronized ArrayList<Object> getAdapters() {
        return adapters;
    }

	public static synchronized void logException(Throwable e, Object... metaParams) {
		if (adapters.size() > 0) {
			for(Object ri : adapters) {
				if (ri instanceof ReportInterface) {
					((ReportInterface) ri).logException(e, metaParams);
				}
			}
		}
	}

    public static synchronized void log(String s, Object... extraParams) {
        if (adapters.size() > 0) {
            for(Object ri : adapters) {
                if (ri instanceof ReportInterface) {
                    ((ReportInterface) ri).log(s, extraParams);
                }
            }
        }
    }

    public static synchronized void breadcrumb(String s, Object... extraParams) {
        if (adapters.size() > 0) {
            for(Object ri : adapters) {
                if (ri instanceof ReportInterface) {
                    ((ReportInterface) ri).breadcrumb(s, extraParams);
                }
            }
        }
    }

}
