package com.jason.springbootweb.controller.Login;

import com.jason.springbootweb.tool.HttpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

@RestController
@RequestMapping("/login")
public class LoginController {


    @RequestMapping("/getPicutreCode")
    public Object getPictureCode() {
        return createPictureCode();
    }
    //随机生成图片验证码
    public Object createPictureCode() {
        int width = 80, height = 35; // 创建验证码图片的大小
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics(); // 创建Graphics对象,其作用相当于画笔
        Graphics2D g2d = (Graphics2D) g; // 创建Grapchics2D对象

        Random random = new Random();
        Font mfont = new Font("楷体", Font.BOLD, 30); // 定义字体样式
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height); // 绘制背景
        g.setFont(mfont); // 设置字体
        g.setColor(getRandColor(180, 200));
        // 100条颜色和位置全部为随机产生的线条
        for (int i = 0; i < 100; i++) {
            int x = random.nextInt(width - 1);
            int y = random.nextInt(height - 1);
            int x1 = random.nextInt(6) + 1;
            int y1 = random.nextInt(12) + 1;
            BasicStroke bs = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); // 定制线条样式
            Line2D line = new Line2D.Double(x, y, x + x1, y + y1);
            g2d.setStroke(bs);
            g2d.draw(line); // 绘制直线
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; ++i) {
            String sTemp = String.valueOf(randomChar());
            sb.append(sTemp);

            Color color = new Color(20 + random.nextInt(110), 20 + random.nextInt(110), random.nextInt(110));
            g.setColor(color);

            Graphics2D g2d_word = (Graphics2D) g;
            AffineTransform trans = new AffineTransform();
            trans.rotate(0, 15 * i + 8, 7);

            /* 缩放文字 */
            float scaleSize = random.nextFloat() + 0.8f;
            if (scaleSize > 1f)
                scaleSize = 1f;
            trans.scale(scaleSize, scaleSize);
            g2d_word.setTransform(trans);
            g.drawString(sTemp, 4+19*i,25);
        }
        HttpUtil.getSession().setAttribute("picutreCode",sb.toString());
        System.out.println("sRand="+sb.toString());
        g.dispose(); // 释放g所占用的系统资源
        ByteArrayOutputStream baos = new ByteArrayOutputStream();//io流
        try {
            ImageIO.write(image, "png", baos);//写入流中
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = baos.toByteArray();//转换成字节
        BASE64Encoder encoder = new BASE64Encoder();
        String png_base64 =  encoder.encodeBuffer(bytes).trim();//转换成base64串
        png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");//删除 \r\n
        return png_base64;
    }

    public static Color getRandColor(int s, int e) {
        Random random = new Random();
        if (s > 255)
            s = 255;
        if (e > 255)
            e = 255;
        int r, g, b;
        r = s + random.nextInt(e - s); // 随机生成RGB颜色中的r值
        g = s + random.nextInt(e - s); // 随机生成RGB颜色中的g值
        b = s + random.nextInt(e - s); // 随机生成RGB颜色中的b值
        return new Color(r, g, b);
    }


    private static String codes = "0123456789abcdefghijkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYXZ";
    private static char randomChar() {
        Random r =new Random();
        int index = r.nextInt(codes.length());
        return codes.charAt(index);
    }

}
