package com.example.newfeeds.fakedata

import com.example.newfeeds.R
import com.example.newfeeds.model.NewFeeds

class FakeList2() {
    fun fakeData(): List<NewFeeds>{
        return listOf<NewFeeds>(
           NewFeeds("Nguyen Van A", R.drawable.ic_launcher_background, "ABCDEZZZZZZZZ"),
           NewFeeds("Nguyen Van A", R.drawable.ic_launcher_background, "ABCDEZZZZZZZZ"),
           NewFeeds("Nguyen Van A", R.drawable.ic_launcher_background, "ABCDEZZZZZZZZ"),
           NewFeeds("Nguyen Van A", R.drawable.ic_launcher_background, "ABCDEZZZZZZZZ"),
           NewFeeds("Nguyen Van A", R.drawable.ic_launcher_background, "ABCDEZZZZZZZZ"),
           NewFeeds("Nguyen Van A", R.drawable.ic_launcher_background, "ABCDEZZZZZZZZ"),
        )
    }
}