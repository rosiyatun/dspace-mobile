package id.ac.ipb.dspacemobileapps.models;

import java.util.HashMap;
import java.util.List;


/**
 * Created by Hanif Affandi Hartanto on 7/17/2015.
 */
public class WsSystem {
    private String token;
    private int errCode;
    private String errMessage;
    private List<String> infos;
    private HashMap<String, String> validate;
    private Pagination pagination;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public List<String> getInfos() {
        return infos;
    }

    public void setInfos(List<String> infos) {
        this.infos = infos;
    }

    public HashMap<String, String> getValidate() {
        return validate;
    }

    public void setValidate(HashMap<String, String> validate) {
        this.validate = validate;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
