package app.weather.task.weatherapp.data.model;

public class ResponseSearchResult {
    private final Exception exception;
    private final Current current;

    public ResponseSearchResult(Exception exception) {
        this.exception = exception;
        this.current = null;
    }

    public ResponseSearchResult(Current current){
        this.current = current;
        this.exception = null;
    }

    public Exception getException() {
        return exception;
    }

    public Current getCurrent() {
        return current;
    }

    public boolean success(){
        return current != null;
    }
}
