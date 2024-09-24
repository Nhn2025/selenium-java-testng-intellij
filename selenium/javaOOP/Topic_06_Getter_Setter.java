package javaOOP;

public class Topic_06_Getter_Setter {
    // Kiểm tra/ validate dữ liệu được
    public String personName;
    public int personAge;
    public int personPhone;
    public float personBankAccountAmount;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        if (personName == null || personName.isBlank() || personName.isEmpty())
            throw new IllegalArgumentException("Tên nhập vào không hợp lệ");
        else
            this.personName = personName;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        if (personAge > 0 && personAge < 120)
            throw new IllegalArgumentException("Tuổi nhập vào không hợp lệ");
        else
            this.personAge = personAge;
    }

    public int getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(int personPhone) {
        if (!String.valueOf(personPhone).startsWith("0"))
            throw new IllegalArgumentException("Số điện thoại nhập vào không hợp lệ");
        else if (personPhone < 10 || personPhone > 11)
            throw new IllegalArgumentException("Số điện thoại nhập vào không hợp lệ");
        else this.personPhone = personPhone;
    }

    public float getPersonBankAccountAmount() {
        return personBankAccountAmount;
    }

    public void setPersonBankAccountAmount(float personBankAccountAmount) {
        this.personBankAccountAmount = personBankAccountAmount;
    }


}
