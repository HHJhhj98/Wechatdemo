package com.example.wechatdemo;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class MyAdapter extends FragmentPagerAdapter{

	ArrayList<Fragment> fragments=new ArrayList<Fragment>();;

	public MyAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}
	public MyAdapter(FragmentManager fm,ArrayList<Fragment> fragments) {
		super(fm);
		this.fragments = fragments;
	}


	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		
        return fragments.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fragments.size();
	}

}
