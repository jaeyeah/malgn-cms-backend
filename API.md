## REST API

### 회원가입
POST /api/user/join

Request
{
  "userId": "user1",
  "userName": "홍길동",
  "userPassword": "1234"
}

---

### 로그인
POST /api/user/login

Request
{
  "userId": "user1",
  "userPassword": "1234"
}

---

### 콘텐츠 목록 조회
GET /api/contents?page=1&size=10

---

### 콘텐츠 상세 조회
GET /api/contents/{id}

---

### 콘텐츠 등록
POST /api/contents  
(로그인 필요)

Request
{
  "title": "제목",
  "description": "내용"
}

---

### 콘텐츠 수정
PUT /api/contents/{id}  
(작성자 또는 ADMIN)

Request
{
  "title": "수정 제목",
  "description": "수정 내용"
}

---

### 콘텐츠 삭제
DELETE /api/contents/{id}  
(작성자 또는 ADMIN)
