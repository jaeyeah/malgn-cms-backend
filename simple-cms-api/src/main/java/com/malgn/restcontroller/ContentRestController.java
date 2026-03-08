package com.malgn.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.malgn.dto.PageDto;
import com.malgn.entity.Content;
import com.malgn.service.ContentService;

@CrossOrigin
@RestController
@RequestMapping("/api/contents")
public class ContentRestController {

	@Autowired
	private ContentService contentService;
	
	// 목록 조회
    @GetMapping
    public Page<Content> selectList(PageDto pageDto) {
        return contentService.selectList(pageDto);
    }

    // 상세 조회
    @GetMapping("/{id}")
    public Content selectOne(@PathVariable Long id) {
        return contentService.selectOne(id);
    }

    // 등록
    @PostMapping
    public Content create(@RequestBody Content content, Authentication authentication) {
        String loginId = authentication.getName();
    	return contentService.create(content, loginId);
    }

    // 수정
    @PutMapping("/{id}")
    public Content update(@PathVariable Long id,
    			@RequestBody Content content,
    			Authentication authentication) {
    	String loginId = authentication.getName();
        String loginRole = authentication.getAuthorities().stream()
                .map(auth -> auth.getAuthority())
                .findFirst()
                .orElse("");
    	contentService.check(id, loginId, loginRole);
    	return contentService.update(id, content);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id,
    		Authentication authentication) {
    	String loginId = authentication.getName();
    	String loginRole = authentication.getAuthorities().stream()
                .map(auth -> auth.getAuthority())
                .findFirst()
                .orElse("");
    	contentService.check(id, loginId, loginRole);
        contentService.delete(id);
    }
}
