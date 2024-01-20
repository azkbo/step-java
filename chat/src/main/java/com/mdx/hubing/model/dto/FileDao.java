package com.mdx.hubing.model.dto;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public class FileDao {
    public String name;
    public String filePath;
    public String url;
    public String code;

    public FileDao(String name, String filePath, String url, String code) {
        this.url = url;
        this.name = name;
        this.filePath = filePath;
        this.code = code;
    }
}
