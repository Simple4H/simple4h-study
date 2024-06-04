package com.simple4h.base.util;

import cn.hutool.core.io.FileUtil;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.nio.file.Paths;

/**
 * IOUtils
 *
 * @author Simple4H
 */
@UtilityClass
public class IOUtils {

    /**
     * 获取临时目录下的子目录
     *
     * @param sub 子目录
     * @return 子目录路径
     */
    public static String getTempSubPath(String sub) {
        String tmpdir = getTempPath();
        String subDirStr = Paths.get(tmpdir, sub).toString();
        File subDirFile = new File(subDirStr);
        FileUtil.mkdir(subDirFile);
        return subDirStr;
    }

    /**
     * 获取临时目录
     *
     * @return 临时目录
     */
    public static String getTempPath() {
        String tmpdir = System.getProperty("java.io.tmpdir");
        File tempDir = new File(tmpdir);
        if (tempDir.exists() && tempDir.isDirectory() && tempDir.canWrite()) {
            return tmpdir;
        } else {
            throw new RuntimeException("系统临时目录不存在或不可写");
        }
    }
}
