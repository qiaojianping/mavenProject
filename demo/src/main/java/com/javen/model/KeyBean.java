package com.javen.model;

/**
 * description: xxx.
 *
 * @author Sorgs.
 * Created date: 2019/3/7.
 */
public class KeyBean {

    /**
     * data_attestation_file : http://192.168.1.111/getAttestationFile/WV1376391152
     * data_hdcp_v1.4_file : http://192.168.1.111/getHdcpFile/hdcp14_0001
     * data_hdcp_v2.2_file : http://192.168.1.111/getHdcpFile/hdcp22_0001
     * data_imei : QG23K3C5GXBE
     * data_mac : 80:0B:52:06:FF:F9
     * data_model_code : S111
     * data_widevine_file : http://192.168.1.111/getWidevineFile/WV1376391152
     * remark : 获取成功！
     * result : 1
     * data_customer_id: "11111"
     * data_widevine_file: ""
     * data_playready_public_file: ""
     * data_playready_private_file: ""
     */

    public String data_attestation_file;
    public String data_customer_id;
    //@SerializedName("data_hdcp_v1.4_file")
    public String data_hdcp_v14_file;
    //@SerializedName("data_hdcp_v2.2_file")
    public String data_hdcp_v22_file;
    public String data_imei;
    public String data_mac;
    public String data_model_code;
    public String data_widevine_file;
    public String data_playready_public_file;
    public String data_playready_private_file;
    public String remark;
    public int result;
}
