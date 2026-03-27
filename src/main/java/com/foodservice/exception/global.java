package com.foodservice.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class global {
//
//    @ExceptionHandler(DuplicateCouponException.class)
//    public ResponseEntity<ErrorResponse> handleDuplicateCoupon(DuplicateCouponException ex) {
//        return new ResponseEntity<>(
//                new ErrorResponse(ex.getExceptionmsg()),
//                HttpStatus.CONFLICT
//        );
//    }
//
//    @ExceptionHandler(CouponNotFoundException.class)
//    public ResponseEntity<ErrorResponse> handleCouponNotFound(CouponNotFoundException ex) {
//        return new ResponseEntity<>(
//                new ErrorResponse(ex.getExceptionmsg()),
//                HttpStatus.NOT_FOUND
//        );
//    }
//
//    @ExceptionHandler(CouponExpiredException.class)
//    public ResponseEntity<ErrorResponse> handleCouponExpired(CouponExpiredException ex) {
//        return new ResponseEntity<>(
//                new ErrorResponse(ex.getExceptionmsg()),
//                HttpStatus.BAD_REQUEST
//        );
//    }
//
//    @ExceptionHandler(NoRecordsFoundException.class)
//    public ResponseEntity<ErrorResponse> handleNoRecords(NoRecordsFoundException ex) {
//        return new ResponseEntity<>(
//                new ErrorResponse(ex.getExceptionmsg()),
//                HttpStatus.NOT_FOUND
//        );
//    }
//
//    @ExceptionHandler(NoCustomerException.class)
//    public ResponseEntity<ErrorResponse> handleNoCustomer(NoCustomerException ex) {
//        return new ResponseEntity<>(
//                new ErrorResponse(ex.getExceptionMsg()),
//                HttpStatus.NOT_FOUND
//        );
//    }
//
//    @ExceptionHandler(NoAddressException.class)
//    public ResponseEntity<ErrorResponse> handleNoAddress(NoAddressException ex) {
//        return new ResponseEntity<>(
//                new ErrorResponse(ex.getExceptionMsg()),
//                HttpStatus.NOT_FOUND
//        );
//    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        return new ResponseEntity<>(
                new ErrorResponse(ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(IllegalArgumentException ex) {
        return new ResponseEntity<>(
                new ErrorResponse(ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneral(Exception ex) {

        ex.printStackTrace(); // for debugging

        return new ResponseEntity<>(
                new ErrorResponse("Server Error: " + ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}