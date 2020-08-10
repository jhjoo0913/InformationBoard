package com.kepco.informationboard.ConstructionMenu;

/**
 * Created by keplor@naver.com on 2020-08-09
 * Github : http//github.com/EulerCauchyEquation
 */
public class ConstructionFile {
    private int image;
    private String fileName;

    public ConstructionFile(int image, String fileName) {
        this.image = image;
        this.fileName = fileName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
