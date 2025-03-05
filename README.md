## 📛프로젝트명 - 모아북(MoABook)

#### 단순히 정보를 저장하는게 아닌 모은 정보를 직접 자신만의 것으로 기록하는 것

<br/>

## 🚧프로젝트 소개

직접 글이나 이미지를 이용해 정리하여 마치 직접 책처럼 엮는 것처럼 정리할 수 있으면 좋겠다고 판단했기 때문에 해당 KDT 프로젝트의 주제로 선정하였습니다. 자세한 정보는 [여기](https://github.com/user-attachments/files/19094753/KDT.2.pdf)를 참고해주세요!

## 👩🏻‍💻 프로젝트 참여 인원

#### PM,Design - 1명
#### Frontend - 3명
#### Backend - 3명

## ✨ 기술 스택

- 기획,디자인 : <img src="https://img.shields.io/badge/figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white">
- 프론트엔드 : <img src="https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=React&logoColor=white">  <img src="https://img.shields.io/badge/Netlify-00C7B7?style=for-the-badge&logo=Netlify&logoColor=white" />

- 백엔드 : <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/spring Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> <img src="https://img.shields.io/badge/JPA-6DB33F?style=for-the-badge&logo=JPA&logoColor=white"/> <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white" /> 
<img src="https://img.shields.io/badge/AWS EC2-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white" /> <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white" /> <img src="https://img.shields.io/badge/GitHub Actions-2088FF?style=for-the-badge&logo=githubactions&logoColor=white" />

- ETC : <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"> <img src="https://img.shields.io/badge/notion-000000?style=for-the-badge&logo=notion&logoColor=white">


## 💡 서비스 핵심 기능

**`카테고리 리소스 그룹`**

<br/>

  - 책의 카테고리를 나눌 수 있는 리소스 그룹

<br/>

**`달력`**

<br/>

  - 당일 스터디 여부를 확인할 수 있습니다.
  - 문제, 채팅 기록을 확인할 수 있습니다.

<br/>

**`페이지 단위 내용 편집 & 알림 기능`**

<br/>

  - 책에 포함된 페이지 단위로 TEXT , IMG , URL 의 내용을 편집하는 기능
  - 접속을 장기간 하지 않을 시 메모리 낭비 방지를 위해 이메일로 알림을 보내주는 기능

<br/>

**`문서 공유`**

<br/>

  - 내가 만든 책을 URL , PDF 형식으로 저장 , 공유할 수 있음

<br/>

## 🖼️ 디자인

- 시작화면
<center><img src ="https://github.com/user-attachments/assets/eb7dc518-60c6-4bfb-94b1-801542e6f0c7" /></center>

- 메인 화면 (책 카테고리 화면)
<center> <img src ="https://github.com/user-attachments/assets/de1437b4-1292-4e9c-85cb-732d6a24e38f" /></center>

- 페이지 구성 화면
<center> <img src ="https://github.com/user-attachments/assets/acc93dfa-abd0-4fd1-a010-075d5d014a68" /></center>

## 🍆 본인이 구현한 기능

- ERD, 디렉토리 구조와 OAuth2 로그인 기능을 보일러 플레이트

- 유저 정보 조회 및 탈퇴, 기록 삭제 등 유저 CRUD 개발

- 책의 카테고리 그룹을 나눌 수 있는 그룹 CRUD 개발

- 페이지를 하나로 묶은 책 CRUD 개발

- 페이지 생성, 조회, 페이지의 elementType에 대한 x,y 포지션을 저장하는 등 관련 CRUD 개발

## 🚩 트러블 슈팅

### 1. 문제 - 보일러 플레이트
#### 상황
- 디렉토리 구조는 어떻게 잡을 지, ERD는 어떻게 짜는 지에 대한 경험 부족 사태

#### 해결 방법
- 다른 개발자 분들의 깃허브 , 벨로그 등을 참고하여 모방

#### 배운 점 
- 개발도 결국은 잘 만들어진 코드(구조, ERD 등)를 모방하는 것에서 시작한다고 느꼈다.

### 2. 문제 - API Mapping 문제 발생
#### 상황
- GET 매핑이 잘 해결되지 않는 문제 발생

#### 해결 방법
- Request Body로 받는 형식을 Pathvariable로 변경하여 데이터를 비지니스 로직까지 잘 전달

#### 배운 점 
- GET 매핑은 Request Body 형식을 사용할 수 없다.
- PostMan에서 테스트가 됐다고 실제 서비스에서 오류가 없는 것은 아니다.
