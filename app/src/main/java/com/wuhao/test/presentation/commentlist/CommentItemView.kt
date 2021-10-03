package com.wuhao.test.presentation.commentlist

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.wuhao.test.data.model.CommentItem


@Composable
fun CommentItemView(
    commentItem: CommentItem
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Text(
            text = "${commentItem.name}",
            style = MaterialTheme.typography.h6,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "(${commentItem.email})",
            style = MaterialTheme.typography.caption,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "(${commentItem.body})",
            Modifier.padding(10.dp),
            style = MaterialTheme.typography.body2,
            overflow = TextOverflow.Ellipsis
        )
        Divider(color = Color.Gray, thickness = 1.dp)
    }

}