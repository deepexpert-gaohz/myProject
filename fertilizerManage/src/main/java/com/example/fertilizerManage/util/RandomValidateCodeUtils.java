package com.example.fertilizerManage.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author hejk
 * @description: 验证码图片生成辅助类
 * @date 2019/4/1 16:36
 */

public class RandomValidateCodeUtils {

    private RandomValidateCodeUtils(){}

    /**
     * 图片宽
     */
    private static int WIDTH = 90;
    /**
     * 图片高
     */
    private static int HEIGHT = 34;
    /**
     * 干扰线数量
     */
    private static int LINE_SIZE = 20;

    /**
     * 最大颜色
     */
    private static int MAX_COLOR = 255;

    /**
     * 字体大小
     */
    private static int FONT_SIZE=30;


    private static final Logger logger = LoggerFactory.getLogger(RandomValidateCodeUtils.class);

    private static Random random = new Random();

    /**
     * 获得字体
     */
    private static Font getFont() {
        return new Font("Fixedsys", Font.CENTER_BASELINE, FONT_SIZE);
    }

    /**
     * 获得颜色
     */
    private static Color getRandColor(int fc, int bc) {
        if (fc > MAX_COLOR) {
            fc = MAX_COLOR;
        }
        if (bc > MAX_COLOR) {
            bc = MAX_COLOR;
        }
        int r = fc + random.nextInt(bc - fc - 16);
        int g = fc + random.nextInt(bc - fc - 14);
        int b = fc + random.nextInt(bc - fc - 18);
        return new Color(r, g, b);
    }

    /**
     * 生成随机图片
     */
    public static void getRandcode(HttpServletResponse response, String code) {

        //设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        //设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);

        // BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);
        // 产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
        Graphics g = image.getGraphics();
        //图片大小
        g.fillRect(0, 0, WIDTH, HEIGHT);
        //字体大小
        g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
        //字体颜色
        g.setColor(getRandColor(110, 133));
        // 绘制干扰线
        for (int i = 0; i <= LINE_SIZE; i++) {
            drowLine(g);
        }
        // 绘制随机字符
        String randomString = "";
        for (int i = 0; i < code.length(); i++) {
            randomString = drowString(g, randomString, code, i);
        }
        //关闭
        g.dispose();
        try {
            // 将内存中的图片通过流动形式输出到客户端
            ImageIO.write(image, "JPEG", response.getOutputStream());
        } catch (Exception e) {
            logger.error("将内存中的图片通过流动形式输出到客户端失败>>>>   ", e);
        }

    }

    /**
     * 绘制字符串
     */
    private static String drowString(Graphics g, String randomString, String code, int i) {

        g.setFont(getFont());
        g.setColor(new Color(random.nextInt(101), random.nextInt(111), random.nextInt(121)));

        randomString += code.charAt(i);
        g.translate(random.nextInt(3), random.nextInt(3));
        g.drawString(code.charAt(i) + "", 20 * i, 22);
        return randomString;
    }

    /**
     * 绘制干扰线
     */
    private static void drowLine(Graphics g) {

        int x = random.nextInt(WIDTH);
        int y = random.nextInt(HEIGHT);
        int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.drawLine(x, y, x + xl, y + yl);
    }


}
