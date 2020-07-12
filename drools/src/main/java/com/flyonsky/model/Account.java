package com.flyonsky.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author luowengang
 * @date 2020/7/12 9:34
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {

    private Long accountId;

    private String accountName;

    private Double amount;

    List<FlowDetail> flowDetailList;

    private boolean isValid;
}
