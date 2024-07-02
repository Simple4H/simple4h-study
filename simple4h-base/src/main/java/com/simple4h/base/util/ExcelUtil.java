package com.simple4h.base.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.simple4h.base.config.ExcelListener;
import jakarta.servlet.http.HttpServletResponse;
import lombok.experimental.UtilityClass;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Excel工具类
 *
 * @author Simple4H
 */
@UtilityClass
public class ExcelUtil {

    /**
     * 将Excel文件转成List
     *
     * @param file              Excel文件
     * @param correctHeaderList 正确的表头
     * @return List<Map < Integer, String>>
     */
    public List<Map<Integer, String>> list2ExcelWriter(MultipartFile file, List<String> correctHeaderList) {

        ExcelListener readListener = new ExcelListener();
        try {
            EasyExcel.read(file.getInputStream(), readListener).sheet().doRead();
        } catch (IOException e) {
            throw new RuntimeException("读取Excel数据异常");
        }
        readListener.checkHeader(correctHeaderList);
        return readListener.getExcelDataList();

    }

    /**
     * 将List转成Excel文件
     *
     * @param response 响应
     * @param list     数据
     * @param clazz    类
     * @param <T>      泛型
     */
    public <T> void list2ExcelWriter(HttpServletResponse response, List<T> list, Class<T> clazz) {

        try {
            ExcelWriter build = EasyExcel.write(response.getOutputStream(), clazz).excelType(ExcelTypeEnum.XLSX).build();
            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            build.write(list, writeSheet);
            build.finish();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 将List转成Excel文件
     *
     * @param list     List
     * @param clazz    Class
     * @param fileName 文件名
     * @param <T>      泛型
     * @return File
     */
    public <T> File list2Excel(List<T> list, Class<T> clazz, String fileName) {

        File newExcelFile = FileUtils.createNewExcelFile(fileName);

        ExcelWriter writer = EasyExcel.write(newExcelFile, clazz).excelType(ExcelTypeEnum.XLSX).build();
        WriteSheet writeSheet = EasyExcel.writerSheet().build();

        writer.write(list, writeSheet);
        writer.finish();
        return newExcelFile;
    }


}
