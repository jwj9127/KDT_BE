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
    private Long elementId;

    @Enumerated(EnumType.STRING)
    private ElementType elementType;

    private String xPosition;

    private String yPosition;

    private String content;

    @ManyToOne
    @JoinColumn(name = "pageId")
    private Page page;

    public void updateContent(String newContent) {
        this.content = newContent;
    }

    public void updatePosition(String newXPosition, String newYPosition) {
        this.xPosition = newXPosition;
        this.yPosition = newYPosition;
    }
}
