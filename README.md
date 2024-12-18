### 목차
- [프로젝트 개요](#project-overview)
- [개발 환경](#tech)
- [구현 사항](#requirement)
- [화면 구성](#screen-composition)


<h3 id="project-overview">📚프로젝트 개요</h3>

- 프로젝트 명 : 파일 확장자 차단
- 소개
    - 어떤 파일들은 첨부시 보안에 문제가 될 수 있다. 특히 exe, sh 등의 실행파일이 존재할 경우 서버에
      올려서 실행이 될 수 있는 위험이 있으니 해당 확장자 이외의 파일 확장자를 Blocking하는 프로젝트 

<h3 id="tech"> 🛠️ 개발 환경 ️</h3>

- Java 17
- SpringBoot 3.3.2
- JPA
- Thymeleaf
- MySQL
- Lombok

<h3 id="requirement"> 📃 구현 사항 </h3>

1. 첫 번째
    1. 고정 확장자는 차단을 자주하는 확장자를 리스트이며, default는 unCheck되어져 있습니다.
    2. 고정 확장자를 check or uncheck를 할 경우 db에 저장됩니다. - 새로고침시 유지되어야합니다.
       <br>(아래쪽 커스텀 확장자에는 표현되지 않으니 유의해주세요.)
2. 두 번째
    1. 확장자 최대 입력 길이는 20자리
    2. 추가버튼 클릭시 db 저장되며, 아래쪽 영역에 표현됩니다.
3. 세 번째
    1. 커스텀 확장자는 최대 200개까지 추가가 가능
    2. 확장자 옆 X를 클릭시 db에서 삭제

<h3 id="screen-composition"> 🖥️ 화면 구성 </h3>
- 추후 업데이트

