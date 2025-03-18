package com.cristian.jtext.editor;

public class IoResult<T> {

    private T data;
    private boolean ok;

    public IoResult(T data, boolean ok) {
        this.data = data;
        this.ok = ok;
    }

    public T getData() {
        return data;
    }

    public boolean hasData() {
        return data != null;
    }

    public boolean isOk() {
        return ok;
    }
}
