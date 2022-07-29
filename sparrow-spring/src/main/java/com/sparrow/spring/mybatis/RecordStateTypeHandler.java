package com.sparrow.spring.mybatis;

import com.sparrow.orm.type.TypeHandler;
import com.sparrow.protocol.enums.StatusRecord;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecordStateTypeHandler implements TypeHandler<StatusRecord> {

    @Override
    public void setParameter(PreparedStatement ps, int i, StatusRecord parameter) throws SQLException {
        ps.setInt(i, parameter.ordinal());
    }

    @Override
    public StatusRecord getResult(ResultSet rs, String arg) throws SQLException {
        return StatusRecord.values()[rs.getInt(arg)];
    }

    @Override
    public StatusRecord getResult(ResultSet rs, int arg) throws SQLException {
        return StatusRecord.values()[rs.getInt(arg)];
    }

    @Override
    public StatusRecord getResult(CallableStatement cs, int arg) throws SQLException {
        return StatusRecord.values()[cs.getInt(arg)];
    }

}