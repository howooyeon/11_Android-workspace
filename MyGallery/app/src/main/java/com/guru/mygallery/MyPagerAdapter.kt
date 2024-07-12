
package com.guru.mygallery

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


class MyPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    // 뷰페이저가 표시할 프래그먼트 목록
    private val items = ArrayList<Fragment>()

    // 프래그먼트의 갯수
    override fun getCount(): Int {
        return items.size
    }

    // position 위치의 프래그먼트
    override fun getItem(position: Int): Fragment {
        return items[position]
    }

    fun updateFragments(items:List<Fragment>){
        this.items.addAll(items)
    }

}