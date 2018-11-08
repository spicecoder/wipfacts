package io.pronab.wipfacts.domain

import java.io.Serializable

/**
 * Created by pronab
 *
model representing json structure
{
"title":"About Canada",
"rows":[
	{
	"title":"Beavers",
	"description":"Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony",
	"imageHref":"http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg"
	}]
	}
*/


class Facts   {

    var title: String = ""
    lateinit var rows  : ArrayList<RowData>

    }

     class RowData : Serializable {

        var title: String? = null

        var description: String? = null

        var imageHref: String? = null


    }


