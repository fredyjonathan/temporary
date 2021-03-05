package com.example.midproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    private View contentView1;
    private View contentView2;
    private View contentView3;
    private View contentView4;
    private View contentView5;
    private View contentView6;
    private View contentView7;

    Button btnsubmit, save, td;
    EditText tipe, brand, name, license, speed, gas, wheel, type, esa, price, edt, helm;
    TextView result, tv1, tv2, po, no;
    int pricetotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        contentView1 = findViewById(R.id.pricetext);
        contentView2 = findViewById(R.id.priceinput);
        contentView3 = findViewById(R.id.btntestdrive);
        contentView4 = findViewById(R.id.helmtext);
        contentView5 = findViewById(R.id.helminput);
        contentView6 = findViewById(R.id.Entertainmenttext);
        contentView7 = findViewById(R.id.Entertainmentinput);

        tipe=(EditText)findViewById(R.id.tipeinput);
        brand=(EditText)findViewById(R.id.brandinput);
        name=(EditText)findViewById(R.id.nameinput);
        license=(EditText)findViewById(R.id.licenseinput);
        speed=(EditText)findViewById(R.id.topspeedinput);
        gas=(EditText)findViewById(R.id.gascapacityinput);
        wheel=(EditText)findViewById(R.id.wheelinput);
        type=(EditText)findViewById(R.id.typeinput);
        esa=(EditText)findViewById(R.id.Entertainmentinput);
        btnsubmit = (Button)findViewById(R.id.btnsubmit);
        save = (Button)findViewById(R.id.btnsave);
        price=(EditText)findViewById(R.id.priceinput);
        result = (TextView)findViewById(R.id.resultview);
        edt = (EditText)findViewById(R.id.Entertainmentinput);
        no = (TextView) findViewById(R.id.nameoutput);
        helm = (EditText)findViewById(R.id.helminput);
        po = (TextView)findViewById(R.id.resultprice);
        td = (Button)findViewById(R.id.btntestdrive);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String licenseformat = "[A-Z]+ [0-9]{1,4}+ [A-Z]{1,3}+";
                String string1 = new String("motor");
                String string2 = new String("mobil");
                String suv = new String("suv");
                String minivan = new String("minivan");
                String supercar = new String("supercar");
                String auto = new String("automatic");
                String manual = new String("manual");
                String tp = type.getText().toString().toLowerCase();
                String text = tipe.getText().toString().toLowerCase();
                if (!text.equals(string1) && !text.equals(string2)) {
                    tipe.setError("Error Tipe!!!");
                    tipe.requestFocus();
                    result.setText(""); po.setText(""); no.setText("");
                    contentView3.setVisibility(View.GONE);
                }
                else {result.setText(""); po.setText(""); no.setText("");
                    if (text.equals(string1)) {
                        helm.setText("0");
                        price.setText("0");
                        speed.setText("0");
                        gas.setText("0");
                        wheel.setText("0");
                        brand.setText("");
                        name.setText("");
                        license.setText("");
                        type.setText("");
                        tv1 = (TextView) findViewById(R.id.Entertainmenttext);
                        tv1.setText("Helm: ");
                        tv2 = (TextView) findViewById(R.id.typetext);
                        tv2.setText("Type [Automatic/Manual]: ");
                        contentView1.setVisibility(View.VISIBLE);
                        contentView2.setVisibility(View.VISIBLE);
                        contentView4.setVisibility(View.VISIBLE);
                        contentView5.setVisibility(View.VISIBLE);
                        contentView6.setVisibility(View.GONE);
                        contentView7.setVisibility(View.GONE);
                        edt.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED);

                        btnsubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int speedint = Integer.parseInt(speed.getText().toString());
                                int gasint = Integer.parseInt(gas.getText().toString());
                                int wheelint = Integer.parseInt(wheel.getText().toString());
                                int helmint = Integer.parseInt(helm.getText().toString());

                                result.setText(""); po.setText(""); no.setText("");
                                if(brand.getText().toString().length()<5){
                                    brand.setError("Mininal 5 Character!!!");
                                    brand.requestFocus();
                                    result.setText(""); po.setText(""); no.setText("");
                                    contentView3.setVisibility(View.GONE);
                                }
                                 if(name.getText().toString().length()<5){
                                    name.setError("Minimal 5 Character!!!");
                                    name.requestFocus();
                                     result.setText(""); po.setText(""); no.setText("");
                                     contentView3.setVisibility(View.GONE);
                                }
                                 if(speedint<100 || speedint>250){
                                    speed.setError("Speed Minimum 100 & Maximum 250");
                                    speed.requestFocus();
                                     result.setText(""); po.setText(""); no.setText("");
                                     contentView3.setVisibility(View.GONE);
                                }
                                 if(gasint<30 || gasint>60){
                                    gas.setError("Gas Capacity Minimum 30 & Maximum 60");
                                    gas.requestFocus();
                                     result.setText(""); po.setText(""); no.setText("");
                                     contentView3.setVisibility(View.GONE);
                                 }
                                 if(wheelint<2 || wheelint>3){
                                     wheel.setError("Wheel Minimum 2 & Maximum 3");
                                    wheel.requestFocus();
                                     result.setText(""); po.setText(""); no.setText("");
                                     contentView3.setVisibility(View.GONE);
                                 }
                                 if(helmint<1){
                                     helm.setError("Helm Minimum 1");
                                     helm.requestFocus();
                                     result.setText(""); po.setText(""); no.setText("");
                                     contentView3.setVisibility(View.GONE);
                                 }
                                if(!license.getText().toString().toUpperCase().matches(licenseformat)){
                                    license.setError("License must begin with one letter + space + number at least 1 & a maximum of 4 + space + letter at least 1 & a maximum of 3.");
                                    license.requestFocus();
                                    result.setText(""); po.setText(""); no.setText("");
                                    contentView3.setVisibility(View.GONE);
                                }
                                if(type.getText().toString().length()<6 || type.getText().toString().length()>9){
                                    type.setError("Type should be Automatic or Manual");
                                    type.requestFocus();
                                    result.setText(""); po.setText(""); no.setText("");
                                    contentView3.setVisibility(View.GONE);
                                }

                                else if(brand.getText().toString().length()>4
                                        && name.getText().toString().length()>4
                                        && speedint>99 && speedint<251 && gasint>29 && gasint<61 && wheelint>1 && wheelint<4
                                        && helmint>0 && license.getText().toString().toUpperCase().matches(licenseformat) && type.getText().toString().length()>5 || type.getText().toString().length()<10
                                        && tp.equals(auto)){

                                    no.setText("Motorcycle" + " " + name.getText().toString());

                                    result.setText("Brand: " + brand.getText().toString() + "\n"
                                            + "Name: " + name.getText().toString() + "\n"
                                            + "License Plate: " + license.getText().toString().toUpperCase() + "\n"
                                            + "Type: " + type.getText().toString() + "\n"
                                            + "Gas Capacity: " + gas.getText().toString() + "\n"
                                            + "Top Speed: " + speed.getText().toString() + "\n"
                                            + "Wheel(s): " + wheel.getText().toString() + "\n"
                                            + "Helm: " + helm.getText().toString() + "\n\n"
                                    );
                                    po.setText("");
                                    contentView3.setVisibility(View.VISIBLE);
                                }
                            }
                        });

                        td.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int helmint = Integer.parseInt(helm.getText().toString());
                                int priceint = Integer.parseInt(price.getText().toString());
                                pricetotal = helmint * priceint;
                                result.setText("Brand: " + brand.getText().toString() + "\n"
                                        + "Name: " + name.getText().toString() + "\n"
                                        + "License Plate: " + license.getText().toString() + "\n"
                                        + "Type: " + type.getText().toString() + "\n"
                                        + "Gas Capacity: " + gas.getText().toString() + "\n"
                                        + "Top Speed: " + speed.getText().toString() + "\n"
                                        + "Wheel(s): " + wheel.getText().toString() + "\n"
                                        + "Helm: " + helm.getText().toString() + "\n\n"
                                        + "Price ");
                                po.setText("Rp " + pricetotal);
                                Toast.makeText(getApplicationContext(),name.getText().toString() + " is standing!", Toast.LENGTH_SHORT).show();
                            }
                        });

                    } else if (text.equals(string2)) {contentView3.setVisibility(View.GONE);
                        speed.setText("0");
                        gas.setText("0");
                        wheel.setText("0");
                        edt.setText("0");
                        brand.setText("");
                        name.setText("");
                        license.setText("");
                        type.setText("");
                        tv1 = (TextView) findViewById(R.id.Entertainmenttext);
                        tv1.setText("Entertainment System Amount: ");
                        tv2 = (TextView) findViewById(R.id.typetext);
                        tv2.setText("Type [SUV/Supercar/Minivan]: ");
                        contentView1.setVisibility(View.GONE);
                        contentView2.setVisibility(View.GONE);
                        contentView4.setVisibility(View.GONE);
                        contentView5.setVisibility(View.GONE);
                        contentView6.setVisibility(View.VISIBLE);
                        contentView7.setVisibility(View.VISIBLE);

                        btnsubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int speedint = Integer.parseInt(speed.getText().toString());
                                int gasint = Integer.parseInt(gas.getText().toString());
                                int wheelint = Integer.parseInt(wheel.getText().toString());
                                int edtint = Integer.parseInt(edt.getText().toString());

                                result.setText(""); po.setText(""); no.setText("");

                                if(brand.getText().toString().length()<5){
                                    brand.setError("Mininal 5 Character!!!");
                                    brand.requestFocus();
                                    result.setText(""); po.setText(""); no.setText("");
                                    contentView3.setVisibility(View.GONE);
                                }
                                if(name.getText().toString().length()<5){
                                    name.setError("Minimal 5 Character!!!");
                                    name.requestFocus();
                                    result.setText(""); po.setText(""); no.setText("");
                                    contentView3.setVisibility(View.GONE);
                                }
                                if(speedint<100 || speedint>250){
                                    speed.setError("Speed Minimum 100 & Maximum 250");
                                    speed.requestFocus();
                                    result.setText(""); po.setText(""); no.setText("");
                                    contentView3.setVisibility(View.GONE);
                                }
                                if(gasint<30 || gasint>60){
                                    gas.setError("Gas Capacity Minimum 30 & Maximum 60");
                                    gas.requestFocus();
                                    result.setText(""); po.setText(""); no.setText("");
                                    contentView3.setVisibility(View.GONE);
                                }
                                if(wheelint<4 || wheelint>6){
                                    wheel.setError("Wheel Minimum 4 & Maximum 6");
                                    wheel.requestFocus();
                                    result.setText(""); po.setText(""); no.setText("");
                                    contentView3.setVisibility(View.GONE);
                                }
                                if(edtint<1){
                                    edt.setError("Entertainment system Minimum 1");
                                    edt.requestFocus();
                                    result.setText(""); po.setText(""); no.setText("");
                                    contentView3.setVisibility(View.GONE);
                                }
                                if(!license.getText().toString().toUpperCase().matches(licenseformat)){
                                    license.setError("License must begin with one letter + space + number at least 1 & a maximum of 4 + space + letter at least 1 & a maximum of 3.");
                                    license.requestFocus();
                                    result.setText(""); po.setText(""); no.setText("");
                                    contentView3.setVisibility(View.GONE);
                                }
                                if(type.getText().toString().length()<3 || type.getText().toString().length()>8){
                                    type.setError("Type should be SUV / Supercar / Minivan");
                                    type.requestFocus();
                                    result.setText(""); po.setText(""); no.setText("");
                                    contentView3.setVisibility(View.GONE);
                                }

                                else if(brand.getText().toString().length()>4 && name.getText().toString().length()>4
                                        && speedint>99 && speedint<251 && gasint>29 && gasint<61 && wheelint>3 && wheelint<7 && edtint>0
                                        && license.getText().toString().toUpperCase().matches(licenseformat)
                                        && type.getText().toString().length()>2){

                                    no.setText("Car" + " " + name.getText().toString());

                                    result.setText("Brand: " + brand.getText().toString() + "\n"
                                            + "Name: " + name.getText().toString() + "\n"
                                            + "License Plate: " + license.getText().toString().toUpperCase() + "\n"
                                            + "Type: " + type.getText().toString() + "\n"
                                            + "Gas Capacity: " + gas.getText().toString() + "\n"
                                            + "Top Speed: " + speed.getText().toString() + "\n"
                                            + "Wheel(s): " + wheel.getText().toString() + "\n"
                                            + "Entertainment System: " + esa.getText().toString() + "\n");

                                    contentView3.setVisibility(View.VISIBLE);
                                }
                            }
                        });
                        td.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (type.getText().toString().toUpperCase().equals("SUV") || type.getText().toString().toUpperCase().equals("MINIVAN")) {
                                    Toast.makeText(getApplicationContext(), "Turning on entertainment system " + edt.getText().toString(), Toast.LENGTH_SHORT).show();
                                }
                                else if(type.getText().toString().toUpperCase().equals("SUPERCAR")){
                                    Toast.makeText(getApplicationContext(), "Turning on entertainment system " + edt.getText().toString(), Toast.LENGTH_SHORT).show();
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(getApplicationContext(), "Boosting!", Toast.LENGTH_SHORT).show();
                                        }
                                    },2000);
                                }
                            }
                        });
                    }
                }
            }
        });
    }
}