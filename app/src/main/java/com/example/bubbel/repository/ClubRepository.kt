package com.example.bubbel.repository

import android.content.Context
import com.example.bubbel.R
import com.example.bubbel.model.Club
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException

class ClubRepository(private val context: Context) {

    fun getClubsFromXml(): List<Club> {
        return parseXml(context)
    }

    fun parseXml(context: Context): List<Club> {
        val clubs = mutableListOf<Club>()

        val parserFactory: XmlPullParserFactory
        try {
            parserFactory = XmlPullParserFactory.newInstance()
            val parser = parserFactory.newPullParser()
            val inputStream = context.resources.openRawResource(R.xml.club_data) // Open the XML from res/xml/clubs.xml
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
            parser.setInput(inputStream, null)

            var eventType = parser.eventType
            var currentClub: Club? = null

            while (eventType != XmlPullParser.END_DOCUMENT) {
                val eltName = parser.name

                when (eventType) {
                    XmlPullParser.START_TAG -> if (eltName == "club") {
                        currentClub = Club(
                            parser.getAttributeValue(null, "image"),
                            parser.getAttributeValue(null, "title"),
                            parser.getAttributeValue(null, "isVerified").toBoolean(),
                            parser.getAttributeValue(null, "membersOnline")
                        )
                        clubs.add(currentClub)
                    }
                }
                eventType = parser.next()
            }
        } catch (e: XmlPullParserException) {
            e.printStackTrace()
            println("cheese")
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return clubs
    }

}
