package com.multiseafoods.msapp.authorization.intercetor;

import com.multiseafoods.msapp.authorization.annotation.Authorization;
import com.multiseafoods.msapp.authorization.manager.TokenManager;
import com.multiseafoods.msapp.authorization.model.TokenModel;
import com.multiseafoods.msapp.utils.Contents;
import com.multiseafoods.msapp.utils.JasyptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private TokenManager tokenManager;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();

        String authorization = request.getHeader(Contents.AUTHORIZATION);
        TokenModel model = null;
        try{
            model = tokenManager.getToken(JasyptUtil.decode(authorization));
        }catch(Exception e){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        if(tokenManager.checkToken((model))){
            request.setAttribute(Contents.CURRENT_USERNAME,model.getUsername());
            return true;

        }
        if(method.getAnnotation(Authorization.class) != null ){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        return true;
    }
}
