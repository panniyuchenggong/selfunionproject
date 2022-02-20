package com.znrh.project.selfunionproject.miniApplication;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.znrh.project.selfunionproject.utils.ZnrhFileUtils;
import org.springframework.util.ObjectUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rwh
 * @create 2022-02-10 14:22
 * @desc 解析pass平台相关性分析结果，并输出到csv中
 *       todo：将列名转换为汉字描述
 */
public class PassParseSpearmanResult {

    private static String taskName = "能源数据";

    public static void main(String[] args) {
        //相关性分析结果文件
        parseResult("D:\\linshi\\pass\\energyResultData.json", "energyResultData");

    }

    public static void parseResult(String filePath, String fileName){
        try {
            BufferedReader fileBr = new BufferedReader(new FileReader(filePath));
            String lineContent = fileBr.readLine();
            List<String> resultList  = new ArrayList<String>();
            File resultFile = new File(filePath.replace("json","csv"));
            if (!resultFile.exists()){
                resultFile.createNewFile();
            }
            if(!ObjectUtils.isEmpty(lineContent)){
                JSONArray jsonArray = JSON.parseArray(lineContent);
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                String point_set = jsonObject.getString("point_set");
                JSONObject resultInfo = jsonObject.getJSONObject("v");
                resultList.add( taskName + ","+ point_set);
                if(!ObjectUtils.isEmpty(point_set)){
                    String[] fieldNameArr = point_set.split(",");
                    if (resultInfo != null) {
                        Integer numRows = resultInfo.getInteger("numRows");
                        JSONArray resultDataArr = resultInfo.getJSONArray("values");
                        int count = 0;
                        String tmpStr = point_set.split(",")[count];//临时保存新的一行
                        for (int i = 0; i < resultDataArr.size(); i++) {
                            if( i%numRows == 0 && i!=0){
                                resultList.add(tmpStr);
                                count++;
                                tmpStr = point_set.split(",")[count];
                            }
                            if(i==resultDataArr.size()-1){
                                resultList.add(tmpStr);
                            }
                            tmpStr += ","+resultDataArr.getString(i);
                        }
                    }
                }
                ZnrhFileUtils.writeContentToLocal(resultList,resultFile);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
