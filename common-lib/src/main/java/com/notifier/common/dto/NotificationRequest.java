
package com.notifier.common.dto;

public class NotificationRequest {
    private String recipient;
    private String message;
    private String channel; // EMAIL or SMS

    public NotificationRequest() {}

    public NotificationRequest(String recipient, String message, String channel) {
        this.recipient = recipient;
        this.message = message;
        this.channel = channel;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
