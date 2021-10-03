package com.wuhao.test.presentation.postlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wuhao.test.data.model.PostItem


@Composable
fun PostItemScreen(
    postItem: PostItem,
    onItemClick: (PostItem) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(postItem) },
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = postItem.title,
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = postItem.body,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )
        Divider(color = androidx.compose.ui.graphics.Color.Gray, thickness = 1.dp)
    }
}