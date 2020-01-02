# Crecker_Android
Crecker_Android파트 git 장소입니다.

* ## 프로젝트 기간 및 참여자
	- 2019.12.22 ~ 2020.1.3
	- 참여자 : 강민구, 박현준, 이주연

* ## 개발 환경

	- Android Studio

# 사용 라이브러리

- [retrofit](https://square.github.io/retrofit/) + [gson](https://github.com/google/gson) : Json 데이터를 활용한 REST 서버 통신을 위해 사용 
- [glide](https://github.com/bumptech/glide) : 일관성 있고 빠른 이미지 로딩을 위해 사용
- [google material](https://github.com/material-components/material-components-android) : google material design 적용을 위해 사용
- [BannerViewPager](https://github.com/zhpanvip/BannerViewPager) : 자동으로 스크롤되는 뷰페이저 구현을 위해 사용
- [otto](https://github.com/square/otto) : 컴포넌트 간 통신을 위해 사용(Fragment에서 Activity의 onActivityForResult를 받기 위해)
- [lottie](https://github.com/airbnb/lottie-android) : 움직이는 이미지로 스플래시 화면 구성을 위해 사용
- [TedImagePicker](https://github.com/ParkSangGwon/TedImagePicker) : 프로필 이미지 업로드 시 이미지 선택을 위해 사용

# 기능 구현 방법
* ## lottie를 이용한 스플래시 화면
	- SplashActivity
	
	```
	val animationView = findViewById<LottieAnimationView>(R.id.splash_img)
        animationView.setAnimation("splash.json")
        animationView.playAnimation()
	```
	
	* LotteAnimationView를 생성하고 애니메이션 파일을 적용
	
	```
	private fun startLoading(){
        	val handler = Handler()
        	handler.postDelayed(Runnable {
            	run {
                	startActivity(Intent(application, MainActivity::class.java))
                	finish()
           	 }
       		},1000)
    	}
    	override fun onBackPressed() {}
	
	```
	`startLoading()`함수 안에 핸들러 객체를 생성하고 스플래시 화면 효과를 구성
	`onBackPressed()`를 오버라이드 함으로서 스플래시 화면이 나오는 중 뒤로가기 버튼이 동작하지 않도록 설정

	- AndroidManifest
	
	```
	<activity
            android:name=".main.SplashActivity"
            android:theme="@android:style/Theme.NoTitleBar.Fullscreen"
            android:screenOrientation="portrait"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
	```
	
	manifest 파일에서 가장 처음 나오는 액티비티 구조 변경

	- activity_splash.xml
	
	```
	<?xml version="1.0" encoding="utf-8"?>
	<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    	xmlns:app="http://schemas.android.com/apk/res-auto"
    	xmlns:tools="http://schemas.android.com/tools"
    	android:layout_width="match_parent"
    	android:layout_height="match_parent"
    	tools:context=".main.SplashActivity"
    	android:background="#000000">

    	<com.airbnb.lottie.LottieAnimationView
        	android:id="@+id/splash_img"
        	android:layout_width="0dp"
        	android:layout_height="0dp"
        	app:layout_constraintBottom_toBottomOf="parent"
        	app:layout_constraintEnd_toEndOf="parent"
        	app:layout_constraintStart_toStartOf="parent"
        	app:layout_constraintTop_toTopOf="parent" />
	</androidx.constraintlayout.widget.ConstraintLayout>
	```
	
* ## Custom View로 TabLayout 아이콘 만들기
	- custom_tab_button.xml
	
	```
	<?xml version="1.0" encoding="utf-8"?>
	<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    	xmlns:app="http://schemas.android.com/apk/res-auto"
    	xmlns:tools="http://schemas.android.com/tools"
    	android:layout_width="wrap_content"
    	android:layout_height="wrap_content">

    	<ImageView
        android:id="@+id/Tab_ic"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
         />
	</androidx.constraintlayout.widget.ConstraintLayout>
	```
	TabLayout에 들어갈 CustomView
	
	- MainActivity
	
	```
	override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
	
	...
	
	main_tabLayout.getTabAt(0)?.customView = initCustomView(0) // Home 로고
        main_tabLayout.getTabAt(1)?.customView = initCustomView(1) // Ads 로고
        main_tabLayout.getTabAt(2)?.customView = initCustomView(2) // Law 로고
        main_tabLayout.getTabAt(3)?.customView = initCustomView(3) // News 로고
        main_tabLayout.getTabAt(4)?.customView = initCustomView(4) // MyPage 로고
	
	...
	
	}
	```
	TabLayout에 커스텀뷰를 넣어준다.
	
	```
	private fun initCustomView(position : Int) : View {
        val tabView = LayoutInflater.from(mContext).inflate(R.layout.custom_tab_button, null)

        when(position){
            0 -> tabView.Tab_ic.setImageResource(R.drawable.select_tab_home)
            1-> tabView.Tab_ic.setImageResource(R.drawable.select_tab_ads)
            2-> tabView.Tab_ic.setImageResource(R.drawable.select_tab_law)
            3-> tabView.Tab_ic.setImageResource(R.drawable.select_tab_news)
            4-> tabView.Tab_ic.setImageResource(R.drawable.select_tab_mypage)
        }
        return tabView
        }
	
	```
	position값에 따라 적절한 이미지를 넣어준다.
	
	- select_tab_home.xml
	
	```
	<?xml version="1.0" encoding="utf-8"?>
	<selector xmlns:android="http://schemas.android.com/apk/res/android">
    	<item android:drawable="@drawable/tab_home" android:state_selected="false" android:state_focused="false" android:state_pressed="false"/>
    	<item android:drawable="@drawable/tab_home_filled" android:state_selected="true"/>
	</selector>
	
	```
	TabLayout에 들어가는 아이콘의 이미지는 drawable객체를 이용해, 체크됨에 따라 이미지를 변경시켜준다.

* ## 키보드가 보여질 때 화면 스크롤 기능
	- MainActivity.kt
	
	```
	class MainActivity : AppCompatActivity() {

    	private lateinit var keyboardVisibilityUtils: KeyboardVisibilityUtils

    	override fun onCreate(savedInstanceState: Bundle?) {
        	super.onCreate(savedInstanceState)
        	setContentView(R.layout.activity_main)
       		keyboardVisibilityUtils = KeyboardVisibilityUtils(window,
                onShowKeyboard = { keyboardHeight ->
                    sv_root.run {
                        smoothScrollTo(scrollX, scrollY + keyboardHeight)
                    }
                })
    	}

    	override fun onDestroy() {
        	keyboardVisibilityUtils.detachKeyboardListeners()
        	super.onDestroy()
    	}
	```
	sv_root -> 스크롤뷰 id 값
	KeyboardVisibilityUtils클래스를 만들 때 인자로 window를 전달하고 onShowKeyboard를 통해 ScroolView를 키보드 높이만큼 스크롤  
	onShowKeyboard : 키보드가 보여질 때 해당 코드 호출

# 프로그램 구조
* ### ads
	* activity : 광고 뷰와 관련된 activity
	* banner : 오토스크롤 뷰페이저(배너) 구현과 관련된 것들
	* category : 광고 카테고리 전환과 관련된 것들
	* contents : 광고 내용(data class + recycleradapter + viewholder)
	* fragment : 광고 뷰와 관련된 fragment
* ### home
	* adapter : 리사이클러뷰 어댑터 관리 패키지
	* data : home 탭의 리사이클러뷰에서 사용하는 data class 패키지
	* viewholder : 리사이클러뷰에 사용하는 뷰 홀더 패키지 
	* fragment : home 뷰와 관련된 fragment
* ### law
	* adapter : 배너 및 리사이클러뷰 어댑터 관리 패키지
	* data : law 탭에서 사용하는 data class 패키지
	* viewholder : 리사이클러뷰에 사용하는 뷰 홀더 패키지
* ### main
* ### module
	- 리사이클러뷰 여백설정 기능, 커스텀뷰페이저, 바텀시트 컨트롤러, 익스텐션 함수 등을 보관
* ### mypage
	* activity : 마이페이지 뷰와 관련된 activity
	* contents : 각종 데이터(data class + recycleradapter + viewholder) ex)이용내역
	* fragment : 마이페이지 뷰와 관련된 fragment
* ### news
	* adapter : 배너 및 리사이클러뷰 어댑터 관리 패키지
	* data : news 탭에서 사용하는 data class 패키지
	* feature : news 프래그먼트 내부 탭에 사용할 프래그먼트 패키지
	* viewholder : 리사이클러뷰에 사용하는 뷰 홀더 패키지

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
