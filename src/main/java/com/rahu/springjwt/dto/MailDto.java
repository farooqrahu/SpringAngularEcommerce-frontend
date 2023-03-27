/**
 * @author Junaid Butt
 * @email junaid.butt@ideatolife.me
 * @create date 2020-05-21 23:25:55
 * @modify date 2020-05-21 23:25:55
 * @desc [description]
 */
package com.rahu.springjwt.dto;

import java.util.Map;

public class MailDto {

    private String to;
    private String subject;
    private Map<String, Object> model;

    MailDto(String to, String subject, Map<String, Object> model) {
        this.to = to;
        this.subject = subject;
        this.model = model;
    }

    public static MailDto factoryMailDto(String to, String subject, Map<String, Object> model) {
        return MailDto.builder().to(to).subject(subject).model(model).build();
    }

    public static MailDtoBuilder builder() {
        return new MailDtoBuilder();
    }

    /**
     * @return String return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * @return String return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return Map<String, Object> return the model
     */
    public Map<String, Object> getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(Map<String, Object> model) {
        this.model = model;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MailDto)) return false;
        final MailDto other = (MailDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$to = this.getTo();
        final Object other$to = other.getTo();
        if (this$to == null ? other$to != null : !this$to.equals(other$to)) return false;
        final Object this$subject = this.getSubject();
        final Object other$subject = other.getSubject();
        if (this$subject == null ? other$subject != null : !this$subject.equals(other$subject)) return false;
        final Object this$model = this.getModel();
        final Object other$model = other.getModel();
        if (this$model == null ? other$model != null : !this$model.equals(other$model)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MailDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $to = this.getTo();
        result = result * PRIME + ($to == null ? 43 : $to.hashCode());
        final Object $subject = this.getSubject();
        result = result * PRIME + ($subject == null ? 43 : $subject.hashCode());
        final Object $model = this.getModel();
        result = result * PRIME + ($model == null ? 43 : $model.hashCode());
        return result;
    }

    public String toString() {
        return "MailDto(to=" + this.getTo() + ", subject=" + this.getSubject() + ", model=" + this.getModel() + ")";
    }

    public static class MailDtoBuilder {
        private String to;
        private String subject;
        private Map<String, Object> model;

        MailDtoBuilder() {
        }

        public MailDtoBuilder to(String to) {
            this.to = to;
            return this;
        }

        public MailDtoBuilder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public MailDtoBuilder model(Map<String, Object> model) {
            this.model = model;
            return this;
        }

        public MailDto build() {
            return new MailDto(to, subject, model);
        }

        public String toString() {
            return "MailDto.MailDtoBuilder(to=" + this.to + ", subject=" + this.subject + ", model=" + this.model + ")";
        }
    }
}
