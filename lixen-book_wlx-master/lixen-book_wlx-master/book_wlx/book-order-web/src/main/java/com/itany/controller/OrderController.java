package com.itany.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.itany.conf.MyWebSocket;
import com.itany.pojo.Order;
import com.itany.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Author:wenlixu
 * Date:2019/4/16 21:45
 * Description:
 * Version:1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Reference
    private OrderService orderService;


    @RequestMapping("/createImg")
    public void createImg(Order order, HttpServletResponse response)throws Exception{
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires",0);
        response.setContentType("image/jpeg");
        order.setNo(new Date().getTime()+"");
        order.setInfo("哈哈哈");
        order.setPrice(1000D);
        String code = orderService.getQrCode(order);

        Map<EncodeHintType,Object> hits = new HashMap<>();
        hits.put(EncodeHintType.CHARACTER_SET,"UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter()
                .encode(code, BarcodeFormat.QR_CODE,200,200,hits);
        MatrixToImageWriter.writeToStream(bitMatrix,"jpeg",response.getOutputStream());
        response.getOutputStream().flush();
        response.getOutputStream().close();

    }

    @RequestMapping("/paySuccess/{userId}/{no}")
    @ResponseBody
    public String paySuccess(@PathVariable("userId") Integer userId, @PathVariable("no") String no)throws Exception{
        System.out.println("----------------paySuccess-------------------");
        CopyOnWriteArraySet<MyWebSocket> webSockets
                = MyWebSocket.webSockets;

        for(MyWebSocket cfg:webSockets){
            if(cfg.getUserId().equals("1")){
                cfg.getSession().getBasicRemote().sendText("1");
            }
        }
        return "success";
    }

}
