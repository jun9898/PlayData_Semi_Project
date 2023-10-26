package com.example.project.service;

import com.example.project.dto.response.write.BoardWriteFileDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BoardWriteFileUploadService {

    @Value("${file.dir}")
    private String uploadpath;
    //파일명을 전달받아서 경로와 연결해서 리턴

    public String getUploadpath(String filename) {
        return uploadpath+filename;
    }


    public List<BoardWriteFileDTO> uploadFiles(List<MultipartFile> multipartFiles) throws IllegalStateException, IOException {
        List<BoardWriteFileDTO> filedtolist = new ArrayList<BoardWriteFileDTO>();
        int count=1;
        for(MultipartFile file:multipartFiles) {
            if(!file.isEmpty()) {
                //클라이언트가 업로드한 파일명
                String originalFilename= file.getOriginalFilename();
                //서버에서 식별할 수 있도록 파일명을 변경
                String storeFilename = createStoreFilename(originalFilename);
                System.out.println(originalFilename+"."+storeFilename);
                //file객체를 실제 경로에 저장
                file.transferTo(new File(uploadpath+File.separator+storeFilename));
                filedtolist.add(new BoardWriteFileDTO(originalFilename, storeFilename,count+""));
                count++;
            }
        }
        return filedtolist;
    }
    private static String createStoreFilename(String originalFilename) {
        int position = originalFilename.lastIndexOf(".");
        String ext = originalFilename.substring(position+1);
        String uuid = UUID.randomUUID().toString();
        return uuid+"."+ext;
    }


}
