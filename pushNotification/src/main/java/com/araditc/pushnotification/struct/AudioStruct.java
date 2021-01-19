package com.araditc.pushnotification.struct;

import com.araditc.pushnotification.consts.MessageTypes;

public class AudioStruct  extends MessageTemplate{
    private int id;
    private int duration;
    private String title;
    private FileStruct audioFile;
    private String caption;

    public AudioStruct() {
        super(MessageTypes.AUDIO);
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FileStruct getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(FileStruct audioFile) {
        this.audioFile = audioFile;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
