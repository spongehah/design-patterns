package com.itheima.pattern.bridge2;

public class MacOS extends OS{

    public MacOS(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
