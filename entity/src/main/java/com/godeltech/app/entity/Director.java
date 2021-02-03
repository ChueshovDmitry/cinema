package com.godeltech.app.entity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/**
 * @author Dmitry Chueshov 26.01.2021 14:20
 * @project application
 */

@Data
@Entity
@Table
//@Table(name = "director",indexes = { @Index(name = "IND_NUMBER", columnList = "") })
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
    
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    
    @OneToMany(mappedBy = "director",
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Film> filmList;
    
}
