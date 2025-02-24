package com.server.moabook.book.domain;

import com.server.moabook.group.domain.Group;
import com.server.moabook.page.domain.Page;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "book")
@Getter
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    private String name;

    private String url;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Page> pages;

    public void changeName(String newName) {
        this.name = newName;
    }

}
