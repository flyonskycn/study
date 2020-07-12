package com.flyonsky.model;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author luowengang
 * @date 2020/7/12 9:34
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlowDetail implements Serializable {

    private Long accountId;

    private String accountName;

    private Double currentAmount;

    private Date currentTime;
}
