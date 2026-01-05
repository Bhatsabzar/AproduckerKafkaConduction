package com.Aconduction.Entity.dto;

import lombok.Data;

@Data
public class CustomerUsage {


    private String customerName;
    private int callMinute;
    private int dataMb;
    private int smsCount;
}


