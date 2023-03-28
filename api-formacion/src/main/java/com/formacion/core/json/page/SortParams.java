package com.formacion.core.json.page;


import io.swagger.v3.oas.annotations.Parameter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SortParams implements Serializable {
    private static final long serialVersionUID = -3512016970387054057L;

    private List<Order> orders;

    public SortParams() {
        this.orders = new ArrayList<>();
    }

    public SortParams(String... properties) {
        this(properties, Order.DEFAULT_SORT_DIRECTION);
    }

    public SortParams(String[] properties, SortDirection direction) {
        this();
        if (properties == null || properties.length == 0) {
            throw new IllegalArgumentException("Heu de proporcionar almenys una propietat per ordenar.");
        }
        for (String property : properties) {
            this.addOrder(property, direction == null ? Order.DEFAULT_SORT_DIRECTION : direction);
        }
    }

    @Parameter(description = "Orders")
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders.clear();
        if (orders != null) {
            for (Order order : orders) {
                this.addOrder(order);
            }
        }
    }

    public void addOrder(String property) {
        this.addOrder(property, Order.DEFAULT_SORT_DIRECTION);
    }

    public final void addOrder(String property, SortDirection direction) {
        this.addOrder(new Order(property, direction));
    }

    public void addOrder(Order order) {
        int position = this.findPropertyOrder(order.getProperty());
        if (position == -1) {
            this.orders.add(order);
        } else {
            this.orders.set(position, order);
        }
    }

    @Parameter(description = "Sort order")
    public SortDirection getDirectionFor(String property) {
        if (property == null || property.isEmpty()) {
            throw new IllegalArgumentException("La propietat no ha de ser nul·la o buida");
        }
        SortDirection result = null;
        int position = this.findPropertyOrder(property);
        if (position != -1) {
            result = this.orders.get(position).getDirection();
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        } else if (obj instanceof SortParams) {
            SortParams that = (SortParams) obj;
            result = this.orders.equals(that.orders);
        }
        return result;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + orders.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return orders == null || orders.isEmpty() ? "[]" : orders.toString();
    }

    protected int findPropertyOrder(String property) {
        int position = -1;
        for (int i = 0; i < this.orders.size(); i++) {
            if (this.orders.get(i).getProperty().equals(property)) {
                position = i;
                break;
            }
        }
        return position;
    }

    public enum SortDirection {
        ASC, DESC
    }

}

