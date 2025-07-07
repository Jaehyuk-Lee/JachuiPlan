# 🏠 자취플랜: 전월세 평균가 및 자취 커뮤니티

## 📘 프로젝트 소개
JachuiPlan은 전월세 부동산(오피스텔, 주택) 통계, 커뮤니티, 지도 기반 검색 등 다양한 기능을 제공하는 부동산 정보 서비스입니다.

### 🕑 기간
2024.12.12 ~ 2025.01.06 (4주)

### 💁 팀원 소개
|팀장|팀원|팀원|팀원|
|:---:|:---:|:---:|:---:|
|![image](https://github.com/Jaehyuk-Lee.png)|![image](https://github.com/seonghyuning.png)|![image](https://github.com/jjoool.png)|![image](https://github.com/hwakyung99.png)|
|[이재혁](https://github.com/Jaehyuk-Lee)|[김성현](https://github.com/seonghyuning)|[김정은](https://github.com/jjoool)|[이화경](https://github.com/hwakyung99)

### 배경 및 기대효과
**배경**
- 자취를 처음 시작하는 2-30대를 위한 각 지역의 월세/전세 정보를 한눈에 확인할 수 있는 효율적인 정보를 제공
- 자취 생활과 관련된 정보 공유와 소통이 가능한 커뮤니티를 제공하여 자취생 간의 네트워크를 형성

**기대효과**
- 자취 희망자의 정보 탐색 시간 절약
- 자취 생활의 질과 지식 향상

### 주요 기능
- **매물/오피스텔 검색**: 다양한 조건(지역, 면적, 건축년도, 층수 등)으로 매물 및 오피스텔 검색
- **지역 코드/지도 기반 검색**: 행정구역 코드 기반의 지역 정보 및 지도 내 지역 검색
- **커뮤니티/게시판**: 사용자 간 소통을 위한 게시판 및 댓글 기능
- **스크랩/좋아요**: 관심 매물, 게시글 스크랩 및 좋아요 기능
- **회원/인증**: OAuth2(구글) 기반 로그인, 회원가입, 마이페이지 등

### 역할 분배
![image](<docs/images/readme/role.png>)

## 🛠️ 기술 스택

![Java](https://img.shields.io/badge/Java-21-blue?style=flat&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-6DB33F?style=flat-square&logo=Spring&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=flat)
![Spring Security](https://img.shields.io/badge/springsecurity-6DB33F?style=flat&logo=spring&logoColor=white)
![Node.js](https://img.shields.io/badge/Node.js-5FA04E?style=flat&logo=node.js&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=flat)
![React](https://img.shields.io/badge/React-61DAFB?style=flat&logo=react&logoColor=black)
![Oracle](https://img.shields.io/badge/Oracle-red?style=flat&logo=oracle)

### 프론트엔드 구성

본 프로젝트는 Thymeleaf와 React를 모두 사용합니다.
- 커뮤니티는 서버 사이드 렌더링 및 간단한 데이터 바인딩이 필요한 경우 Thymeleaf를 사용합니다.
- 지도 등 동적이고 인터랙티브한 UI가 필요한 부분은 React와 D3.js를 활용하여 구현하였습니다.
- 프로젝트 진행 당시 팀원들이 React를 학습 중이었기 때문에, 일정에 맞춰 일부는 Thymeleaf로, 일부는 React로 개발하였습니다.

각 기술의 장점을 살리고 요구되는 화면의 특성에 따라 적합한 방식을 선택했습니다.

## 📂 프로젝트 구조
```
├── src/main/java/com/trace/jachuiplan
│   ├── auth/           # 인증 및 OAuth2
│   ├── user/           # 사용자(회원가입, 마이페이지 등)
│   ├── building/       # 건물(매물) 관련
│   ├── officeHotel/    # 오피스텔 관련
│   ├── board/          # 게시판/커뮤니티
│   ├── reply/          # 댓글
│   ├── scrap/          # 스크랩(즐겨찾기)
│   ├── likes/          # 좋아요
│   ├── regioncd/       # 지역 코드/행정구역
│   ├── map/            # 지도 페이지 컨트롤러
│   └── ...
├── src/main/map/       # 지도 페이지 React 프론트엔드
```

## 🗄️ 데이터베이스 구축 안내

본 프로젝트에서 사용하는 데이터베이스는 별도의 데이터 적재 프로젝트([JachuiPlan_ApiToDb](https://github.com/sesac-mini2/JachuiPlan_ApiToDb))를 통해 구축할 수 있습니다.
- Node.js 기반의 데이터 적재 도구로, 공공 API에서 데이터를 수집하여 Oracle DB에 입력합니다.
- 사용법, 환경설정 등 자세한 내용은 [JachuiPlan_ApiToDb](https://github.com/sesac-mini2/JachuiPlan_ApiToDb)를 참고하세요.

## ⚙️ 빌드 및 실행 방법

반드시 프론트엔드를 먼저 빌드하고 백엔드를 빌드해야 합니다. 빌드된 프론트엔드 소스코드를 Spring Boot 어플리케이션이 포함하는 형태로 빌드됩니다.

### 1. 프론트엔드(React)
```bash
cd src/main/map
npm install
npm run build
```

### 2. 백엔드(Spring Boot)
```bash
./gradlew build
java -jar build/libs/*.jar
```

## 🔗 주요 API 예시
### 1. 지역 코드/행정구역
- **시도 목록 조회**: `GET /api/regioncd`
- **시도/시군구 목록 조회**: `GET /api/regioncd/{sidocd}`
- **시군구/읍면동 목록 조회**: `GET /api/regioncd/{sidocd}/{sggcd}`
- **지도 영역 내 지역 조회**: `GET /api/regioncd/regionsInBounds?north=...&east=...&south=...&west=...&level=...`

### 2. 매물/오피스텔 검색
- **건물 검색**: `GET /api/building/search?sggcds=...&startYearMonth=...&endYearMonth=...`
- **오피스텔 검색**: `GET /api/officeHotel/search?sggcds=...&startYearMonth=...&endYearMonth=...`

### 3. 평균/변동 정보
- **건물 평균**: `GET /api/building/average?...`
- **오피스텔 평균**: `GET /api/officeHotel/average?...`
- **건물 변동**: `GET /api/building/transition?...`
- **오피스텔 변동**: `GET /api/officeHotel/transition?...`

## 📄 추가 문서
[ExactSize](/docs/annotation/EXACT_SIZE.md): ExactSize 어노테이션 사용법
