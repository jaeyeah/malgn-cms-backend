package com.malgn.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.malgn.dto.PageDto;
import com.malgn.entity.Content;
import com.malgn.repository.ContentRepository;

@Service
public class ContentService {

	@Autowired
	private ContentRepository contentRepository;
	
	//전체 조회
//	public List<Content> selectList(){
//		return contentRepository.findAll();
//	}

	//전체 조회 (페이징 적용)
	public Page<Content> selectList(PageDto pageDto){
		Pageable pageable = PageRequest.of(pageDto.getPage()-1, pageDto.getSize());
		Page<Content> pageResult = contentRepository.findAll(pageable);
		pageDto.setTotalCount((int) pageResult.getTotalElements());
		return pageResult;
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
	
	
	//권한 체크 (작성자 확인 / 관리자 확인)
	public void check(Long id, String loginId, String loginRole) {
		Content content = contentRepository.findById(id)
				.orElseThrow(()->new IllegalArgumentException("존재하지 않는 콘텐츠입니다."));		
		boolean isWriter = content.getCreatedBy().equals(loginId);
		boolean isAdmin = "ADMIN".equals(loginRole);
		if (!isWriter && !isAdmin) {
            throw new IllegalArgumentException("수정 또는 삭제 권한이 없습니다.");
        }
	}
	
	
}
