package com.znrh.project.selfunionproject.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author rwh
 * @create 2022-02-10 14:26
 * @desc 文件工具类
 */
public class ZnrhFileUtils {

    public static void writeContentToLocal(List<String> contentList, File file){
        System.out.println("contentList = " + contentList);
        System.out.println("hello git branch");
        System.out.println("hello git master branch");
        System.out.println("hello git hot-fix branch");
        System.out.println("push to github");
        System.out.println("pull from github");
        if(file!=null && file.exists()){
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                if (contentList != null && contentList.size()>0) {
                    for (int i = 0; i < contentList.size(); i++) {
                        bw.write(contentList.get(i));
                        bw.newLine();
                        bw.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
