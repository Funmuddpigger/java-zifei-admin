package com.example.demo.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author mine
 * @since 2020-10-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ServiceTable implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String serverId;

    private String day;

    private String month;

    private String year;

    private Double totalDay;

    private Double totalMonth;
}
