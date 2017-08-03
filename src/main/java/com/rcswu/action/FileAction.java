package com.rcswu.action;

import com.rcswu.domain.User;
import com.rcswu.service.UserService;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

@SuppressWarnings("serial")
public class FileAction extends MyBaseAction {
    private UserService userService;
    private File file;
    private String fileFileName;
    private String fileFileContentType;
    private String filePath;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileFileContentType() {
        return fileFileContentType;
    }

    public void setFileFileContentType(String fileFileContentType) {
        this.fileFileContentType = fileFileContentType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String uploadImg(){
        if(uploadFile("upload/userImg")){
            User user=baseUser;
            user.setUserImg(filePath);
            userService.updateEntity(user);
            baseUser.setUserImg(filePath);
            setState("0");
            setMessage("上传成功！");
        }
        return "fileUpload";
    }

    public String uploadPicture(){
        if(uploadFile("upload/pictureData")){
            setState("0");
            setMessage("上传成功！");
        }
        return "fileUpload";
    }

    @SuppressWarnings("resource")
    public boolean uploadFile(String path){
        String p= ServletActionContext.getServletContext().getRealPath(path);
        File ff=new File(p);
        if(!ff.exists()){
            System.out.println(ff.mkdirs());
        }
        String[] fileSuffix=new String[]{".exe"};
        try {
            File f=this.getFile();
            for(int i=0;i<fileSuffix.length;i++){
                if(fileFileName.endsWith(fileSuffix[i])){
                    setState("2");
                    setMessage("格式不正确");
                    return false;
                }
            }
            fileFileName= UUID.randomUUID()+fileFileName.substring(fileFileName.lastIndexOf("."),fileFileName.length());
            FileInputStream inputStream=new FileInputStream(f);
            FileOutputStream outputStream=new FileOutputStream(p+"\\"+fileFileName);
            byte[] buf=new byte[1024];
            int length=0;
            while((length=inputStream.read(buf))!=-1){
                outputStream.write(buf,0,length);
            }
            inputStream.close();
            outputStream.close();
            filePath=path+"/"+fileFileName;
        } catch (Exception e) {
            e.printStackTrace();
            setState("2");
            setMessage("上传失败！");
            return false;
        }
        return true;
    }
    public String updateImg(){
        String userImg="blog/"+filePath;
        User user=baseUser;
        user.setUserImg(userImg);
        userService.updateEntity(user);
        baseUser.setUserImg(userImg);
        setState("0");
        setMessage("修改成功！");
        return "fileUpload";
    }
}
