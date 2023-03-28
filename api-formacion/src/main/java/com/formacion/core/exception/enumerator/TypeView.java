package com.formacion.core.exception.enumerator;

public enum  TypeView {
    NONE("none"),
    TOAST("toast"),
    MODAL("modal");

    private String typeView;

    private TypeView(String typeView) {
        this.typeView = typeView;
    }

    public String getValue() {
        return this.typeView;
    }
}
