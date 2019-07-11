package com.itany.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.itany.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Author:wenlixu
 * Date:2019/4/16 18:32
 * Description:
 * Version:1.0
 */
@Service
@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private AlipayClient alipayClient;


    @Override
    public String getQrCode(Order order) {

        String code ="";
        try {
            AlipayTradePrecreateRequest request =new AlipayTradePrecreateRequest();
            AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
            model.setOutTradeNo(order.getNo());
            model.setTotalAmount(order.getPrice().toString());
            model.setSubject(order.getInfo());
            request.setNotifyUrl("http://fc2a0a3e.ngrok.io/order/paySuccess/1/"+order.getNo());
            request.setBizModel(model);
            AlipayTradePrecreateResponse response = alipayClient.execute(request);
            if(response.isSuccess()){
                System.out.println("支付发起成功");
            }else{
                System.out.println("支付发起失败");
            }
            code = response.getQrCode();

        }catch (Exception e){
            e.printStackTrace();
        }
        return code;
    }

}
