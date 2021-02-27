package com.example.codetest.utils

import android.util.Log
import com.example.codetest.model.DetailInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Utils {

    companion object {
        private val infoList =  ArrayList<DetailInfo>()
        /**
         * Read from json
         *
         * This function will simulate to get data from REST API or local database
         */
        fun readFromJson(): ArrayList<DetailInfo> {
            //infoList.clear()
            val myType = object : TypeToken<List<DetailInfo>>() {}.type
            infoList.addAll(Gson().fromJson<List<DetailInfo>>(jsonString, myType))
            Log.d("Utils", "Parser Json finish: ${infoList.size}")
            return infoList
        }

        /**
         * Save to json
         *
         * This function will simulate to update latest data via REST API or local database
         */
        fun saveToJson(id: String, detailInfo: DetailInfo?) {
            detailInfo?.let { info ->
                infoList.forEach {
                    if (id == it.id) {
                        it.email = detailInfo.email
                        it.firstName = detailInfo.firstName
                        it.lastName = detailInfo.lastName
                        it.phone = detailInfo.phone
                        Log.d("Utils", "Save Json finish")
                        return
                    }
                }
            } ?: run {
                Log.d("Utils", "Save Json Fail")
            }
        }

        fun getDetail(id: String): DetailInfo? {
            return infoList.filter { it.id == id }.first()
        }

        val jsonString = "[\n" +
                "  {\n" +
                "    \"id\": \"5c8a80f52dfee238898d64cf\",\n" +
                "    \"firstName\": \"Phoebe\",\n" +
                "    \"lastName\": \"Monroe\",\n" +
                "    \"email\": \"phoebemonroe@furnafix.com\",\n" +
                "    \"phone\": \"(903) 553-3410\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5c8a80f575270ddb54a18f86\",\n" +
                "    \"firstName\": \"Lidia\",\n" +
                "    \"lastName\": \"Wilkins\",\n" +
                "    \"email\": \"lidiawilkins@furnafix.com\",\n" +
                "    \"phone\": \"(997) 482-3866\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5c8a80f57a27f272ab4272f9\",\n" +
                "    \"firstName\": \"Gertrude\",\n" +
                "    \"lastName\": \"Mccormick\",\n" +
                "    \"email\": \"gertrudemccormick@furnafix.com\",\n" +
                "    \"phone\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5c8a80f5e2ad4c1edc5cc5d9\",\n" +
                "    \"firstName\": \"Maxine\",\n" +
                "    \"lastName\": \"Brady\",\n" +
                "    \"email\": \"maxinebrady@furnafix.com\",\n" +
                "    \"phone\": \"(919) 469-2468\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5c8a80f5437a24a66ac7e0c5\",\n" +
                "    \"firstName\": \"Willie\",\n" +
                "    \"lastName\": \"Gonzalez\",\n" +
                "\t\"email\": \"\",\n" +
                "    \"phone\": \"(892) 456-3603\"\n" +
                "\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5c8a80f5a7d3d251ba82df41\",\n" +
                "    \"firstName\": \"Oliver\",\n" +
                "    \"lastName\": \"Floyd\",\n" +
                "    \"email\": \"oliverfloyd@furnafix.com\",\n" +
                "    \"phone\": \"(953) 421-2772\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5c8a80f5d3c01af26b266b13\",\n" +
                "    \"firstName\": \"Elliott\",\n" +
                "    \"lastName\": \"Fry\",\n" +
                "    \"email\": \"elliottfry@furnafix.com\",\n" +
                "    \"phone\": \"(869) 557-2814\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5c8a80f597cdf9c2fc4f8466\",\n" +
                "    \"firstName\": \"Hancock\",\n" +
                "    \"lastName\": \"Foreman\",\n" +
                "\t\"email\": \"\",\n" +
                "    \"phone\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5c8a80f537cded38d718ecf5\",\n" +
                "    \"firstName\": \"Hood\",\n" +
                "    \"lastName\": \"Kline\",\n" +
                "    \"email\": \"hoodkline@furnafix.com\",\n" +
                "    \"phone\": \"(997) 596-2026\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5c8a80f531ed87bee8d951d6\",\n" +
                "    \"firstName\": \"Adams\",\n" +
                "    \"lastName\": \"Phelps\",\n" +
                "    \"email\": \"adamsphelps@furnafix.com\",\n" +
                "    \"phone\": \"(847) 570-2622\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5c8a80f537a8602ee2be6b6d\",\n" +
                "    \"firstName\": \"Ramos\",\n" +
                "    \"lastName\": \"Nieves\",\n" +
                "    \"email\": \"ramosnieves@furnafix.com\",\n" +
                "    \"phone\": \"(808) 550-3692\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5c8a80f57ba5cd82a37a039c\",\n" +
                "    \"firstName\": \"White\",\n" +
                "    \"lastName\": \"Marsh\",\n" +
                "    \"email\": \"whitemarsh@furnafix.com\",\n" +
                "    \"phone\": \"(943) 403-2609\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5c8a80f5d502bbf9f69e8b6d\",\n" +
                "    \"firstName\": \"Concepcion\",\n" +
                "    \"lastName\": \"Crane\",\n" +
                "    \"email\": \"concepcioncrane@furnafix.com\",\n" +
                "    \"phone\": \"(992) 499-2570\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5c8a80f5000661cb7e325e17\",\n" +
                "    \"firstName\": \"Rhonda\",\n" +
                "    \"lastName\": \"Mckinney\",\n" +
                "    \"email\": \"rhondamckinney@furnafix.com\",\n" +
                "    \"phone\": \"(887) 477-3521\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5c8a80f59283e24a4e526335\",\n" +
                "    \"firstName\": \"Hilda\",\n" +
                "    \"lastName\": \"Holder\",\n" +
                "\t\"email\": \"\",\n" +
                "    \"phone\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5c8a80f52aec26a5edc4e17c\",\n" +
                "    \"firstName\": \"Burks\",\n" +
                "    \"lastName\": \"Aguilar\",\n" +
                "    \"email\": \"burksaguilar@furnafix.com\",\n" +
                "    \"phone\": \"(847) 431-2033\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5c8a80f5b3a1e477360db964\",\n" +
                "    \"firstName\": \"Lorene\",\n" +
                "    \"lastName\": \"Stewart\",\n" +
                "    \"email\": \"lorenestewart@furnafix.com\",\n" +
                "    \"phone\": \"(895) 440-2387\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5c8a80f57dab375acf5030c1\",\n" +
                "    \"firstName\": \"Susana\",\n" +
                "    \"lastName\": \"Short\",\n" +
                "    \"email\": \"susanashort@furnafix.com\",\n" +
                "    \"phone\": \"(831) 501-3483\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5c8a80f523e488dd917a6e45\",\n" +
                "    \"firstName\": \"Lawson\",\n" +
                "    \"lastName\": \"French\",\n" +
                "    \"email\": \"lawsonfrench@furnafix.com\",\n" +
                "    \"phone\": \"(860) 430-3555\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5c8a80f5e3d1f2f2967c4621\",\n" +
                "    \"firstName\": \"Paula\",\n" +
                "    \"lastName\": \"Turner\",\n" +
                "    \"email\": \"paulaturner@furnafix.com\",\n" +
                "    \"phone\": \"(873) 553-3808\"\n" +
                "  }\n" +
                "]"
    }

}