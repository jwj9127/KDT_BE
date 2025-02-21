package com.server.moabook.book.domain;

import com.server.moabook.group.domain.Group;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    private String name;

    private String url;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

}
