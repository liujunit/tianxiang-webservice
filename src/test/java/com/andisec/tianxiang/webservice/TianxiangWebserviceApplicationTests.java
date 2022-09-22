package com.andisec.tianxiang.webservice;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TianxiangWebserviceApplicationTests {

    @Test
    void contextLoads() {
        String url = "http://172.16.8.110:8099/lms/services?wsdl";
        String operationName = "WMSBillService";
        String param = "<user><id>10012334223</id><name>蒲公英不是梦</name><sex>1</sex></user>";
        String result = callWebService(url, operationName, param);
        System.out.println("result:" + result);
    }

    /**
     * 调用webservice服务
     * @param wsdUrl 服务地址
     * @param operationName 方法名称
     * @param params 参数
     * @return 服务响应结果
     */
    public String callWebService(String wsdUrl, String operationName, Object... params){
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(wsdUrl);
        try {
            Object[] objects = client.invoke(operationName, params);
            return objects[0].toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
