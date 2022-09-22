package com.andisec.tianxiang.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "tianxiangService", targetNamespace = "http://server.webservice.andisec.com")
public interface TianxiangService {

    @WebMethod
    @WebResult(name = "xmlReturn")
    String WMSBillService(@WebParam(name = "param") String param);

}
