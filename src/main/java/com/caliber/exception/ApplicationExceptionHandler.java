//package com.caliber.exception;
//
//import com.caliber.caliber_app.email.ConnectEmail;
//import com.caliber.caliber_app.enums.EnviornmentType;
//import com.caliber.caliber_app.model.ErrorCode;
//import com.caliber.caliber_app.model.ErrorResponse;
//import org.apache.commons.lang3.exception.ExceptionUtils;
//import org.apache.logging.log4j.LogManager;
//
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.Profile;
//import org.springframework.dao.DataAccessException;
//import org.springframework.dao.DuplicateKeyException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.nio.file.AccessDeniedException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Profile("!" + EnviornmentType.C_TEST)
//@ControllerAdvice
//public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
//    private static final Logger log = LogManager.getLogger(ApplicationExceptionHandler.class);
//
//    @Autowired
//    protected ApplicationContext applicationContext;
//
//    @Value("${mail.exception.subject:Application Exception")
//    private String subject;
//
//    @Value("${mail.exception.fromAddress:suryaravuri9@gmail.com")
//    private String fromAddress;
//    @Value("${mail.exception.toAddress:suryaravuri9@gmail.com")
//    private String toAddress;
//
//    @Value("${mail.exception.enabled:false")
//    private Boolean mailExceptionEnabled;
//
//    private ConnectEmail connectEmail;
//
//    @ExceptionHandler(value = {DataAccessException.class})
//    protected ResponseEntity<ErrorResponse> handleDAOException(final Exception ex, final WebRequest request) {
//        ErrorResponse errorResponse = new com.caliber.caliber_app.model.ErrorResponse(
//                "Data Error",
//                ErrorCode.DATA_ERR,
//                HttpStatus.INTERNAL_SERVER_ERROR,
//                "",
//                null
//        );
//
//
//        log.error("DataBase Operation failed", ex);
//        emailException(ex);
//        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//
//    }
//
//    @ExceptionHandler(value = {DuplicateKeyException.class})
//    protected ResponseEntity<ErrorResponse> handleDupException(final RuntimeException ex, final WebRequest request) {
//        ErrorResponse errorResponse = new com.caliber.caliber_app.model.ErrorResponse(
//                "Entry Already Exists",
//                ErrorCode.DUP_DATA_ERR,
//                HttpStatus.INTERNAL_SERVER_ERROR,
//                "",
//                null
//        );
//        log.error("Entry Already Exists", ex);
//        emailException(ex);
//        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(value = {ServiceException.class})
//    protected ResponseEntity<ErrorResponse> handleServiceException(final RuntimeException ex, final WebRequest request) {
//        ErrorResponse errorResponse = new com.caliber.caliber_app.model.ErrorResponse(
//                "Server Error",
//                ErrorCode.GLOBAL,
//                HttpStatus.INTERNAL_SERVER_ERROR,
//                ex.getMessage(),
//                null
//        );
//        log.error("Server Error", ex);
//        emailException(ex);
//        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//    @ExceptionHandler(value = {UserException.class})
//    protected ResponseEntity<ErrorResponse> handleUserException(final RuntimeException ex, final WebRequest request) {
//        ErrorResponse errorResponse = new com.caliber.caliber_app.model.ErrorResponse(
//                "User Error",
//                ErrorCode.USER_ERR,
//                HttpStatus.INTERNAL_SERVER_ERROR,
//                ex.getMessage(),
//                null
//        );
//        log.error("User Error", ex);
//        emailException(ex);
//        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//    @ExceptionHandler(value = {AccessDeniedException.class})
//    protected ResponseEntity<ErrorResponse> handleAccessDeniedException(final RuntimeException ex, final WebRequest request) {
//        ErrorResponse errorResponse = new com.caliber.caliber_app.model.ErrorResponse(
//                "Unauthorized Access Error",
//                ErrorCode.AUTH_ROLE_ERR,
//                HttpStatus.FORBIDDEN,
//                "",
//                null
//        );
//        log.error("Unauthorized Access Error", ex);
//        emailException(ex);
//        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
//    }
//    @ExceptionHandler(value = {ValidationException.class})
//    protected ResponseEntity<ErrorResponse> handleValidationException(final RuntimeException ex, final WebRequest request) {
//        ErrorResponse errorResponse = new com.caliber.caliber_app.model.ErrorResponse(
//                "Validation Error",
//                ErrorCode.VALIDATION_ERR,
//                HttpStatus.PRECONDITION_FAILED,
//                "",
//                null
//        );
//        log.error("Validation Error", ex);
//        emailException(ex);
//        return new ResponseEntity<>(errorResponse, HttpStatus.PRECONDITION_FAILED);
//    }
//    @ExceptionHandler(value = {Throwable.class, Exception.class})
//    protected ResponseEntity<ErrorResponse> handleException(final RuntimeException ex, final WebRequest request) {
//        ErrorResponse errorResponse = new com.caliber.caliber_app.model.ErrorResponse(
//          "Server failed due to some unexpected problem. Please contact application owner",
//          ErrorCode.SERV_ERR,
//          HttpStatus.SERVICE_UNAVAILABLE,
//          null,
//          null
//        );
//        log.error("Server failed due to some unexpected problem.", ex);
//        emailException(ex);
//        return new ResponseEntity<>(errorResponse, HttpStatus.SERVICE_UNAVAILABLE);
//    }
//
//    public void emailException(final Throwable ex) {
//        if( mailExceptionEnabled ) {
//            if( connectEmail == null ) {
//                connectEmail = (ConnectEmail) applicationContext.getBean("connectEmail");
//
//            }
//            String message = "<br><h1><b><font color='red'>Application Exception Occurred: </font></b></h1></br>"
//                    + "<br><b>Exception: </b>"
//                    + ExceptionUtils.getStackTrace(ex)
//                    + "<br><br><br>"
//                    + "<br><br>"
//                    + "<br><br>"
//                    ;
//            List<String> toAddressList = new ArrayList<String>();
//            toAddressList.add(toAddress);
//            connectEmail.sendMail(subject, fromAddress, toAddressList, null, message);
//        }
//
//    }
//}
