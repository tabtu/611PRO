package uow.csse.bptzz.model;

import java.io.Serializable;

/**
 * Created by Tab Tu
 * Updated Oct.3 2017 05:45
 */
public class User  implements Serializable  {

    private static final long serialVersionUID = 1L;

    private String _Username;
    public String get_Username() {
        return _Username;
    }
    public void set_Username(String usr) {
        _Username = usr;
    }

    private String _Password;
    public void set_Password(String _Password) {
        this._Password = _Password;
    }
    public String get_Password() {
        return _Password;
    }

    private String _Name;
    public String get_Name() {
        return _Name;
    }
    public void set_Name(String _Name) {
        this._Name = _Name;
    }
}
