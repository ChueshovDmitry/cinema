package com.godeltech.app.entity;
import lombok.Builder;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Dmitry Chueshov 26.01.2021 14:42
 * @project application
 */

@Data
@Builder
@Entity
@Table
public class Film implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "name",
            nullable = true,
            length = 255
    )
    private String name;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date releaseDate;
    
    @Column(name = "genre",
            nullable = true,
            length = 255
    )
    private String genre;
    
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "director_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "director_film_fk"))
    private Director director;
    
}

