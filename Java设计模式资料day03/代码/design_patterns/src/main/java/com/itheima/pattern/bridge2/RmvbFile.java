package com.itheima.pattern.bridge2;

public class RmvbFile implements VideoFile{

    @Override
    public void decode(String fileName) {
        System.out.println("Rmvb视频文件：" + fileName);
    }
}
