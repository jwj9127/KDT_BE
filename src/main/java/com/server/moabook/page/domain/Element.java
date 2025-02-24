package com.server.moabook.page.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "element")
@Getter
@Builder
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "element_id")
    private Long elementId;

    @Enumerated(EnumType.STRING)
    private ElementType elementType;

    private String xPosition;

    private String yPosition;

    private String content;

    @ManyToOne
    @JoinColumn(name = "page_id")
    private Page page;

}
