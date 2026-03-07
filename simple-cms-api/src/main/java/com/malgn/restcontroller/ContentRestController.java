package com.malgn.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.malgn.entity.Content;
import com.malgn.service.ContentService;

@CrossOrigin
@RestController
@RequestMapping("/api/contents")
public class ContentRestController {

	@Autowired
	private ContentService contentService;
	
	// 전체 조회
    @GetMapping
    public List<Content> selectList() {
        return contentService.selectList();
    }

    // 단건 조회
    @GetMapping("/{id}")
    public Content selectOne(@PathVariable Long id) {
        return contentService.selectOne(id);
    }

    // 등록
    @PostMapping
    public Content create(@RequestBody Content content) {
        return contentService.create(content);
    }

    // 수정
    @PutMapping("/{id}")
    public Content update(@PathVariable Long id,
    			@RequestBody Content content,
    			@RequestParam String loginId, @RequestParam String loginRole) {
    	contentService.check(id, loginId, loginRole);
    	return contentService.update(id, content);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id,
    		@RequestParam String loginId, @RequestParam String loginRole) {
    	contentService.check(id, loginId, loginRole);
        contentService.delete(id);
    }
}
