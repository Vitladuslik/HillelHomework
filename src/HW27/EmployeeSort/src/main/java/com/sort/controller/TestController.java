package com.sort.controller;

import com.sort.entity.Employee;
import com.sort.service.impl.EmployeeServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private static final String CALL_ENDPOINT = "call endpoint : %s ";
    private static final EmployeeServiceImpl service = new EmployeeServiceImpl();


    @ApiOperation(value = "Upload and convert text file to string")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "File uploaded and converted successfully"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @PostMapping(value = "/uploadAndConvert", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadFileAndConvertToString(
            @ApiParam(value = "Text file to be uploaded and converted") @RequestParam("file") MultipartFile file) {

        String content = "";

        try {
            content = new String(file.getBytes());
            service.setRawFile(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(content);
    }

    @GetMapping("/ping")
    public String ping() {
        log.info(String.format(CALL_ENDPOINT, "ping"));
        return "work - OK";
    }


    @GetMapping("/sort")
    public String sort(Integer experience) {
//        informer.info("Running 'get(String cacheName, String key)' method");
        List<Employee> employeeList = service.getEmployeeList(service.getRawFile());
        List<Employee> employeeListSorted = service.sort( employeeList, experience);
        service.setSortedFile(employeeListSorted.toString());
        return employeeListSorted.toString();
    }

    @ApiOperation(value = "Convert string to file and download")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "File converted and downloaded successfully"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping(value = "/download")
    public ResponseEntity<byte[]> convertStringToFileAndDownload(){

        byte[] data = null;
        HttpHeaders headers = new HttpHeaders();

        try {
            // Convert string to byte array
            data = service.getSortedFile().getBytes("UTF-8");

            // Set content type and attachment header
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=result.txt");
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<byte[]>(data, headers, HttpStatus.OK);
    }

}
