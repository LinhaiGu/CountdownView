[![](https://jitpack.io/v/LinhaiGu/CountdownView.svg)](https://jitpack.io/#LinhaiGu/CountdownView)


![](https://github.com/LinhaiGu/CountdownView/blob/master/record.gif?raw=true)

Step 1. Add the JitPack repository to your build file

* gradle

Add it in your root build.gradle at the end of repositories:

```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency

```
	dependencies {
	        implementation 'com.github.LinhaiGu:CountdownView:v1.0.1'
	}
```


```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCountdown01();
        initCountdown02();
        initCountdown03();
        initCountdown04();
        initCountdown05();
    }

    private void initCountdown01(){
        final CountDownTextView countDownTextView=findViewById(R.id.countdown);
        countDownTextView.setDuration(8000);
        countDownTextView.showNumber(true);
        countDownTextView.setCountdownListener(new ICountdownListener() {

            @Override
            public void end() {
                Toast.makeText(MainActivity.this, "倒计时结束",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void start() {
                Toast.makeText(MainActivity.this, "倒计时开始",Toast.LENGTH_SHORT).show();
            }
        });
        countDownTextView.start();
    }

    private void initCountdown02(){
        final CountDownTextView countDownTextView=findViewById(R.id.countdown02);
        countDownTextView.setDuration(8000);
        countDownTextView.showNumber(true);
        countDownTextView.start();
    }

    private void initCountdown03(){
        final CountDownTextView countDownTextView=findViewById(R.id.countdown03);
        countDownTextView.setDuration(8000);
        countDownTextView.start();
    }

    private void initCountdown04(){
        final CountDownTextView countDownTextView=findViewById(R.id.countdown04);
        countDownTextView.setDuration(8000);
        countDownTextView.showNumber(true);
        countDownTextView.start();
    }

    private void initCountdown05(){
        final CountDownTextView countDownTextView=findViewById(R.id.countdown05);
        countDownTextView.setDuration(8000);
        countDownTextView.showNumber(true);
        countDownTextView.start();
    }
}

```


```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        xmlns:countdown="http://schemas.android.com/apk/res-auto"
        android:gravity="center_horizontal"
        android:layout_width="match_parent"
        android:paddingTop="20dp"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:context=".MainActivity">

    <com.boohee.countdownview.CountDownTextView
            android:id="@+id/countdown"
            android:layout_width="40dp"
            android:layout_height="40dp"
            android:gravity="center"
            android:textSize="13sp"
            android:textColor="#ffffff"
            android:background="@drawable/countdown_background"
            countdown:stroke_width="2dp"
            countdown:stroke_padding="2dp"
            countdown:stroke_color="#ffffff"
    />

    <LinearLayout
            android:id="@+id/ll_countdown"
            android:layout_width="wrap_content"
            android:paddingLeft="5dp"
            android:layout_marginTop="30dp"
            android:paddingRight="5dp"
            android:orientation="horizontal"
            android:gravity="center"
            android:background="@drawable/countdown_background01"
            android:layout_height="20dp">

        <TextView android:layout_width="wrap_content"
                  android:text="跳过广告"
                  android:textColor="#ffffff"
                  android:textSize="11sp"
                  android:layout_height="wrap_content"/>

        <com.boohee.countdownview.CountDownTextView
                android:id="@+id/countdown02"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:gravity="center"
                android:paddingLeft="2dp"
                android:textSize="11sp"
                android:textColor="#ffffff"
                countdown:stroke_show="false"
        />

    </LinearLayout>

    <com.boohee.countdownview.CountDownTextView
            android:id="@+id/countdown03"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:gravity="center"
            android:textSize="13sp"
            android:textColor="#ffffff"
            android:layout_marginTop="30dp"
            android:text="跳过"
            android:background="@drawable/countdown_background"
            countdown:stroke_width="3dp"
            countdown:stroke_padding="2dp"
            countdown:stroke_color="#008577"
    />

    <com.boohee.countdownview.CountDownTextView
            android:id="@+id/countdown04"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:gravity="center"
            android:textSize="15sp"
            android:textColor="@android:color/holo_blue_dark"
            android:layout_marginTop="30dp"
            countdown:stroke_show="false"
    />

    <com.boohee.countdownview.CountDownTextView
            android:id="@+id/countdown05"
            android:layout_width="40dp"
            android:layout_height="40dp"
            android:gravity="center"
            android:layout_marginTop="30dp"
            android:textSize="16sp"
            android:textColor="@android:color/white"
            android:background="@drawable/countdown_background02"
            countdown:stroke_show="false"
    />

    <TextView
            android:layout_width="wrap_content"
            android:layout_marginTop="30dp"
            android:text="颜色样式可以自由组合"
            android:textSize="19sp"
            android:textColor="@android:color/black"
            android:layout_height="wrap_content"/>

</LinearLayout>
```

countdown_background:

```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:state_pressed="true">
        <shape android:shape="oval">
            <solid android:color="#302d2d2d"/>
        </shape>
    </item>
    <item>
        <shape android:shape="oval">
            <solid android:color="#7F2d2d2d"/>
        </shape>
    </item>
</selector>
```
countdown_background01:

```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:state_pressed="true">
        <shape android:shape="rectangle">
            <corners android:radius="3dp"/>
            <solid android:color="#302d2d2d"/>
        </shape>
    </item>
    <item>
        <shape android:shape="rectangle">
            <corners android:radius="3dp"/>
            <solid android:color="#7F2d2d2d"/>
        </shape>
    </item>
</selector>
```
countdown_background02:

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
       android:shape="oval">

    <solid android:color="#23C5A3"/>

</shape>
```
