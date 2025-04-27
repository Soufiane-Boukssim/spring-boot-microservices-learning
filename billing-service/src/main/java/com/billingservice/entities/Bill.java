package com.billingservice.entities;

import com.billingservice.models.Customer;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    private Long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems= new ArrayList<ProductItem>();
    @Transient //Customer nest représenté dans db de ce microservice pour cela on a ajouter customerId
    private Customer customer;
}
