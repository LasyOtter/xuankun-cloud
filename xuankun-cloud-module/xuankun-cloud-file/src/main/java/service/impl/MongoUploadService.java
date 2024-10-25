package service.impl;

import cn.hutool.core.io.IoUtil;
import code.FileUploadTypeEnum;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.xuankun.framework.common.exception.DataNotExistException;
import entity.UpdateFileInfo;
import entity.UploadFileContext;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import service.UploadService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Optional;

/**
* mongo方式存储文件
* @author xxm
* @date 2022/1/12
*/
@Slf4j
@Service
@RequiredArgsConstructor
public class MongoUploadService implements UploadService {
    private final GridFsTemplate gridFsTemplate;

    @Override
    public boolean enable(FileUploadTypeEnum type) {
        return type == FileUploadTypeEnum.MONGO;
    }

    /**
     * 上传
     */
    @SneakyThrows
    @Override
    public UpdateFileInfo upload(MultipartFile file, UploadFileContext context) {
        ObjectId store = gridFsTemplate.store(file.getInputStream(), context.getFileName(), file.getContentType());
        return new UpdateFileInfo()
                .setExternalStorageId(store.toString())
                .setFileSize(file.getSize());
    }

    @SneakyThrows
    @Override
    public void preview(UpdateFileInfo updateFileInfo, HttpServletResponse response) {
        Criteria criteria = Criteria.where("_id").is(updateFileInfo.getExternalStorageId());
        Query query = new Query(criteria);

        GridFSFile gridFSFile = Optional.ofNullable(gridFsTemplate.findOne(query))
                .orElseThrow(DataNotExistException::new);
        GridFsResource resource = gridFsTemplate.getResource(gridFSFile);
        InputStream inputStream = resource.getInputStream();

        //获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        IoUtil.copy(inputStream, os);
        response.addHeader(HttpHeaders.CONTENT_DISPOSITION, updateFileInfo.getFileType());
        IoUtil.close(inputStream);
        IoUtil.close(os);
    }

    @SneakyThrows
    @Override
    public InputStream download(UpdateFileInfo updateFileInfo) {
        Criteria criteria = Criteria.where("_id").is(new ObjectId(updateFileInfo.getExternalStorageId()));
        Query query = new Query(criteria);

        GridFSFile gridFSFile = Optional.ofNullable(gridFsTemplate.findOne(query))
                .orElseThrow(DataNotExistException::new);
        GridFsResource resource = gridFsTemplate.getResource(gridFSFile);
        return  resource.getInputStream();
    }
}
