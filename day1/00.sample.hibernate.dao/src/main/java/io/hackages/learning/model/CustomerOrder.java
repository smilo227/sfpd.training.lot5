package io.hackages.learning.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customerOrders")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "clientId", referencedColumnName = "id")
    private Client client;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.ALL}
    )
    private List<OrderDetail> orderDetails;

    private String description;

    @Column
    private String invoiceId;
    @Column
    private LocalDateTime purchasedAt;


    public CustomerOrder() {
        this.orderDetails = new ArrayList();
        this.purchasedAt = LocalDateTime.now();
        this.invoiceId = UUID.randomUUID().toString();
    }

    public CustomerOrder(Client client, String description) {
        this();
        this.client = client;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public LocalDateTime getPurchasedAt() {
        return purchasedAt;
    }

    public void setPurchasedAt(LocalDateTime purchasedAt) {
        this.purchasedAt = purchasedAt;
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        this.orderDetails.add(orderDetail);
    }

}
