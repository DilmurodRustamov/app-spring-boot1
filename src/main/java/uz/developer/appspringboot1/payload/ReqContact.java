package uz.developer.appspringboot1.payload;

import lombok.Data;

@Data
public class ReqContact {

    private String firstName;

    private String lastName;

    private String middleName;

    private String number;
}
