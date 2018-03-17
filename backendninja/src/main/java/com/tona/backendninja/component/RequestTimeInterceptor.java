package com.tona.backendninja.component;

import com.tona.backendninja.repository.LogRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author tona created on 10/03/2018 for backendninja.
 */
@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter{
    private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

    @Autowired
    @Qualifier("logRepository")
    private LogRepository logRepository;

    // Antes de entrar en el metodo del controlador
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) {
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    // Antes de devolver la vista al navegador
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) {
        long startTime = (long) request.getAttribute("startTime");
        String url = request.getRequestURL().toString();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = "";
        if (auth != null && auth.isAuthenticated())
            username = auth.getName();

        logRepository.save(new com.tona.backendninja.entity.Log(new Date(),
                auth.getDetails().toString(), username, url));

        LOG.info("URL to: '" + url + "' in: '" + (System.currentTimeMillis() - startTime) + "ms'");
    }
}
