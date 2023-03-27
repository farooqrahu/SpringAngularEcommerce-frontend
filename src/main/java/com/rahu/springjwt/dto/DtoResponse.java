package com.rahu.springjwt.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DtoResponse implements Serializable, Cloneable {

    /**
     * unique identifer for the serializable class
     */
    private static final long serialVersionUID = 5257529090904948800L;

    @JsonProperty(value = "status")
    protected String status;

    @JsonProperty(value = "code")
    protected int code;

    @JsonProperty(value = "message")
    protected String message;

    @JsonProperty(value = "validation_errors")
    protected List<ValidationMessage> validationErrors;

    @JsonProperty(value = "body")
    protected Object body;

    DtoResponse(int code, String status, String message, List<ValidationMessage> validationErrors, Object body) {
        this.code =code;
        this.status = status;
        this.message = message;
        this.validationErrors = validationErrors;
        this.body = body;
    }

    public static DtoResponseBuilder builder() {
        return new DtoResponseBuilder();
    }

    public String getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public List<ValidationMessage> getValidationErrors() {
        return this.validationErrors;
    }

    public Object getBody() {
        return this.body;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setValidationErrors(List<ValidationMessage> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof DtoResponse)) return false;
        final DtoResponse other = (DtoResponse) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$message = this.getMessage();
        final Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) return false;
        final Object this$validationErrors = this.getValidationErrors();
        final Object other$validationErrors = other.getValidationErrors();
        if (this$validationErrors == null ? other$validationErrors != null : !this$validationErrors.equals(other$validationErrors))
            return false;
        final Object this$body = this.getBody();
        final Object other$body = other.getBody();
        if (this$body == null ? other$body != null : !this$body.equals(other$body)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof DtoResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $message = this.getMessage();
        result = result * PRIME + ($message == null ? 43 : $message.hashCode());
        final Object $validationErrors = this.getValidationErrors();
        result = result * PRIME + ($validationErrors == null ? 43 : $validationErrors.hashCode());
        final Object $body = this.getBody();
        result = result * PRIME + ($body == null ? 43 : $body.hashCode());
        return result;
    }

    public String toString() {
        return "DtoResponse(status=" + this.getStatus() + ", message=" + this.getMessage() + ", validationErrors=" + this.getValidationErrors() + ", body=" + this.getBody() + ")";
    }

    public static class DtoResponseBuilder {
        private int code;
        private String status;
        private String message;
        private List<ValidationMessage> validationErrors;
        private Object body;

        DtoResponseBuilder() {
        }

        public DtoResponseBuilder status(String status) {
            this.status = status;
            return this;
        }

        public DtoResponseBuilder code(int code) {
            this.code = code;
            return this;
        }

        public DtoResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public DtoResponseBuilder validationErrors(List<ValidationMessage> validationErrors) {
            this.validationErrors = validationErrors;
            return this;
        }

        public DtoResponseBuilder body(Object body) {
            this.body = body;
            return this;
        }

        public DtoResponse build() {
            return new DtoResponse(code,status, message, validationErrors, body);
        }

        public String toString() {
            return "DtoResponse.DtoResponseBuilder(code=" + this.code +", status=" + this.status + ", message=" + this.message + ", validationErrors=" + this.validationErrors + ", body=" + this.body + ")";
        }
    }
}
