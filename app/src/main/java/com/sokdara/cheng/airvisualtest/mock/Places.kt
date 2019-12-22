package com.sokdara.cheng.airvisualtest.mock

class Places {
    data class Place(
        val expandable: Boolean,
        val forecast: List<Forecast>,
        val location: String,
        val name: String,
        val status: String,
        val temperature: String,
        val time: String
    )

    data class Forecast(
        val date: String,
        val max: String,
        val min: String
    )

    companion object {
        val MOCK_PLACES = arrayListOf(
            Place(
                expandable = true,
                forecast = arrayListOf(Forecast(date = "Sat", min = "33\u00B0", max = "26\u00B0"),
                    Forecast(date = "Sun", min = "32\u00B0", max = "23\u00B0"),
                    Forecast(date = "Mon", min = "32\u00B0", max = "23\u00B0")),
                location = "Phnom Penh, Cambodia",
                name = "Olympic Stadium",
                status = "Unhealthy",
                temperature = "29\u00B0",
                time = "11:00"
            ),
            Place(
                expandable = false,
                forecast = arrayListOf(Forecast(date = "Sat", min = "33\u00B0", max = "26\u00B0"),
                    Forecast(date = "Sun", min = "32\u00B0", max = "23\u00B0"),
                    Forecast(date = "Mon", min = "32\u00B0", max = "23\u00B0")),
                location = "Phnom Penh, Cambodia",
                name = "Phnom Penh",
                status = "Unhealthy",
                temperature = "29\u00B0",
                time = "11:00"
            )
        )
    }
}