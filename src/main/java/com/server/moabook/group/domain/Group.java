package com.server.moabook.group.domain;

import com.server.moabook.book.domain.Book;
import com.server.moabook.oauth2.entity.SocialUserEntity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "Books")
@Getter
@Builder
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long groupId;

    private String name;

    private String color;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private SocialUserEntity user;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;

    public void changeName(String newName) {
        this.name = newName;
    }

}
