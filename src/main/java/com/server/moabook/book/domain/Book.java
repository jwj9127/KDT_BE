package com.server.moabook.book.domain;

import com.server.moabook.group.domain.Group;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter
@Setter
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

}
