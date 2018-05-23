package com.example.hotumit.monthlyincome.dao

import com.google.gson.annotations.SerializedName

data class CustItemDao(
    @SerializedName("cust_id") val custId: String,
    @SerializedName("cust_frst_name") val custFrstName: String,
    @SerializedName("cust_last_name") val custLastName: String,
    @SerializedName("cust_frst_name_en") val custFrstNameEn: String,
    @SerializedName("cust_last_name_en") val custLastNameEn: String,
    @SerializedName("cust_img_url") val custImgUrl: String,
    @SerializedName("cust_email") val custEmail: String,
    @SerializedName("cust_mobl_no") val custMoblNo: String,
    @SerializedName("cust_auth_id") val custAuthId: String,
    @SerializedName("cust_auth_type") val custAuthType: String,
    @SerializedName("cust_gend") val custGend: String,
    @SerializedName("cust_brth_dttm") val custBrthDttm: String,
    @SerializedName("cust_nation") val custNation: String,
    @SerializedName("cust_username") val custUsername: String,
    @SerializedName("cust_pswd") val custPswd: String,
    @SerializedName("cust_social_ntwk") val custSocialNtwk: String,
    @SerializedName("cust_stts") val custStts: String,
    @SerializedName("crtd_by") val crtdBy: String,
    @SerializedName("crtd_dttm") val crtdDttm: String,
    @SerializedName("updt_by") val updtBy: String,
    @SerializedName("updt_dttm") val updtDttm: String
)