package com.godeltech.app.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Dmitry Chueshov 26.01.2021 14:20
 * @project application
 */

@Data
@Builder
@Entity
@Table
public class Director implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "first_name",
            length = 255,
            nullable = false,
            unique = false
    )
    private String firstName;
    
    
    @Column(name = "last_name",
            length = 255,
            nullable = false,
            unique = false
    )
    private String lastName;
    
    @Temporal(TemporalType.DATE)
    @Column
    private Date birthDate;
    
    @OneToMany(mappedBy = "director",
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set <Film> filmSet = new HashSet<>();
    
    
    
}
