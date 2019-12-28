# Crecker_Android
Crecker_Android파트 git 장소입니다.

git을 이용할 때 몇가지 주의사항을 적어놓습니다. (추가할게 있을 경우 추가 요망)

* ## View id값
	* 버튼 : ~ _btn
	* RecyclerView item.xml : ~ list_item
	* RecyclerView : ~ _rv
	* 텍스트뷰 : ~ _tv
	* 이미지뷰 : ~ _img
	* 에디트텍스트 : ~ _edit
	
* ## 프로그램 구조
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
