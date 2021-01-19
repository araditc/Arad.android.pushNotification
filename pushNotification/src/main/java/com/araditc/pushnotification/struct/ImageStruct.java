package com.araditc.pushnotification.struct;

import com.araditc.pushnotification.consts.MessageTypes;

public class ImageStruct extends MessageTemplate {
    private int id;
    private int fileId;
    private int width;
    private int height;
    private FileStruct imageFile;
    private String caption;

    public ImageStruct(int type) {
        super(MessageTypes.IMAGE);
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

    public FileStruct getImageFile() {
        return imageFile;
    }

    public void setImageFile(FileStruct imageFile) {
        this.imageFile = imageFile;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
