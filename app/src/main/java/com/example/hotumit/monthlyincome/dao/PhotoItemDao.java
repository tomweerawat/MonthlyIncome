package com.example.hotumit.monthlyincome.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by HOTUM IT on 12/1/2561.
 */

public class

PhotoItemDao implements Parcelable {

    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("link")
    private String link;

    @Expose
    @SerializedName("image_url")
    private String imageUrl;
   /* private List<String> imageUrl = new ArrayList<>();*/

    @Expose
    @SerializedName("caption")
    private String caption;

    @Expose
    @SerializedName("user_id")
    private int user_id;

    @Expose
    @SerializedName("username")
    private String username;

    @Expose
    @SerializedName("profile_picture")
    private String profilePicture;

    @Expose
    @SerializedName("tags")
    private List<String> tags = new ArrayList<>();

    @Expose
    @SerializedName("created_time")
    private String createdTime;

    @Expose
    @SerializedName("camera")
    private String camera;

    @Expose
    @SerializedName("lens")
    private String lens;

    @Expose
    @SerializedName("focal_length")
    private String focalLength;

    @Expose
    @SerializedName("iso")
    private String iso;

    @Expose
    @SerializedName("shutter_speed")
    private String shutterSpeed;

/*
    public List<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }
*/

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Expose
    @SerializedName("aperture")

    private String aperture;



    protected PhotoItemDao(Parcel in) {

        id = in.readInt();
        link = in.readString();
     /*   imageUrl = in.createStringArrayList();*/
        imageUrl = in.readString();
        caption = in.readString();
        user_id = in.readInt();
        username = in.readString();
        profilePicture = in.readString();
        tags = in.createStringArrayList();
        createdTime = in.readString();
        camera = in.readString();
        lens = in.readString();
        focalLength = in.readString();
        iso = in.readString();
        shutterSpeed = in.readString();
        aperture = in.readString();
    }

    public static final Creator<PhotoItemDao> CREATOR = new Creator<PhotoItemDao>() {
        @Override
        public PhotoItemDao createFromParcel(Parcel in) {
            return new PhotoItemDao(in);
        }

        @Override
        public PhotoItemDao[] newArray(int size) {
            return new PhotoItemDao[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }



    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getLens() {
        return lens;
    }

    public void setLens(String lens) {
        this.lens = lens;
    }

    public String getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(String focalLength) {
        this.focalLength = focalLength;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getShutterSpeed() {
        return shutterSpeed;
    }

    public void setShutterSpeed(String shutterSpeed) {
        this.shutterSpeed = shutterSpeed;
    }

    public String getAperture() {
        return aperture;
    }

    public void setAperture(String aperture) {
        this.aperture = aperture;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(link);
   /*     dest.writeStringList(imageUrl);*/
        dest.writeString(imageUrl);
        dest.writeString(caption);
        dest.writeInt(user_id);
        dest.writeString(username);
        dest.writeString(profilePicture);
        dest.writeStringList(tags);
        dest.writeString(createdTime);
        dest.writeString(camera);
        dest.writeString(lens);
        dest.writeString(focalLength);
        dest.writeString(iso);
        dest.writeString(shutterSpeed);
        dest.writeString(aperture);
    }
}
