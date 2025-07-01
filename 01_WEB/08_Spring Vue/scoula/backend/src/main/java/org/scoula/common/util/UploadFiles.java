package org.scoula.common.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class UploadFiles {
    public static String upload(String baseDir, MultipartFile part) throws IOException {
        File base = new File(baseDir);

        if (!base.exists()) {
            base.mkdirs();
        }

        String fileName = part.getOriginalFilename();
        File dest = new File(baseDir, UploadFileName.getUniqueName(fileName));
        part.transferTo(dest);

        return dest.getPath();
    }

    public static String getFormatSize(Long size) {
        if (size <= 0) {
            return "0";
        }

        final String[] units = new String[]{"Bytes", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));

        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

    public static void download(HttpServletResponse response, File file, String orgName) throws Exception {
        response.setContentType("application/download");
        response.setContentLength((int) file.length());

        String filename = URLEncoder.encode(orgName, "UTF-8"); // 한글 파일명인 경우 인코딩 필수
        response.setHeader("Content-disposition", "attachment;filename=\"" + filename + "\"");
        try (OutputStream os = response.getOutputStream(); BufferedOutputStream bos = new BufferedOutputStream(os)) {
            Files.copy(Paths.get(file.getPath()), bos);
        }
    }

    public static void downloadImage(HttpServletResponse response, File file) {
        try {
            // 파일 경로를 Path 객체로 변환
            Path path = Path.of(file.getPath());
            // MIME 타입 추출 (image/png, image/jpeg 등)
            String mimeType = Files.probeContentType(path);
            // 응답 헤더 설정
            response.setContentType(mimeType);  // 콘텐츠 타입 설정
            response.setContentLength((int) file.length()); // 콘텐츠 파일 사이즈 설정

            try (OutputStream os = response.getOutputStream();
                 BufferedOutputStream bos = new BufferedOutputStream(os)) {
                Files.copy(path, bos);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
