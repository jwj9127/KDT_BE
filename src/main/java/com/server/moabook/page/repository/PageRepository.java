package com.server.moabook.page.repository;

import com.server.moabook.page.domain.Element;
import com.server.moabook.page.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {
    List<Element> findByBook_IdAndPageNumber(Long bookId, Long pageNumber);
    List<Page> findAllByBook_Id(Long bookId);
}
