package com.hivedi.era;

import java.util.ArrayList;

/**
 * Created by Kenumir on 2015-10-28.
 *
 */
public class ERA {

    private static ArrayList<Object> adapters = new ArrayList<>();

    public static void addAdapter(ReportInterface ri) {
        adapters.add(ri);
    }

    public static void delAdapter(ReportInterface ri) {
        adapters.remove(ri);
    }

    public static ArrayList<Object> getAdapters() {
        return adapters;
    }

    public static void logException(String key, String value, Throwable e) {
        if (adapters.size() > 0) {
            for(Object ri : adapters) {
                if (ri instanceof ReportInterface) {
                    ((ReportInterface) ri).logException(key, value, e);
                }
            }
        }
    }

    public static void logException(String key, String value, Exception e) {
        if (adapters.size() > 0) {
            for(Object ri : adapters) {
                if (ri instanceof ReportInterface) {
                    ((ReportInterface) ri).logException(key, value, e);
                }
            }
        }
    }

    public static void logException(Throwable e) {
        if (adapters.size() > 0) {
            for(Object ri : adapters) {
                if (ri instanceof ReportInterface) {
                    ((ReportInterface) ri).logException(e);
                }
            }
        }
    }

    public static void setUserIdentifier(String userIdentifier) {
        if (adapters.size() > 0) {
            for(Object ri : adapters) {
                if (ri instanceof ReportInterface) {
                    ((ReportInterface) ri).setUserIdentifier(userIdentifier);
                }
            }
        }
    }

	public static void logWarn(Throwable e) {
		if (adapters.size() > 0) {
			for(Object ri : adapters) {
				if (ri instanceof ReportInterface) {
					((ReportInterface) ri).logWarn(e);
				}
			}
		}
	}
	public static void logWarn(Exception e) {
		if (adapters.size() > 0) {
			for(Object ri : adapters) {
				if (ri instanceof ReportInterface) {
					((ReportInterface) ri).logWarn(e);
				}
			}
		}
	}

	public static void logInfo(Throwable e) {
		if (adapters.size() > 0) {
			for(Object ri : adapters) {
				if (ri instanceof ReportInterface) {
					((ReportInterface) ri).logInfo(e);
				}
			}
		}
	}
	public static void logInfo(Exception e) {
		if (adapters.size() > 0) {
			for(Object ri : adapters) {
				if (ri instanceof ReportInterface) {
					((ReportInterface) ri).logInfo(e);
				}
			}
		}
	}

    @SuppressWarnings({"unchecked", "TryWithIdenticalCatches", "ConstantConditions"})
     public static <T> T getReportInterface(Class<T> cls) {
        T res = null;
        if (adapters.size() > 0) {
            for(Object ri : adapters) {
                if (ri instanceof ReportInterface) {
                    if (ri.getClass().equals(cls)) {
                        try {
                            res = (T) ri;
                        } catch (ClassCastException e) {
                            try {
                                res = cls.newInstance();
                            } catch (InstantiationException ignore) {
                            } catch (IllegalAccessException ignore) {
                            }
                        }
                        break;
                    }
                }
            }
        }
        return res;
    }

}
