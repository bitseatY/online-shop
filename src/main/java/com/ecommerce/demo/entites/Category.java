package com.ecommerce.demo.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="categories")
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String slug;
    private String description;
    @OneToMany(mappedBy = "parentCategory",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Category> categories;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parentCategory;
    public Category(String name,String description,Category parentCategory){
        this.parentCategory=parentCategory;
        this.description=description;
        this.name=name;
        slug=name.toLowerCase().trim()
                .replaceAll("[^a-z0-9\\s-]", "")
                .replaceAll("\\s+", "-");

    }

}
