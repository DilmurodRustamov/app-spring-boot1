package uz.pdp.appspringboot1.payload;

import lombok.Data;

import javax.persistence.Column;
@Data
public class ReqContact {

    private String firstName;

    private String lastName;

    private String middleName;

    private String number;
}
