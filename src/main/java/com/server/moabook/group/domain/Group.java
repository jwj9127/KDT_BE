package com.server.moabook.group.domain;

import com.server.moabook.oauth2.entity.SocialUserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.Date;

@Entity
@Table(name = "group")
@Getter
@Setter
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long groupId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private SocialUserEntity user;

}
