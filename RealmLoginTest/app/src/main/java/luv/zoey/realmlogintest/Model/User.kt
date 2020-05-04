package luv.zoey.realmlogintest.Model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class User (
    @PrimaryKey
    var Id : String? = null,
    var Pw : String? = null,
    var Email : String? =null,
    var phoneNum : String?=null
):RealmObject()