package io.hackages.learning.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name="alias")
    private String alias;

    @Column(name=("emailAddress"))
    private String emailAddress;

    @OneToMany(mappedBy = "customerOrders")
    @JoinColumn(name ="id")
    private List<CustomerOrder> customerOrders;

    public Client() {
    }

    public Client(String name, String emailAddress) {
        this.name = name;;
        this.emailAddress = emailAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<CustomerOrder> getOrders() {
        return customerOrders;
    }

    public void setOrders(List<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }
}
