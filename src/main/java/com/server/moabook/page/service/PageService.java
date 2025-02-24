package com.server.moabook.page.service;

import com.server.moabook.book.domain.Book;
import com.server.moabook.page.dto.request.*;
import com.server.moabook.book.repository.BookRepository;
import com.server.moabook.global.exception.NotFoundException;
import com.server.moabook.global.exception.message.ErrorMessage;
import com.server.moabook.oauth2.repository.UserRepository;
import com.server.moabook.page.domain.Element;
import com.server.moabook.page.domain.Page;
import com.server.moabook.page.dto.PageMapper;
import com.server.moabook.page.dto.response.SelectAllPageResponseDto;
import com.server.moabook.page.dto.response.SelectPageResponseDto;
import com.server.moabook.page.repository.PageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PageService {

    private final PageRepository pageRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public void createPage(Long userId, CreatePageRequestDto createPageRequestDto){
        userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(String.valueOf(ErrorMessage.USER_NOT_FOUND)));
        Book book = bookRepository.findById(createPageRequestDto.bookId())
                .orElseThrow(() -> new NotFoundException(ErrorMessage.GROUP_NOT_FOUND));
        Page page = PageMapper.toEntity(book);
        pageRepository.save(page);
    }

    public void savePage(Long userId, SavePageRequestDto savePageRequestDto){
        userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(String.valueOf(ErrorMessage.USER_NOT_FOUND)));
        Book book = bookRepository.findById(savePageRequestDto.bookId())
                .orElseThrow(() -> new NotFoundException(ErrorMessage.GROUP_NOT_FOUND));
        Page page = PageMapper.toSave(book, savePageRequestDto);
        pageRepository.save(page);
    }

    public SelectPageResponseDto selectPage(Long userId, SelectPageRequestDto selectPageRequestDto){
        userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(String.valueOf(ErrorMessage.USER_NOT_FOUND)));
        List<Element> elements = pageRepository.findByBook_IdAndPageNumber(
                selectPageRequestDto.bookId(),
                selectPageRequestDto.pageNumber()
        );
        if(elements.isEmpty()){
            throw new NotFoundException(ErrorMessage.PAGE_NOT_FOUND);
        }
        return PageMapper.toDTO(elements);
    }

    public SelectAllPageResponseDto selectAllPage(Long userId, SelectAllPageRequestDto selectAllPageRequestDto){
        userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(String.valueOf(ErrorMessage.USER_NOT_FOUND)));
        List<Page> pages = pageRepository.findAllByBook_Id(selectAllPageRequestDto.bookId());
        if(pages.isEmpty()){
            throw new NotFoundException(ErrorMessage.PAGE_NOT_FOUND);
        }
        return PageMapper.AlltoDTO(pages);
    }

    public void deletePage(Long userId, DeletePageRequestDto deletePageRequestDto){
        userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(String.valueOf(ErrorMessage.USER_NOT_FOUND)));
        bookRepository.findById(deletePageRequestDto.bookId())
                .orElseThrow(() -> new NotFoundException(ErrorMessage.GROUP_NOT_FOUND));
        Page page = pageRepository.findById(deletePageRequestDto.pageId())
                .orElseThrow(()-> new NotFoundException(ErrorMessage.PAGE_NOT_FOUND));
        pageRepository.delete(page);
    }

}
