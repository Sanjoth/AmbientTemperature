# ![alt text](https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png) Ambient Weather Monitor
### Department	of	Computer	Science	and	Engineering, Sharda University
### Tinkering Lab – 2nd	Year
#### Mentor:	Prof.	Ishan	Ranjan (Head of Department, CSE)
#### April,	2016
![](AmbientWeather.png)
---
## ACKNOWLEDGEMENT
Working on this project on Internet of Things was a source of immense knowledge to me. I would like express my sincere gratitude to Prof. Ishan Ranjan for his guidance and valuable support throughout the course of this project work. I acknowledge with deep sense of gratitude, the encouragement and inspiration received from my faculty members and colleagues. I would also like to thank my friends for helping and supporting throughout the preparation of this project work. Altogether, it was a great experience.

## SUMMARY

The Internet of Things (IoT) is the network of physical objects (devices, vehicles, buildings and other items) embedded with electronics, software, sensors, and network connectivity that enables these objects to collect and exchange data.

An Arduino Uno board will be used as a programmable interface which will be used to send & receive data. We will be taking ambient temperature from a LM35 temperature sensor and the data received will be sent to a Dedicated Server using UDP Socket connection.

The temperature readings received from the sensor will then be tabulated in a MySQL Database and shown in a website which can be accessed by anyone having an active internet connection. These readings can then be used to send a signal back to the Uno board which will give instruction to do a specific task if a device is connected to it.


## REQUIREMENTS
### Hardware Prerequisites
    • Arduino Uno R3 Board (1)
    • Temperature Sensor LM-35 (1)
    • Regulated Power Supply Board RSI-67 (1)
    • Wi-Fi Module ESP8266 (1)
    • SMPS Adapter 1A (2)
    • Connecting Wires (14)

### Software Prerequisites
    • Java 5+
    • Sevlets & JSP
    • MySQL
    • Internet Connectivity in Arduino & Server
    
## WORKING
    • Data will be collected from the LM35 temperature sensor and sent to the Arduino interface.
    • A Wi-Fi module (ESP8266) will be connected to the Arduino Uno which will then take the data and connect to a pre-configured Access Point.
    • The data will then be sent from the Access Point to the specified Dedicated Server.
    • The Dedicated Server will receive the data & organize them into a database using MySQL with date & time.
    • The Table will then be shown in a website which then be accessed via Internet.
    • The output can then be used for analytics and decision making. 
    
### MAIN SOFTWARE FILES
##### Java Connection Handler for JDBC MySQL connection
```sh
SocketData/src/socketdata/database/ConnectionHandler.java
```
#### UDP Socket
```sh
SocketData/src/socketdata/UDPSocket.java
```
#### CRUD Operation
```sh
SocketData/src/socketdata/database/CurdOpertaion.java
```
#### Project's MVC
```sh
MyProject/web/Now.jsp
MyProject/web/index.html
```
#### Embedded Application (Arduino)
```sh
SmartTempMonitor.ino
```

## A FEW REAL WORLD APPLICATIONS
    • Sending and receiving any sensor related data and uploading it to the internet for analytics.
    • Controlling the connected devices online from anywhere.
    • Remote Area Monitoring


