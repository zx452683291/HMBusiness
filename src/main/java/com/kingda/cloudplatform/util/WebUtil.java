package com.kingda.cloudplatform.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Constanline
 * @description
 * @date 2019/10/21
 */
public class WebUtil {
    public static void renderJson(HttpServletResponse response, String text){
        renderJson(response, "utf-8", text);
    }

    public static void renderJson(HttpServletResponse response, String encoding, String text){
        render(response, "application/json", encoding, text);
    }

    public static void renderText(HttpServletResponse response, String text){
        renderText(response, "utf-8", text);
    }

    public static void renderText(HttpServletResponse response, String encoding, String text){
        render(response, "text/plain", encoding, text);
    }

    public static void render(HttpServletResponse response, String contentType, String encoding, String text){

        response.setContentType(contentType);
        response.setCharacterEncoding(encoding);
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        try {
            response.getWriter().write(text);
        } catch (IOException e) {
        }
    }
}
