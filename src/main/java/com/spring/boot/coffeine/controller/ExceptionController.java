package com.spring.boot.coffeine.controller;

import com.spring.boot.coffeine.constant.ErrorCode;
import com.spring.boot.coffeine.exception.CoffeineException;
import com.spring.boot.coffeine.utils.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hainguyen on 4/18/17.
 * Handle 404, 403, 500
 */
@Controller
public class ExceptionController implements ErrorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

    private static final String PATH = "/error";

    @GetMapping(path = "/403")
    public String getPageForbidding(Model model) {
        return "pages/error/403";
    }

    @GetMapping(path = "/404")
    public String getPageNotFound(Model model) {
        return "pages/error/404";
    }
    @GetMapping(path = "/500")
    public String getPageSystemError(Model model) {
        return "pages/error/500";
    }

    @GetMapping(path = "/detail")
    public String getPageError(Model model) {
        return "pages/error";
    }



    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle(Exception ex) {
        return "forward:/page-not-found-screen.html";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String renderErrorPage(Model model, HttpServletRequest httpRequest) {
        int httpErrorCode = getErrorCode(httpRequest);
        Throwable throwable = (Throwable) httpRequest.getAttribute("javax.servlet.error.throwable");
        String msg = "";
        int errorCode = ErrorCode.SYSTEM_ERROR.getCode();
        if(throwable!=null){
            Log.error(LOGGER,  throwable, "Exception");
            if(throwable instanceof CoffeineException){
                msg = throwable.getMessage();
                errorCode = ((CoffeineException) throwable).getError().getErrorCode();
            }
        }

        switch (httpErrorCode) {
            case 400: {
                return "redirect:/400";
            }
            case 401: {
                return "redirect:/401";
            }
            case 404: {
                return "pages/error/404";
            }
            case 405: {
                return "pages/error/500";
            }
            case 500: {
                return "pages/error/500";
            }
        }
        model.addAttribute("message", msg);
        model.addAttribute("errorCode", errorCode);
        return "pages/error/500";
    }
    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
    }
}
