package kttai.work;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.platform.commons.util.StringUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class transferLogonNameToPinYin {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://134.134.2.27:3306/ehr?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&useOldAliasMetadataBehavior=true&useSSL=false";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "123456";
    private static HanyuPinyinOutputFormat format = null;

    public static void main(String[] args) throws Exception {


        format = new HanyuPinyinOutputFormat();
        // UPPERCASE：大写  (ZHONG)
        // LOWERCASE：小写  (zhong)
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        // WITHOUT_TONE：无音标  (zhong)
        // WITH_TONE_NUMBER：1-4数字表示英标  (zhong4)
        // WITH_TONE_MARK：直接用音标符（必须WITH_U_UNICODE否则异常）  (zhòng)
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        // WITH_V：用v表示ü  (nv)
        // WITH_U_AND_COLON：用"u:"表示ü  (nu:)
        // WITH_U_UNICODE：直接用ü (nü)
        format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);

        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        String querySql = "SELECT user_id,user_name FROM mf_org_user_new WHERE password = 'kx66666611' limit 100";
        try (Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(querySql);
            while (resultSet.next()){
                System.out.println("================================================================");
                String user_id = resultSet.getString("user_id");
                System.out.println(user_id);
                String user_name = resultSet.getString("user_name");
                System.out.println(user_name);
                String logonName = toPinYin(user_name);
                System.out.println(logonName);
                System.out.println("================================================================");
                try (Statement statementIn = connection.createStatement();) {
                    String updateSql = "update mf_org_user_new set logon_name='"+logonName+"' where user_id='"+user_id+"' limit 1";
                    statementIn.executeUpdate(updateSql);
                }
            }
        }



    }

    public static String toPinYin(String str) throws BadHanyuPinyinOutputFormatCombination {
        if(StringUtils.isNotBlank(str)) {
            char[] charArray = str.toCharArray();
            StringBuffer strSB = new StringBuffer();
            for(int i=0; i<charArray.length; i++) {
                String[] hanyuPinyinStringArray = PinyinHelper.toHanyuPinyinStringArray(charArray[i], format);
                if(hanyuPinyinStringArray != null) {
                    for(String hanyuPinyinString : hanyuPinyinStringArray) {
                        strSB.append(hanyuPinyinString);
                    }
                }else {
                    strSB.append(charArray[i]);
                }
            }
            return strSB.toString();
        }
        return null;
    }
}
