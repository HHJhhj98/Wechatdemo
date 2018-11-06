package com.example.wechatdemo;

import java.util.ArrayList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity {

	RadioGroup mrg;
	RadioButton mr1, mr2, mr3, mr4;
	ViewPager mvp;
	ArrayList<Fragment> fragments;
	ArrayList<RadioButton> radioButtons;
	int a = 0;
	Button mbtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initview();
	

	}

	private void setAdapter() {
		// TODO Auto-generated method stub
		fragments = new ArrayList<Fragment>();
		switch (a) {
		case 1:
			fragments.add(new Fragment1());
			break;
		case 2:
			fragments.add(new Fragment1());
			fragments.add(new Fragment2());
			break;
		case 3:
			fragments.add(new Fragment1());
			fragments.add(new Fragment2());
			fragments.add(new Fragment3());
			break;
		default:
			fragments.add(new Fragment1());
			fragments.add(new Fragment2());
			fragments.add(new Fragment3());
			fragments.add(new Fragment4());
			break;
		}

		MyAdapter adapter = new MyAdapter(getSupportFragmentManager(),
				fragments);
		mvp.setAdapter(adapter);
	}

	private void initview() {
		// TODO Auto-generated method stub
		mvp = (ViewPager) findViewById(R.id.vp);
		mrg = (RadioGroup) findViewById(R.id.rg);
		mr1 = (RadioButton) findViewById(R.id.r1);
		mr2 = (RadioButton) findViewById(R.id.r2);
		mr3 = (RadioButton) findViewById(R.id.r3);
		mr4 = (RadioButton) findViewById(R.id.r4);
		mr2.setVisibility(View.GONE);
		mr3.setVisibility(View.GONE);
		mr4.setVisibility(View.GONE);
		mbtn = (Button) findViewById(R.id.btn);
		mbtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				a++;
				switch (a) {
				case 1:
					mr2.setVisibility(View.VISIBLE);
					break;
				case 2:
					mr2.setVisibility(View.VISIBLE);
					mr3.setVisibility(View.VISIBLE);
					break;
				case 3:
					mr2.setVisibility(View.VISIBLE);
					mr3.setVisibility(View.VISIBLE);
					mr4.setVisibility(View.VISIBLE);
					break;
				default:

					break;
				}

			}
		});
		radioButtons = new ArrayList<RadioButton>();
		radioButtons.add(mr1);
		radioButtons.add(mr2);
		radioButtons.add(mr3);
		radioButtons.add(mr4);
		mvp.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				for (int i = 0; i < radioButtons.size(); i++) {
					if (i == arg0) {
						radioButtons.get(i).setTextColor(0xff00db00);

					} else {
						radioButtons.get(i).setTextColor(Color.BLACK);
					}
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
		mrg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				if (arg1 == mr1.getId()) {
					mvp.setCurrentItem(0);
					mr1.setTextColor(0xff00db00);
					mr2.setTextColor(0xff000000);
					mr3.setTextColor(0xff000000);
					mr4.setTextColor(0xff000000);
				} else if (arg1 == mr2.getId()) {
					mvp.setCurrentItem(1);
					mr2.setTextColor(0xff00db00);
					mr1.setTextColor(0xff000000);
					mr3.setTextColor(0xff000000);
					mr4.setTextColor(0xff000000);
				} else if (arg1 == mr3.getId()) {
					mvp.setCurrentItem(2);
					mr3.setTextColor(0xff00db00);
					mr2.setTextColor(0xff000000);
					mr1.setTextColor(0xff000000);
					mr4.setTextColor(0xff000000);
				} else {
					mvp.setCurrentItem(3);
					mr4.setTextColor(0xff00db00);
					mr2.setTextColor(0xff000000);
					mr3.setTextColor(0xff000000);
					mr1.setTextColor(0xff000000);
				}
			}
		});
		setAdapter();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
