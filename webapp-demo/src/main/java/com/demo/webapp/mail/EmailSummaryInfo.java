package com.demo.webapp.mail;

/**
 * 邮件的概要信息
 */
public class EmailSummaryInfo {
    private String from;
    private String to;
    private String[] tos;
    private String subject;
    private String cc;
    private String[] ccs;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String[] getCcs() {
        return ccs;
    }

    public void setCcs(String[] ccs) {
        this.ccs = ccs;
    }

    public String[] getTos() {
        return tos;
    }

    public void setTos(String[] tos) {
        this.tos = tos;
    }
}
