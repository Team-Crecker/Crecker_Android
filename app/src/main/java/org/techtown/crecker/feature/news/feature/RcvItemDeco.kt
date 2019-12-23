package org.techtown.crecker.feature.news.feature

import android.content.Context
import android.graphics.Rect
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.reflect.Type

class RcvItemDeco() : RecyclerView.ItemDecoration() {
    private var size20 : Int = 20
    private var size8 : Int = 20

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        Log.d("good","goodItemOffsets")
        var position : Int = parent.getChildAdapterPosition(view) // 아이템의 포지션(왼쪽 오른쪽)을 받아옴
        var itemCount : Int = state.itemCount // 전체 아이템 개수를 받아옴

        // 상하 설정

        if(position == 0 || position == 1){
            outRect.bottom = size20
        }else{
            outRect.bottom = size20
        }

    }

}