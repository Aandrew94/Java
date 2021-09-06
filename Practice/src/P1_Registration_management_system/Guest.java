package P1_Registration_management_system;

public class Guest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;


    public Guest(String firstName, String lastName, String email, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    public  String  getFirstName(){ return this.firstName;  }
    public  String  getLastName(){  return this.lastName;   }
    public  String  getFullName(){  return getFirstName() + " " + getLastName();    }
    public  String  getEmail(){ return this.email;  }
    public  String  getPhoneNumber(){   return this.phoneNumber;    }

    public  void    setFirstName(String newFirstName){  this.firstName = newFirstName;  }
    public  void    setLastName(String newLastName){    this.lastName = newLastName;    }
    public  void    setEmail(String newEmail){  this.email = newEmail;  }
    public  void    setPhoneNumber(String newPhoneNumber){  this.phoneNumber = newPhoneNumber;  }


    @Override
    public  String  toString(){
        return  "-\tNume:\t" + getFullName() + ", Email: " + getEmail() + ", Telefon: " + getPhoneNumber();
    }

    @Override
    public  boolean equals(Object comparedObj){
        if(this == comparedObj){    return true;    }
        if(comparedObj == null){    return false;   }
        if(this.getClass() != comparedObj.getClass()){  return false;   }

        Guest comparedGuest = (Guest)comparedObj;

        return  this.firstName.equals(comparedGuest.firstName)  &&
                this.lastName.equals(comparedGuest.lastName)    &&
                this.email.equals(comparedGuest.email)          &&
                this.phoneNumber.equals(comparedGuest.phoneNumber);
    }

    @Override
    public  int hashCode(){
        int prime = 13;
        int result = super.hashCode();

        result  =   prime   *   result  +   ((this.firstName == null)   ?   0   :   this.firstName.hashCode());
        result  =   prime   *   result  +   ((this.lastName == null)    ?   0   :   this.lastName.hashCode());
        result  =   prime   *   result  +   ((this.email == null)       ?   0   :   this.email.hashCode());
        result  =   prime   *   result  +   ((this.phoneNumber == null) ?   0   :   this.email.hashCode());

        return result;
    }

}