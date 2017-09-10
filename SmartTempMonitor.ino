/*
 * Author: Sanjoth Shaw
 * Purpose: Sending temperature data continously to a dedicated server using UDP protocol.
 * Language: C
 * Harware : Arduino UNO w/ LM35 (Temperature), ESP8266 (Wi-Fi module)
 */

#include <SoftwareSerial.h>
#include <stdlib.h>

// LED
int ledPin = 13;
// LM35 analog input
int lm35Pin = 0;


// connect 10 to TX of Serial USB
// connect 11 to RX of serial USB
SoftwareSerial ser(10, 11); // RX, TX

// this runs once
void setup() {
  // initialize the digital pin as an output.
  pinMode(ledPin, OUTPUT);

  // enable debug serial
  Serial.begin(9600);
  // enable software serial
  ser.begin(9600);

  // reset ESP8266
  ser.println("AT+RST");
  delay(5000);
}


// the loop
void loop() {

  // blink LED on board
  digitalWrite(ledPin, HIGH);
  delay(200);
  digitalWrite(ledPin, LOW);

  // read the value from LM35.
  // read 10 values for averaging.
  int val = 0;
  for(int i = 0; i < 10; i++) {
      val += analogRead(lm35Pin);
      delay(500);
  }

  // convert to temp:
  // temp value is in 0-1023 range
  // LM35 outputs 10mV/degree C. ie, 1 Volt => 100 degrees C
  // So Temp = (avg_val/1023)*5 Volts * 100 degrees/Volt
  float temp = val*50.0f/1023.0f;

  // convert to string
  char buf[16];
  String strTemp = dtostrf(temp, 4, 1, buf);

  String Label = "Module 1(Room1 Temp), Temp: ";
  Label += strTemp;

  Serial.println(Label);

  // UDP connection
  String cmd = "AT+CIPSTART=\"UDP\",\"";
  cmd += "125.99.18.41"; // IP on which data is to be sent
  cmd += "\",32000";
  ser.println(cmd);

  if(ser.find("Error")){
    Serial.println("AT+CIPSTART error");
    return;
  }


  // send data length
  cmd = "AT+CIPSEND=";
  cmd += String(Label.length());
  ser.println(cmd);

  delay(2000);

  if(ser.find(">")){
    ser.print(Label);
  }
  else{
    ser.println("AT+CIPCLOSE");
    // alert user
    ser.println("AT+RST");
    delay(5000);
    Serial.println("AT+CIPCLOSE");
  }


  delay(2000);
}
