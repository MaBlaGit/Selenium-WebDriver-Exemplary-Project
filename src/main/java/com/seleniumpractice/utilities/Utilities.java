package com.seleniumpractice.utilities;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.List;

public class Utilities {

    private String userEmail;
    private String userPassword;

    public void setUserEmail(String userEmail){

        this.userEmail = userEmail;
    }

    public void setUserPassword(String userPassword){

        this.userPassword = userPassword;
    }

    public String getUserEmail(){

        return this.userEmail;
    }

    public String getUserPassword(){

        return this.userPassword;
    }

    public List<String[]> csvDataReader(String csvFilePath){
        try{
            CSVReader csvReader = new CSVReader(new FileReader(csvFilePath));
            List<String[]> data = csvReader.readAll();
            return data;
        }catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
