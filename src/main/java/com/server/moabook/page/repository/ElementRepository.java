package com.server.moabook.page.repository;

import com.server.moabook.page.domain.Element;
import com.server.moabook.page.domain.ElementType;
import com.server.moabook.page.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElementRepository extends JpaRepository<Element, Long> {

    List<Element> findAllByPageAndElementType(Page page, ElementType elementType);
}
