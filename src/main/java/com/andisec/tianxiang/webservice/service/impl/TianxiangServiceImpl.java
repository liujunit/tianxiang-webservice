package com.andisec.tianxiang.webservice.service.impl;

import com.andisec.tianxiang.webservice.service.TianxiangService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@WebService(name = "tianxiangService", targetNamespace = "http://server.webservice.andisec.com",
        endpointInterface = "com.andisec.tianxiang.webservice.service.TianxiangService")
@Slf4j
public class TianxiangServiceImpl implements TianxiangService {



    private String SUCCESS = "<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
            "<dataset>\n" +
            "<head>\n" +
            "<msg_id>1234567</msg_id>\n" +
            "<state_code>000</state_code>\n" +
            "<state_desc>数据接收成功</state_desc>\n" +
            "<client_type>CORP_SCAN</client_type>\n" +
            "<client_id>S11370501003</client_id>\n" +
            "<commerce_code>11370501</commerce_code>\n" +
            "<curr_time>2017-09-20 02:45:01</curr_time>\n" +
            "<curr_user>icss</curr_user>\n" +
            "</head>\n" +
            "</dataset>";

    private String FAILED = "<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
            "<dataset>\n" +
            "<head>\n" +
            "<msg_id>1234567</msg_id>\n" +
            "<state_code>001</state_code>\n" +
            "<state_desc>数据接收失败</state_desc>\n" +
            "<client_type>CORP_SCAN</client_type>\n" +
            "<client_id>S11370501003</client_id>\n" +
            "<commerce_code>11370501</commerce_code>\n" +
            "<curr_time>2017-09-20 02:45:01</curr_time>\n" +
            "<curr_user>icss</curr_user>\n" +
            "</head>\n" +
            "</dataset>";

//    private String path = "/opt/tianxiang-webservice/data/";

//    private String path2 = "F:\\安帝\\工作\\2022-私有云\\3月\\";

    @Override
    @WebResult(name = "xmlReturn")
    public String WMSBillService(@WebParam(name = "param") String param) {
        if(null == param || "".equals(param.trim())){
            return FAILED;
        }
        log.info("接收数据：{}", param);
//        //数据先进行文件存储
//        long timeMillis = System.currentTimeMillis();
//        Path fpath= Paths.get(path2.concat(String.valueOf(timeMillis)).concat(".xml"));
//        //创建文件
//        if(!Files.exists(fpath)) {
//            try {
//                Files.createFile(fpath);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        //创建BufferedWriter
//        try {
//            BufferedWriter bfw=Files.newBufferedWriter(fpath);
//            bfw.write(param);
//            bfw.flush();
//            bfw.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return SUCCESS;
    }

}
