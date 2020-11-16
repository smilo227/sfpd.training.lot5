package io.hackages.learning.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="clientId", referencedColumnName = "id")
    private Client client;

    @OneToOne(mappedBy = "order")
    private OrderDetails orderDetailsList ;

    @Column(name="description")
    private String description;

    public Order() {
    }

    public Order(Client client, String description, OrderDetails orderDetails) {
        this.client = client;
        this.description = description;
        this.orderDetailsList = orderDetails;
    }
}
