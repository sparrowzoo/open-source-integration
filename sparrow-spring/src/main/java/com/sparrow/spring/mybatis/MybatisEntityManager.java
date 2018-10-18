package com.sparrow.spring.mybatis;

import com.sparrow.orm.AbstractEntityManagerAdapter;
import com.sparrow.orm.Namespace;
import com.sparrow.utility.StringUtility;

import javax.persistence.GenerationType;

public class MybatisEntityManager extends AbstractEntityManagerAdapter {
    private StringBuilder xml;
    private Class clazz;

    public String getXml() {
        return xml.toString();
    }

    public MybatisEntityManager(Class clazz) {
        super(clazz);
        this.clazz = clazz;
    }

    @Override
    public void init(Class clazz) {
        this.xml = new StringBuilder();
        this.generateHeader(clazz);
        this.generateResultMap();
        this.generateFieldSql();
        if (this.primary.getGenerationType().equals(GenerationType.AUTO)) {
            this.generateUuidInsert();
        } else {
            this.generateInsert();
        }
        this.generateUpdate();
        this.generateDelete();
        this.generateGetEntity();
        this.generateGetEntityByUnique();
        xml.append("</mapper>");
    }

    @Override
    public String parsePropertyParameter(String column, String property) {
        return "#{" + property + "}";
    }

    private void generateHeader(Class clazz) {
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xml.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org/DTD Mapper 3.0\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n");
        String namespace;
        if (!clazz.isAnnotationPresent(Namespace.class)) {
            String[] clazzNameArray = this.className.split("\\.");
            if (clazzNameArray.length < 2) {
                throw new RuntimeException("package split length must be great then 2 e.g com.sparrow.spring.po.Code");
            }
            clazzNameArray[clazzNameArray.length - 2] = "dao";
            clazzNameArray[clazzNameArray.length - 1] += "DAO";
            namespace = StringUtility.join(".", clazzNameArray);
        } else {
            Namespace ns = (Namespace) clazz.getAnnotation(Namespace.class);
            namespace = ns.value();
        }
        xml.append(String.format("<mapper namespace=\"%s\">\n", namespace));
    }

    private void generateResultMap() {
        xml.append(String.format("<resultMap id=\"%sMap\" type=\"%s\">\n", this.tableName, this.className));
        xml.append(String.format("<id property=\"%s\" column=\"%s\"/>\n", this.primary.getName(), this.primary.getColumnName()));
        for (String column : this.columnPropertyMap.keySet()) {
            xml.append(String.format(" <result column=\"%s\" property=\"%s\"/>\n", column, this.columnPropertyMap.get(column)));
        }
        xml.append("</resultMap>\n");
    }

    private void generateGetEntityByUnique() {
        xml.append(String.format("<select id=\"getEntityByUnique\" resultMap=\"%sMap\" parameterType=\"com.sparrow.support.db.UniqueKeyCriteria\">\n", this.tableName));
        xml.append(" SELECT \n");
        xml.append("<include refid=\"fields\"/>\n");
        xml.append(" FROM \n");
        xml.append(this.tableName);
        xml.append("WHERE ${uniqueFieldName}= #{key}\n");
        xml.append("</select>\n");
    }

    private void generateGetEntity() {
        xml.append(String.format("<select id=\"getEntity\" resultMap=\"%sMap\" parameterType=\"com.sparrow.support.db.UniqueKeyCriteria\">\n", this.tableName));
        xml.append(" SELECT \n");
        xml.append("<include refid=\"fields\"/>\n");
        xml.append(" FROM \n");
        xml.append(this.tableName);
        xml.append(String.format("\nWHERE %s= #{%s}\n", this.primary.getColumnName(), this.primary.getName()));
        xml.append("</select>\n");
    }

    private void generateFieldSql() {
        xml.append(String.format("<sql id=\"fields\">%s</sql>\n", this.fields));
    }

    private void generateInsert() {
        xml.append(String.format("<insert id=\"insert\" parameterType=\"%s\">\n", this.className));
        xml.append(this.insert);
        xml.append("</insert>");
    }

    private void generateUuidInsert() {
        xml.append(String.format("<insert id=\"insert\" parameterType=\"%s\">\n", this.className));
        xml.append(String.format("<selectKey keyProperty=\"%s\" keyColumn=\"%s\"  order=\"BEFORE\" resultType=\"java.lang.String\">\n", this.primary.getName(), this.primary.getColumnName()));
        xml.append("select UUID()\n");
        xml.append("</selectKey>\n");
        xml.append(this.insert);
        xml.append("\n</insert>\n");
    }

    private void generateUpdate() {
        xml.append(String.format(" <update id=\"update\" parameterType=\"%s\">\n", this.className));
        xml.append(this.update);
        xml.append("\n</update>\n");
    }

    private void generateDelete() {
        xml.append(String.format("<delete id=\"delete\" parameterType=\"%s\">\n", this.primary.getType().getName()));
        xml.append(this.delete);
        xml.append("\n</delete>\n");
    }
}
