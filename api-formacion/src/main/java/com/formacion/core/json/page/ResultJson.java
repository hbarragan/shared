package com.formacion.core.json.page;

import com.formacion.core.exception.enumerator.TypeView;
import lombok.Data;

@Data
public class ResultJson<T> {
    protected Boolean success;
    protected Integer errorCode;
    protected String message;
    protected String typeView;
    protected T response;

    public ResultJson(T result, String message) {
        this(Boolean.TRUE, null, message, result, TypeView.NONE.getValue());
    }

    public ResultJson(boolean success) {
        this(success, null, null, (T) (Boolean) success, TypeView.NONE.getValue());
    }

    public ResultJson(Boolean success, Integer errorCode, String message, T response, String typeView) {
        this.success = success;
        this.errorCode = errorCode;
        this.message = message;
        this.response = response;
        this.typeView = typeView;
    }

}


