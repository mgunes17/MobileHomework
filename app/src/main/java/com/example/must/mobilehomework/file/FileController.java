package com.example.must.mobilehomework.file;

import android.content.ContentValues;
import android.content.Context;
import android.widget.Toast;

import com.example.must.mobilehomework.SignUpActivity;
import com.example.must.mobilehomework.model.Car;
import com.example.must.mobilehomework.model.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by must on 30.04.2016.
 */
public class FileController {
    private final static String USER_FILE_NAME = "users.txt";
    private final static String CAR_FILE_NAME = "cars.txt";

    public List<Car> getAllCars(Context context){
        List<Car> carList = new ArrayList<>();

        String line;
        String [] split;

        try{
            InputStream inputStream = context.openFileInput(CAR_FILE_NAME);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                while ((line = bufferedReader.readLine()) != null ) {
                    split = line.split(" ");
                    carList.add(new Car(Integer.parseInt(split[0]),split[1],split[2],split[3]));
                }

                inputStream.close();

            }
        }
        catch(FileNotFoundException nfe){
            Toast.makeText(context, "cars.txt Dosya Bulunamadı", Toast.LENGTH_SHORT).show();
        }
        catch (IOException io){
            Toast.makeText(context, "car.txt Okuma hatası", Toast.LENGTH_SHORT).show();
        }

        return carList;
    }

    public boolean saveCar(Car car, Context context){
        try{
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    context.openFileOutput(CAR_FILE_NAME, Context.MODE_APPEND));

            outputStreamWriter.write(car.getId()+" ");
            outputStreamWriter.write(car.getModel()+" ");
            outputStreamWriter.write(car.getLocationCity()+" ");
            outputStreamWriter.write(car.getType());
            outputStreamWriter.write("\n");
            outputStreamWriter.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "Bir hata meydana geldi", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    //verilen userName e ait satırı döndürür
    public String getUser(String userName, Context context){
        String line;
        String [] splitLine;

        try{
            InputStream inputStream = context.openFileInput(USER_FILE_NAME);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                while ((line = bufferedReader.readLine()) != null ) {
                    splitLine = line.split(" ");
                    if(splitLine[0].contains(userName))
                        return line; //userName varsa ona ait satır kaydını döndür
                }

                inputStream.close();

            }
        }
        catch(FileNotFoundException nfe){
            Toast.makeText(context, "Dosya Bulunamadı", Toast.LENGTH_SHORT).show();
        }
        catch (IOException io){
            Toast.makeText(context, "Okuma hatası", Toast.LENGTH_SHORT).show();
        }

        return null;
    }

    //verilen satırı parse ederek oluşturduğu user ı döndürür
    public User getUser(String line){
        String []splitLine;
        splitLine = line.split(" ");
        User user = new User();
        user.setUserName(splitLine[0]);
        user.setPassword(splitLine[1]);
        user.setName(splitLine[2]);
        user.setSurname(splitLine[3]);

        return user;
    }

    //dosyaya yeni bir kullanıcıyı kaydeder
    public boolean saveUser(User user, Context context){
        try{
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                context.openFileOutput(USER_FILE_NAME, Context.MODE_APPEND));

            outputStreamWriter.write(user.getUserName()+" ");
            outputStreamWriter.write(user.getPassword()+" ");
            outputStreamWriter.write(user.getName()+" ");
            outputStreamWriter.write(user.getSurname());
            outputStreamWriter.write("\n");
            outputStreamWriter.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }


        return true;
    }

    //alınmak istenen kullanıcı adının dosyada olup olmadığını kontrol eder
    public boolean isExistUserName(String userName, Context context){
        String line;
        String [] splitLine;

        try{
            InputStream inputStream = context.openFileInput(USER_FILE_NAME);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                while ((line = bufferedReader.readLine()) != null ) {
                    splitLine = line.split(" "); //satır boşluk karakterine göre parse edildi
                    if(splitLine[0].equalsIgnoreCase(userName)) //userName dosyadaki ilk sütunda
                        return true; //userName varsa false döndür
                }

                inputStream.close();

            }
        }
        catch(FileNotFoundException nfe){
            Toast.makeText(context, "Dosya Bulunamadı", Toast.LENGTH_LONG).show();
        }
        catch (IOException io){
            Toast.makeText(context, "Okuma hatası", Toast.LENGTH_LONG).show();
        }

        return false;
    }
}
