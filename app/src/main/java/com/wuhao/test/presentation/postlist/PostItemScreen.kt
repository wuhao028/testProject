package com.wuhao.test.presentation.postlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
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
    ) {
        Text(
            text = "(${postItem.title})",
            style = MaterialTheme.typography.body1,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "(${postItem.body})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Divider(color = androidx.compose.ui.graphics.Color.Gray, thickness = 1.dp)
    }
}