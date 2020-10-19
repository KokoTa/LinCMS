package io.github.talelin.latticy.controller.cms;

import io.github.talelin.latticy.bo.FileBO;
import io.github.talelin.latticy.module.file.FileUtil;
import io.github.talelin.latticy.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author pedro@TaleLin
 */
@RestController
@RequestMapping("/cms/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("")
//    @LoginRequired
    public List<FileBO> upload(HttpServletRequest request) {
        MultipartHttpServletRequest multipartHttpServletRequest = ((MultipartHttpServletRequest) request);
        MultiValueMap<String, MultipartFile> fileMap = multipartHttpServletRequest.getMultiFileMap();
        List<FileBO> files = fileService.upload(fileMap);
        return files;
    }

    @PostMapping("/test")
    public void upload2(HttpServletRequest request) {
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultiValueMap<String, MultipartFile> fileMap = multipartHttpServletRequest.getMultiFileMap();
        // 判断 Multipart 是否为空
        System.out.println(fileMap.isEmpty());

        // 获取文件数量
        System.out.println(fileMap.size());

        // 识别字符串为具体的大小，单位为比特
        String fileSizeLimit = "2MB";
        long byteLimit = DataSize.parse(fileSizeLimit).toBytes();
        System.out.println(byteLimit);

        // 获取键信息，然后根据键获取文件
        fileMap.keySet().forEach((key) -> {
            fileMap.get(key).forEach((file) -> {
                if (!file.isEmpty()) {
                    // 获取文件键值
                    System.out.println(file.getName());
                    // 获取单个文件大小
                    try {
                        byte[] bytes = file.getBytes();
                        // 对比文件大小
                        System.out.println(bytes.length <= byteLimit);
                        // 获取文件名
                        String filename = file.getOriginalFilename();
                        System.out.println(filename);
                        // 获取文件后缀名
                        String ext = FileUtil.getFileExt(filename);
                        System.out.println(ext);
                        // 获取随机文件名
                        String uuid = UUID.randomUUID().toString().replace("-", "");
                        System.out.println(uuid + ext);
                        // 创建本地目录
                        Date now = new Date();
                        String format = new SimpleDateFormat("yyyy/MM/dd").format(now);
                        Path path = Paths.get("assets", format).toAbsolutePath();
                        File file2 = new File(path.toString());
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        System.out.println(path);
                        // 获取文件的 md5 值
                        String md5 = FileUtil.getFileMD5(bytes);
                        System.out.println(md5);
                        // 判断路径是否是绝对路径
                        String filePath = Paths.get(path.toString(), uuid + ext).toString();
                        FileSystem fileSystem = FileSystems.getDefault();
                        System.out.println(filePath);
                        System.out.println(fileSystem.getPath(filePath).isAbsolute());
                        // 获取项目的绝对路径
                        String cmd = System.getProperty("user.dir");
                        System.out.println(cmd);
                        // 写入文件
                        BufferedOutputStream stream =
                                new BufferedOutputStream(new FileOutputStream(new File(filePath)));
                        stream.write(bytes);
                        stream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        });
    }

}
