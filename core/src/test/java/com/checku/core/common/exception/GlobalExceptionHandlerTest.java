package com.checku.core.common.exception;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
    private ListAppender<ILoggingEvent> listAppender;

    @BeforeEach
    void setUp() {
        setUpLogger();
    }

    private void setUpLogger() {
        Logger logger = (Logger) LoggerFactory.getLogger(GlobalExceptionHandler.class);
        listAppender = new ListAppender<>();
        listAppender.start();
        logger.addAppender(listAppender);
    }

    @Test
    void BindException이_발생하면_로그를_찍고_400_StatusCode와_함께_ErrorResponse를_반환한다() {
        // given
        BindException bindException = mock(BindException.class);
        given(bindException.getFieldErrors()).willReturn(List.of(
                new FieldError("object1", "field1", "Bind ErrorMessage1"),
                new FieldError("object2", "field2", "Bind ErrorMessage2")));

        // when
        ResponseEntity<ErrorResponse> responseEntity = globalExceptionHandler.handleBindException(bindException);

        // then
        assertThat(isErrorMessagesLogged(List.of("Bind ErrorMessage1", "Bind ErrorMessage2"))).isTrue();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(responseEntity.getBody()).isEqualTo(ErrorResponse.from(List.of("Bind ErrorMessage1", "Bind ErrorMessage2")));
    }

    @Test
    void MethodArgumentTypeMismatchException이_발생하면_로그를_찍고_400_StatusCode와_함께_ErrorResponse를_반환한다() {
        // given
        MethodArgumentTypeMismatchException methodArgumentTypeMismatchException = mock(MethodArgumentTypeMismatchException.class);
        given(methodArgumentTypeMismatchException.getMessage()).willReturn("MethodArgumentTypeMismatch ErrorMessage");

        // when
        ResponseEntity<ErrorResponse> responseEntity = globalExceptionHandler.handleMethodArgumentTypeMismatchException(methodArgumentTypeMismatchException);

        // then
        assertThat(isErrorMessageLogged("MethodArgumentTypeMismatch ErrorMessage")).isTrue();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(responseEntity.getBody()).isEqualTo(ErrorResponse.from("MethodArgumentTypeMismatch ErrorMessage"));
    }

    @Test
    void HttpRequestMethodNotSupportedException이_발생하면_로그를_찍고_405_StatusCode와_함께_ErrorResponse를_반환한다() {
        // given
        HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException = mock(HttpRequestMethodNotSupportedException.class);
        given(httpRequestMethodNotSupportedException.getMessage()).willReturn("HttpRequestMethodNotSupported ErrorMessage");

        // when
        ResponseEntity<ErrorResponse> responseEntity = globalExceptionHandler.handleHttpRequestMethodNotSupportedException(httpRequestMethodNotSupportedException);

        // then
        assertThat(isErrorMessageLogged("HttpRequestMethodNotSupported ErrorMessage")).isTrue();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.METHOD_NOT_ALLOWED);
        assertThat(responseEntity.getBody()).isEqualTo(ErrorResponse.from("HttpRequestMethodNotSupported ErrorMessage"));
    }

    @Test
    void BusinessException이_발생하면_로그를_찍고_StatusCode와_함께_ErrorResponse를_반환한다() {
        // given
        BusinessException businessException = mock(BusinessException.class);
        given(businessException.getHttpStatus()).willReturn(HttpStatus.NOT_FOUND);
        given(businessException.getMessage()).willReturn("Business ErrorMessage");

        // when
        ResponseEntity<ErrorResponse> responseEntity = globalExceptionHandler.handleBusinessException(businessException);

        // then
        assertThat(isErrorMessageLogged("Business ErrorMessage")).isTrue();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(responseEntity.getBody()).isEqualTo(ErrorResponse.from("Business ErrorMessage"));
    }

    @Test
    void Exception이_발생하면_로그를_찍고_500_StatusCode와_함께_ErrorResponse를_반환한다() {
        // given
        Exception exception = mock(Exception.class);
        given(exception.getMessage()).willReturn("Exception ErrorMessage");

        // when
        ResponseEntity<ErrorResponse> responseEntity = globalExceptionHandler.handleException(exception);

        // then
        assertThat(isErrorMessageLogged("Exception ErrorMessage")).isTrue();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(responseEntity.getBody()).isEqualTo(ErrorResponse.serverError());
    }

    private boolean isErrorMessageLogged(final String errorMessage) {
        return listAppender.list.stream()
                .map(ILoggingEvent::getMessage)
                .anyMatch(message -> message.equals(errorMessage));
    }

    private boolean isErrorMessagesLogged(final List<String> errorMessages) {
        return listAppender.list.stream()
                .map(ILoggingEvent::getMessage)
                .anyMatch(errorMessages::contains);
    }
}
