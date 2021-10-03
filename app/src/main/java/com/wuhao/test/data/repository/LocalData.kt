package com.wuhao.test.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.wuhao.test.common.Constants.SHARED_PREFERENCES_FILE_NAME
import com.wuhao.test.common.Constants.SHARED_PREFERENCES_POST_KEY
import com.wuhao.test.common.Resource
import com.wuhao.test.data.model.PostItem
import javax.inject.Inject

class LocalData @Inject constructor(
    private val context: Context,
    private val gson: Gson
) {

    // replace with proper lib.
    fun savePosts(posts: List<PostItem>): Resource<Boolean> {
        val sharedPref = context.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, 0)
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putString(SHARED_PREFERENCES_POST_KEY, gson.toJson(posts))
        editor.apply()
        val isSuccess = editor.commit()
        return Resource.Success(isSuccess)
    }

}