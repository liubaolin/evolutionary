package top.evolutionary.securitydemo.dto;

public class FileInfo {

    private String path;

    public FileInfo() {

    }

    public FileInfo(String path) {
        this.path = path;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
