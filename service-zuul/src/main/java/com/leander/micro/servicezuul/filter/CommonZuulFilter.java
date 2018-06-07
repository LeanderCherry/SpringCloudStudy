package com.leander.micro.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Leander
 * @date 2018/6/7 1:53
 * @since [version]
 **/
@Component
public class CommonZuulFilter extends ZuulFilter
{
    private static final Logger logger = LoggerFactory.getLogger(CommonZuulFilter.class);

    @Override
    public String filterType()
    {
        return "pre";
    }

    @Override
    public int filterOrder()
    {
        return 0;
    }

    @Override
    public boolean shouldFilter()
    {
        return true;
    }

    @Override
    public Object run()
    {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if (accessToken == null)
        {
            logger.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try
            {
                ctx.getResponse().getWriter().write("token is empty");
            }
            catch (Exception e)
            {
                logger.error("Something is wrong, ", e);
            }

            return null;
        }
        logger.info("ok");
        return null;
    }
}
