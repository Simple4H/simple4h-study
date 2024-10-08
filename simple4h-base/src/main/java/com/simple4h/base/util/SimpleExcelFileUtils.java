package com.simple4h.base.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.DynaBean;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 单行头导入
 *
 * @author Simple4H
 */
@Slf4j
public class SimpleExcelFileUtils {

    private final static String ERROR_HEAD_FIELD_NAME = "errMsg";

    private final static String ROOT_PATH = System.getProperty("user.home");

    @SneakyThrows
    public static <T> ExcelResult parseExcelAndNoExportErrorReport(MultipartFile file, Class<T> clazz, Function<T,
            List<String>> rowCheckFunc, Consumer<List<T>> succCallFunc, Integer headerRow) {
        return parseExcel(file.getOriginalFilename(), file.getInputStream(), clazz, clazz, rowCheckFunc, succCallFunc
                , headerRow, false);
    }

    public static <T> ExcelResult parseExcelAndNoExportErrorReport(String originFilename, InputStream inputStream,
            Class<T> clazz, Function<T, List<String>> rowCheckFunc, Consumer<List<T>> succCallFunc, Integer headerRow) {
        return parseExcel(originFilename, inputStream, clazz, clazz, rowCheckFunc, succCallFunc, headerRow, false);
    }

    public static <T, OUT> ExcelResult parseExcel(String originFilename, InputStream inputStream,
            Class<T> importClazz, Class<OUT> exportClazz,
            Function<T, List<String>> rowCheckFunc, Consumer<List<T>> succCallFunc, Integer headerRow,
            boolean createErrorReport) {
        final int[] rows = {0};
        final int[] errRows = {0};
        final String[] fileName = new String[1];
        EasyExcel.read(inputStream, importClazz, new AnalysisEventListener<T>() {
                    private String sheetName;

                    List<OUT> errDatas = cn.hutool.core.collection.ListUtil.toList();

                    List<T> succDatas = ListUtil.toList();

                    @Override
                    public void onException(Exception exception, AnalysisContext context) throws Exception {
                        ExceptionUtil.stacktraceToString(exception);
                        throw new RuntimeException("文件导入失败");
                    }

                    @Override
                    public void invoke(T t, AnalysisContext analysisContext) {
                        rows[0]++;
                        List<String> errors = rowCheckFunc.apply(t);
                        if (CollectionUtils.isEmpty(errors)) {
                            succDatas.add(t);
                        } else {
                            OUT exportObj = BeanUtil.copyProperties(t, exportClazz);
                            ;
                            //增加错误信息头
                            DynaBean bean = DynaBean.create(exportObj);
                            if (bean.containsProp(ERROR_HEAD_FIELD_NAME)) {
                                bean.set(ERROR_HEAD_FIELD_NAME, String.join("\r\n", errors));
                            }
                            errDatas.add(bean.getBean());
                            errRows[0]++;
                        }
                    }

                    @Override
                    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                        if (errRows[0] > 0) {
                            if (createErrorReport) {
                                //写错误报告
                                String fileNameStr = originFilename.substring(0, originFilename.lastIndexOf("."));
                                String errFileUrl = fileNameStr + "errFileUrl";
                                fileName[0] = errFileUrl;
                                exportErr(errFileUrl, sheetName, exportClazz, errDatas);
                            } else {
                                DynaBean bean = DynaBean.create(errDatas.get(0));
                                if (bean.containsProp(ERROR_HEAD_FIELD_NAME)) {
                                    Object errMsg = bean.get(ERROR_HEAD_FIELD_NAME);
                                    throw new RuntimeException(StrUtil.format("导入失败，请检查数据输入是否正确：{}", errMsg));
                                }
                                throw new RuntimeException("导入失败，请检查数据输入是否正确");
                            }
                        }
                        succCallFunc.accept(succDatas);
                    }
                })
                .autoCloseStream(true).ignoreEmptyRow(true).headRowNumber(headerRow).sheet().doRead();

        return new ExcelResult(rows[0], errRows[0], fileName[0]);
    }

    /**
     * 导出错误报告
     *
     * @param errFileUrl 保存地址
     * @param sheetName sheet名称
     * @param clazz 类
     * @param list 数据列表
     * @param <OUT>
     */
    @SneakyThrows
    public static <OUT> void exportErr(String errFileUrl, String sheetName, Class<OUT> clazz, List<OUT> list) {
        String dir = ROOT_PATH.concat("/").concat(errFileUrl.substring(0, errFileUrl.lastIndexOf("/")));
        File file = new File(dir);
        if (!file.exists()) {
            file.mkdirs();
        }
        String localFilePath = ROOT_PATH.concat("/").concat(errFileUrl);
        EasyExcel.write(localFilePath, clazz).sheet(sheetName).registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).doWrite(list);
        try {
            // TODO: upload
            new File(localFilePath).delete();
        } catch (Exception e) {
            log.error("导出工具导出错误报告异常：", e);
        }
    }

    @Data
    @ToString
    public static class ExcelResult {

        private int rows;

        private int errRows;

        private int succRows;

        private String fileName;

        public ExcelResult(int rows, int errRows, String fileName) {
            this.rows = rows;
            this.errRows = errRows;
            this.succRows = this.rows - this.errRows;
            this.fileName = fileName;
        }

    }

}
