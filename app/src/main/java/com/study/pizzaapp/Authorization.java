package com.study.pizzaapp;

import java.io.*;

import android.content.*;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class Authorization implements Serializable {


    //////////////////Конструктор/////////////////////
    public Authorization(Context context, String name,String password, String mail, String phoneNumber, String cardNumber, String address, String birthday, String ID) {
        this.context = context;
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.cardNumber = cardNumber;
        this.address = address;
        this.birthday = birthday;
        this.ID = ID;
    }
    //public Authorization(Context context) {
    //    this.context = context;
    //}
    //////////////////Поля/////////////////////
    private static Context context;
    private String name;
    private String password;
    private String mail;
    private String phoneNumber;
    private String cardNumber;
    private String address;
    private String birthday;
    private String ID;
    private boolean isAuthorized;

    //////////////////Геттеры/////////////////////
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public String getMail() {
        return mail;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public String getAddress() {
        return address;
    }
    public String getBirthday() {
        return birthday;
    }
    public String getID() {
        return ID;
    }

    //////////////////Сеттеры/////////////////////
    public void setName(String name) {
        Authorization user = Authorization.Load(context);
        user.name = name;
        user.Save();
    }
    public void setPassword(String password) {
        Authorization user = Authorization.Load(context);
        user.password = password;
        user.Save();
    }
    public void setMail(String mail) {
        Authorization user = Authorization.Load(context);
        user.mail = mail;
        user.Save();
    }
    public void setPhoneNumber(String phoneNumber) {
        Authorization user = Authorization.Load(context);
        user.phoneNumber = phoneNumber;
        user.Save();
    }
    public void setCardNumber(String cardNumber) {
        Authorization user = Authorization.Load(context);
        user.cardNumber= cardNumber;
        user.Save();
    }
    public void setAddress(String address) {
        Authorization user = Authorization.Load(context);
        user.address= address;
        user.Save();
    }
    public void setBirthday(String birthday) {
        Authorization user = Authorization.Load(context);
        user.birthday = birthday;
        user.Save();
    }

    public void setAuthorization(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    //////////////////Проверка наличия поля/////////////////////
    public boolean haveName() {
        if (!name.equals("-")) {
            return true;
        }
        return false;
    }
    public boolean havePassword() {
        if (!password.equals("-")) {
            return true;
        }
        return false;
    }
    public boolean haveMail() {
        if (!mail.equals("-")) {
            return true;
        }
        return false;
    }
    public boolean havePhoneNumber() {
        if (!phoneNumber.equals("-")) {
            return true;
        }
        return false;
    }
    public boolean haveCardNumber() {
        if (!cardNumber.equals("-")) {
            return true;
        }
        return false;
    }
    public boolean haveAddress() {
        if (!address.equals("-")) {
            return true;
        }
        return false;
    }
    public boolean haveBirthday() {
        if (!birthday.equals("-")) {
            return true;
        }
        return false;
    }
    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void Save() {
        try {
            //FileOutputStream fileStream = new FileOutputStream(new File("authorization.ser"));
            FileOutputStream fos = context.openFileOutput("authorization.ser", Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(this);
            os.close();
            fos.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static Authorization Load(Context context) {
        try {
            Authorization.context = context;
            FileInputStream fileIn = context.openFileInput("authorization.ser");
            ObjectInputStream is = new ObjectInputStream(fileIn);
            //fileIn.close();
            return (Authorization) is.readObject();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return new Authorization(context,"-", "-", "-", "-", "-", "-", "-", "-");
    }

    public void printData() {
        System.out.println(name);
        System.out.println(password);
        System.out.println(mail);
        System.out.println(phoneNumber);
        System.out.println(cardNumber);
        System.out.println(address);
        System.out.println(birthday);
        System.out.println(ID);
    }
}
