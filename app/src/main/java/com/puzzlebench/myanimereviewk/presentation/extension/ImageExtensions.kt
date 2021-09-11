package com.example.myitemssearchk.presentation.extension

import android.widget.ImageView
import com.puzzlebench.myanimereviewk.R
import com.squareup.picasso.Picasso

fun ImageView.getImageByUrl(url: String) {
    Picasso.with(context).load(url).error(R.drawable.ic_photo_120).into(this)
}