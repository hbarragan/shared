package com.formacion.core.json.page;
import com.formacion.core.json.page.SortParams.SortDirection;
import java.io.Serializable;
import java.util.Objects;

public class Order implements Serializable {
    private static final long serialVersionUID = 1431375908539326402L;
    private static final int PRIME = 31;
    public static final SortDirection DEFAULT_SORT_DIRECTION = SortDirection.ASC;
    private String property;
    private SortDirection direction;

    public Order() {
        this.direction = DEFAULT_SORT_DIRECTION;
    }

    public Order(String property, SortDirection direction) {
        this();
        this.property = property;
        this.direction = direction;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        if (property == null || property.isEmpty()) {
            throw new IllegalArgumentException("La propietat no ha de ser nul·la o buida");
        }
        this.property = property;
    }

    public SortDirection getDirection() {
        return direction;
    }

    public void setDirection(SortDirection direction) {
        this.direction = direction == null ? DEFAULT_SORT_DIRECTION : direction;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = PRIME * result + ((property == null) ? 0 : property.hashCode());
        result = PRIME * result + direction.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object other) {
        boolean result = true;
        if (this != other) {
            if (other == null || getClass() != other.getClass()) {
                result = false;
            } else {
                Order that = (Order) other;

                if ((!Objects.equals(property, that.property)) || direction != that.direction) {
                    result = false;
                }
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return "Order '" + property + "': " + direction;
    }

}

