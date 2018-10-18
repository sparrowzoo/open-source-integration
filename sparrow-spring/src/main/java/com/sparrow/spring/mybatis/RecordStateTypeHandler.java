package com.sparrow.spring.mybatis;

import com.sparrow.enums.STATUS_RECORD;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecordStateTypeHandler implements TypeHandler<STATUS_RECORD> {

    @Override
    public STATUS_RECORD getResult(ResultSet rs, String arg) throws SQLException {
        return STATUS_RECORD.values()[rs.getInt(arg)];
    }

    @Override
    public STATUS_RECORD getResult(ResultSet rs, int arg) throws SQLException {
        return STATUS_RECORD.values()[rs.getInt(arg)];
    }

    @Override
    public STATUS_RECORD getResult(CallableStatement cs, int arg) throws SQLException {
        return STATUS_RECORD.values()[cs.getInt(arg)];
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, STATUS_RECORD value, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, value.ordinal());
    }
}