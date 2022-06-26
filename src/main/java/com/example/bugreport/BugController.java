package com.example.bugreport;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.nio.charset.StandardCharsets;

@Controller
public class BugController {

    @GetMapping(value = "/secured", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<StreamingResponseBody> securedAction() throws InterruptedException {
        Thread.sleep(200);
        StreamingResponseBody body = outputStream -> {
            outputStream.write("secured".getBytes(StandardCharsets.UTF_8));
        };
        return ResponseEntity.ok()
                .body(body);
    }

    @GetMapping(value = "/public", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<StreamingResponseBody> publicAction() throws InterruptedException {
        Thread.sleep(200);
        StreamingResponseBody body = outputStream -> {
            outputStream.write("public".getBytes(StandardCharsets.UTF_8));
        };
        return ResponseEntity.ok()
                .body(body);
    }

}
