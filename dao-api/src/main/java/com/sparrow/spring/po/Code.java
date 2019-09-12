package com.sparrow.spring.po;

import com.sparrow.core.spi.JsonFactory;
import com.sparrow.orm.Namespace;
import com.sparrow.protocol.POJO;
import com.sparrow.protocol.constant.magic.SYMBOL;
import com.sparrow.protocol.enums.STATUS_RECORD;

import javax.persistence.*;

/**
 * @author harry
 */
@Table(
        name = "code",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"code"}),
                @UniqueConstraint(columnNames = {"code2"})
        }
)
//可以省略，默认取po的同级dao 包,接口名为po加DAO后缀
@Namespace("com.sparrow.spring.dao.CodeDAO")
public class Code implements POJO {
    private String uuid;
    private String name;
    private String parentUuid;
    private String code;
    private String value;
    private STATUS_RECORD status;
    private String remark;
    private Integer orderNo;

    public Code() {
    }

    public Code(String name, String parentUuid, String code) {
        this(name, parentUuid, code, SYMBOL.EMPTY, STATUS_RECORD.ENABLE, SYMBOL.EMPTY);
    }

    public Code(String name, String parentUuid, String code, String value) {
        this(name, parentUuid, code, value, STATUS_RECORD.ENABLE, SYMBOL.EMPTY);
    }

    public Code(String name, String parentUuid, String code, String value,
                STATUS_RECORD status, String remark) {
        this(name, parentUuid, code, value, status, remark, SYMBOL.EMPTY);
    }

    public Code(String name, String parentUuid, String code, String value,
                STATUS_RECORD status, String remark, String uuid) {
        this(name, parentUuid, code, value, status, remark, uuid, 0);
    }

    public Code(String name, String parentUuid, String code, String value,
                STATUS_RECORD status, String remark, String uuid, Integer orderNo) {
        this.name = name;
        this.parentUuid = parentUuid;
        this.code = code;
        this.value = value;
        this.status = status;
        this.remark = remark;
        this.uuid = uuid;
        this.orderNo = orderNo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    @Column(name = "uuid", columnDefinition = "varchar(40)", nullable = false)
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Column(name = "name", columnDefinition = "varchar(100) DEFAULT ''", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "parent_uuid", columnDefinition = "varchar(40) DEFAULT ''", nullable = false)
    public String getParentUuid() {
        return parentUuid;
    }

    public void setParentUuid(String parentUuid) {
        this.parentUuid = parentUuid;
    }

    @Column(name = "code", columnDefinition = "varchar(40) DEFAULT ''", unique = true, nullable = false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "value", columnDefinition = "varchar(40) DEFAULT ''")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Column(name = "status", columnDefinition = "TINYINT(1) DEFAULT 0")
    public STATUS_RECORD getStatus() {
        return status;
    }

    public void setStatus(STATUS_RECORD status) {
        this.status = status;
    }

    @Column(name = "remark", columnDefinition = "TEXT")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return JsonFactory.getProvider().toString(this);
    }

    @Column(name = "order_no", columnDefinition = "INT(11) DEFAULT 0", nullable = false)
    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
}
