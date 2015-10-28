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
	compile 'com.github.Hivedi:ErrorReportAdapter:1.0.0'
}
```

Sample code:
```java
ERA.addAdapter(new ReportInterface() {
	@Override
	public void logException(Throwable throwable) {
		Log.e("tests", "key", throwable);
	}
});

// to log exceptions
ERA.logException(new Exception("xx"));
```