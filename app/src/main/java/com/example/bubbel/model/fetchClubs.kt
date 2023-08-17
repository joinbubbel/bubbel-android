package com.example.bubbel.model

import android.content.Context
import com.example.bubbel.R
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import com.example.bubbel.model.Club

class FetchClubs(private val context: Context) {

    val clubsList = ArrayList<Club>()

    fun fetch() {
        val factory = XmlPullParserFactory.newInstance()
        val parser = context.resources.getXml(R.raw.club_data)
        while (parser.next() != XmlPullParser.END_DOCUMENT) {
            if (parser.eventType == XmlPullParser.START_TAG && parser.name == "club") {
                var image: String? = null
                var title: String? = null
                var isVerified: Boolean = false
                var membersOnline: Int = 0
                while (parser.next() != XmlPullParser.END_TAG || parser.name != "club") {
                    if (parser.eventType == XmlPullParser.START_TAG) {
                        when (parser.name) {
                            "image" -> image = parser.nextText()
                            "title" -> title = parser.nextText()
                            "isVerified" -> isVerified = parser.nextText().toBoolean()
                            "membersOnline" -> membersOnline = parser.nextText().toInt()
                        }
                    }
                }
                // Store the values or use them as needed, for example:
                val club = Club(image, title, isVerified, membersOnline)
                clubsList.add(club)
            }
        }
    }
}


