package com.itheima.pattern.bridge2;

public abstract class OS {
    
    protected VideoFile videoFile;

    public OS(VideoFile videoFile) {
        this.videoFile = videoFile;
    }
    
    public abstract void play(String fileName);
}
