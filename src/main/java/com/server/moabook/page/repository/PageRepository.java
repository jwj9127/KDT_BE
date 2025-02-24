package com.server.moabook.page.repository;

import com.server.moabook.page.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {
    Page findByBook_IdAndPageNumber(Long bookId, Long pageNumber);
}
