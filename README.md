# JachuiPlan

## 소개
JachuiPlan은 전월세 부동산(오피스텔, 주택) 통계, 커뮤니티, 지도 기반 검색 등 다양한 기능을 제공하는 부동산 정보 서비스입니다. Spring Boot 기반의 백엔드와 Thymeleaf + React 기반의 프론트엔드로 구성되어 있습니다.

## 주요 기능
- **매물/오피스텔 검색**: 다양한 조건(지역, 면적, 건축년도, 층수 등)으로 매물 및 오피스텔 검색
- **지역 코드/지도 기반 검색**: 행정구역 코드 기반의 지역 정보 및 지도 내 지역 검색
- **커뮤니티/게시판**: 사용자 간 소통을 위한 게시판 및 댓글 기능
- **스크랩/좋아요**: 관심 매물, 게시글 스크랩 및 좋아요 기능
- **회원/인증**: OAuth2(구글) 기반 로그인, 회원가입, 마이페이지 등

## 기술 스택
- **백엔드**: Java 21, Spring Boot 3, Spring Data JPA, Spring Security, OAuth2, Oracle, Thymeleaf
- **프론트엔드**: React, Bootstrap, D3, Axios 등

## 프론트엔드 구성

본 프로젝트는 Thymeleaf와 React를 모두 사용합니다.
- 커뮤니티는 서버 사이드 렌더링 및 간단한 데이터 바인딩이 필요한 경우 Thymeleaf를 사용합니다.
- 지도 등 동적이고 인터랙티브한 UI가 필요한 부분은 React와 D3.js를 활용하여 구현하였습니다.
- 프로젝트 진행 당시 팀원들이 React를 학습 중이었기 때문에, 일정에 맞춰 일부는 Thymeleaf로, 일부는 React로 개발하였습니다.

각 기술의 장점을 살리고 요구되는 화면의 특성에 따라 적합한 방식을 선택했습니다.

## 프로젝트 구조
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

## 데이터베이스 구축 안내

본 프로젝트에서 사용하는 데이터베이스는 별도의 데이터 적재 프로젝트([JachuiPlan_ApiToDb](https://github.com/sesac-mini2/JachuiPlan_ApiToDb))를 통해 구축할 수 있습니다.
- Node.js 기반의 데이터 적재 도구로, 공공 API에서 데이터를 수집하여 Oracle DB에 입력합니다.
- 사용법, 환경설정 등 자세한 내용은 [JachuiPlan_ApiToDb](https://github.com/sesac-mini2/JachuiPlan_ApiToDb)를 참고하세요.

## 빌드 및 실행 방법

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

## 주요 API 예시
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

## 추가 문서
[ExactSize](/docs/annotation/EXACT_SIZE.md): ExactSize 어노테이션 사용법
