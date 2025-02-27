package com.server.moabook.page.domain;

import com.server.moabook.book.domain.Book;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "page")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pageId;

    @Column(unique=true)
    private Long pageNumber;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;

    @OneToMany(mappedBy = "page", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Element> elements;

}
