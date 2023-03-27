package com.rahu.springjwt.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.rahu.springjwt.dto.DtoResponse;
import com.rahu.springjwt.dto.DtoResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException {
        DtoResponse responseDto = DtoResponse.builder()
                .status("failed")
                .message("authentication_failed")
                .build();
        response.setContentType("text/x-json;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        OutputStream out = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, responseDto);
        out.flush();
    }
}
