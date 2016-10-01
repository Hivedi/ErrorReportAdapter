# ErrorReportAdapter
Error reporting adapter

### Add to project

Repo:
```
repositories {
	maven {
		url "https://jitpack.io"
	}
}
```

Dependences:
```
dependencies {
	compile 'com.github.Hivedi:ErrorReportAdapter:2.1.0'
}
```

Sample code:
```java
ERA.registerAdapter(new ReportInterface() {
    @Override
    public void logException(Throwable e, Object... metaParams) {
        Log.e("a", "error=" + e + ", param1=" + metaParams[0] + ", param2=" + metaParams[1], e);
    }

    @Override
    public void log(String s, Object... extraParams) {
        // TODO add log info
    }

    @Override
    public void breadcrumb(String s, Object... extraParams) {
        // TODO add breadcrumb info
    }
});

ERA.logException(new RuntimeException("aaa"), "test1", "test2");
```