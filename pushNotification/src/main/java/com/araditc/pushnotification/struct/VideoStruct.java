package com.araditc.pushnotification.struct;


import com.araditc.pushnotification.consts.MessageTypes;

public class VideoStruct extends MessageTemplate{
    private int id;
    private int duration;
    private int height;
    private int width;
    private FileStruct videoFile;
    private ImageStruct thumbnail;
    private String caption;

    public VideoStruct( ) {
        super(MessageTypes.VIDEO);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public FileStruct getVideoFile() {
        return videoFile;
    }

    public void setVideoFile(FileStruct videoFile) {
        this.videoFile = videoFile;
    }

    public ImageStruct getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ImageStruct thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
