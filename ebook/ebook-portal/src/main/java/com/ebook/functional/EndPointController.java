package com.ebook.functional;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2020-05-19 00:15
 */
@Controller
public class EndPointController {

    @Bean
    public RouterFunction<ServerResponse> fooFunction() {
        return RouterFunctions.route()
                .GET("/func/user-info/foo", this::handleResponse)
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> predicateFunction() {
        return RouterFunctions.route()
                .GET("/func/user-info/foo",
                        request -> request.param("plan").isPresent(),
                        this::handleResponse)
                .build();
    }

    private ServerResponse handleResponse(ServerRequest request) {
        return ServerResponse.ok().body("body test");
    }
}
