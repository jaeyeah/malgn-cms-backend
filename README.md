# 2026 신입 Back-End 개발자 코딩 과제
Spring Boot + Spring Security + JPA 기반, 콘텐츠 관리 시스템(백엔드) 구현

## Spec
- Java 25
- Spring Boot 4
- Spring Security
- JPA
- H2 (db)
- Lombok (필요시)

## ERD
User
 - userId
 - userName
 - userPassword
 - userRole

Content
 - id
 - title
 - description
 - viewCount
 - createdDate
 - createdBy
 - lastModifiedDate
 - lastModifiedBy

## 프로젝트 실행방법
### 1. 프로젝트 다운로드
git clone https://github.com/jaeyeah/malgn-cms-backend.git
### 2. 프로젝트 실행
### 3. H2 DB 접속
http://localhost:8080/h2-console


## 구현 기능
- 콘텐츠 목록 조회 (페이징)
- 콘텐츠 상세 조회
- 콘텐츠 추가  
- 콘텐츠 수정    (작성자 본인 or 관리자만)
- 콘텐츠 삭제    (작성자 본인 or 관리자만)

### 로그인
- Spring Security 기반
*** 1. 사용자가 userId와 userPassword로 로그인 요청
*** 2. Spring Security의 AuthenticationManager가 인증


# REST API
*** 회원가입
POST /api/user/join
*** 로그인
POST /api/user/login
*** 콘텐츠 등록
POST /api/contents
*** 콘텐츠 목록
GET /api/contents?page=&size=
*** 콘텐츠 상세조회
GET /api/content/{id}
*** 콘텐츠 수정
PUT /api/contents/{id}
*** 콘텐츠 삭제
put /api/contentes/{id}

# 사용한 AI 도구
- ChatGPT
  - MyBatis 방식 → JPA 방식 전환
  - Spring Security 로그인 구조 적용

