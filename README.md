# Crecker_Android
Crecker_Android파트 git 장소입니다.

	#프로젝트 기간 및 참여자
	- 2019.12.22 ~ 2020.1.3
	- 참여자 : 강민구, 박현준, 이주연

	# 개발 환경

	- Android Studio

# 사용 라이브러리

- [retrofit](https://square.github.io/retrofit/) + [gson](https://github.com/google/gson) : Json 데이터를 활용한 REST 서버 통신을 위해 사용 
- [glide](https://github.com/bumptech/glide) : 일관성 있고 빠른 이미지 로딩을 위해 사용
- [google material](https://github.com/material-components/material-components-android) : google material design 적용을 위해 사용
- [BannerViewPager](https://github.com/zhpanvip/BannerViewPager) : 자동으로 스크롤되는 뷰페이저 구현을 위해 사용
- [otto](https://github.com/square/otto) : 컴포넌트 간 통신을 위해 사용(Fragment에서 Activity의 onActivityForResult를 받기 위해)

# 프로그램 구조
	* ### ads
		* #### activity : 광고 뷰와 관련된 activity
		* #### banner : 오토스크롤 뷰페이저(배너) 구현과 관련된 것들
		* #### category : 광고 카테고리 전환과 관련된 것들
		* #### contents : 광고 내용(data class + recycleradapter + viewholder)
		* #### fragment : 광고 뷰와 관련된 fragment
	* ### home
	* ### law
		* #### adapter : 배너 및 리사이클러뷰 어댑터 관리 패키지
		* #### data : law 탭에서 사용하는 data class 패키지
		* #### viewholder : 리사이클러뷰에 사용하는 뷰 홀더 패키지
	* ### main
	* ### module
		- 리사이클러뷰 여백설정 기능, 커스텀뷰페이저, 바텀시트 컨트롤러, 익스텐션 함수 등을 보관
	* ### mypage
		* #### activity : 마이페이지 뷰와 관련된 activity
		* #### contents : 각종 데이터(data class + recycleradapter + viewholder) ex)이용내역
		* #### fragment : 마이페이지 뷰와 관련된 fragment
	* ### news
		* #### adapter : 배너 및 리사이클러뷰 어댑터 관리 패키지
		* #### data : news 탭에서 사용하는 data class 패키지
		* #### feature : news 프래그먼트 내부 탭에 사용할 프래그먼트 패키지
		* #### viewholder : 리사이클러뷰에 사용하는 뷰 홀더 패키지


# 기타

* ## View id값
	* 버튼 : ~ _btn
	* RecyclerView item.xml : ~ list_item
	* RecyclerView : ~ _rv
	* 텍스트뷰 : ~ _tv
	* 이미지뷰 : ~ _img
	* 에디트텍스트 : ~ _edit	
	
* ## Git 사용 시 주의!
	* master 브랜치 절대 건들지 말 것!!
	* 다른 개발자의 부분 절대 건들지 말 것!!
	* 자기 브랜치에서 기능을 완성했을 경우 바로 Merge 시키지말고
	   반드시 Pull Request 하기
	* Pull Request시 자기가 작업한 뷰 및 기능 간단하게 설명.
	
* # Font Family Weight
	* ## apple_sd
		* light -> 200
		* regular -> 400
		* medium -> 500
		* bold -> 700
		* extrabold -> 900
	* ## montserrat
		* regular -> 400
		* medium -> 500
		* semibolditalic -> 600
		* bold -> 700
