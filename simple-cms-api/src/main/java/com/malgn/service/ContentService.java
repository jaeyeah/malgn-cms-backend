package com.malgn.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malgn.entity.Content;
import com.malgn.repository.ContentRepository;

@Service
public class ContentService {

	@Autowired
	private ContentRepository contentRepository;
	
	//전체 조회
	public List<Content> selectList(){
		return contentRepository.findAll();
	}
	
	//조회
	public Content selectOne(Long id) {
		return contentRepository.findById(id)
				.orElseThrow(()->new RuntimeException("해당 게시글이 없습니다"));	
	}
	
	//등록
	public Content create(Content content) {
		return contentRepository.save(content);
	}
	
	//수정
	public Content update(Long id, Content request) {
		Content content = contentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 게시글이 없습니다. id=" + id));
        content.setTitle(request.getTitle());
        content.setDescription(request.getDescription());
        content.setLastModifiedDate(LocalDateTime.now());
        content.setLastModifiedBy(request.getLastModifiedBy());

        return contentRepository.save(content);
	}
	
	//삭제
	public void delete(Long id) {
        Content content = contentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 게시글이 없습니다. id=" + id));
        contentRepository.delete(content);
	}
	
	
}
