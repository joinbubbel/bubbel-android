package com.example.bubbel.repository

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.bubbel.R
import com.example.bubbel.model.Club
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.ByteArrayOutputStream
import java.io.IOException

class ClubRepository() {
    fun getClubsFromXml(context: Context): List<Club> {
        return parseXml(context)
    }

    fun parseXml(context: Context): List<Club> {
        val clubs = mutableListOf<Club>()

        val parserFactory: XmlPullParserFactory
        try {
            parserFactory = XmlPullParserFactory.newInstance()
            val parser = parserFactory.newPullParser()
            val inputStream = context.resources.openRawResource(R.raw.club_data) // Open the XML from res/xml/clubs.xml
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
                            parser.getAttributeValue(null, "membersOnline").toInt()
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
    fun loadJSONFromRaw(context: Context, resourceId: Int): String {
        val inputStream = context.resources.openRawResource(resourceId)
        val byteArrayOutputStream = ByteArrayOutputStream()

        try {
            var i = inputStream.read()
            while (i != -1) {
                byteArrayOutputStream.write(i)
                i = inputStream.read()
            }
            inputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return byteArrayOutputStream.toString()
    }

}
