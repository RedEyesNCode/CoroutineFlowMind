package com.redyesncode.coroutineflowmind.models

import com.google.gson.annotations.SerializedName

data class LoginResponse(@SerializedName("status"  ) var status  : String? = null,
                         @SerializedName("code"    ) var code    : Int?    = null,
                         @SerializedName("message" ) var message : String? = null,
                         @SerializedName("_token"  ) var Token   : String? = null,
                         @SerializedName("data"    ) var data    : Data?   = Data())
data class Data (

    @SerializedName("id"         ) var id         : Int?    = null,
    @SerializedName("userEmail"  ) var userEmail  : String? = null,
    @SerializedName("number"     ) var number     : String? = null,
    @SerializedName("password"   ) var password   : String? = null,
    @SerializedName("userName"   ) var userName   : String? = null,
    @SerializedName("profileUrl" ) var profileUrl : String? = null,
    @SerializedName("fcmToken"   ) var fcmToken   : String? = null,
    @SerializedName("createdAt"  ) var createdAt  : String? = null,
    @SerializedName("updatedAt"  ) var updatedAt  : String? = null

)