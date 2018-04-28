package com.example.angruixian.u_hoo_backend;

import java.io.Serializable;

/**
 * Created by angruixian on 24/2/18.
 */

public class Payment implements Serializable {
    private String date;
    private String time;
    private String duration;
    private String paymentAmount;
    private String withdrawDateTime;

    public Payment(String date, String time, String duration, String paymentAmount, String withdrawDateTime) {
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.paymentAmount = paymentAmount;
        this.withdrawDateTime = withdrawDateTime;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getWithdrawDateTime() {
        return withdrawDateTime;
    }

    public void setWithdrawDateTime(String withdrawDateTime) {
        this.withdrawDateTime = withdrawDateTime;
    }

    @Override
    public String toString() {
        return "Payment Amount: " + paymentAmount
                + "\nDatetime: " + date + time ;
    }
}
